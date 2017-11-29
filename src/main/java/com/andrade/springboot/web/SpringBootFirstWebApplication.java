package com.andrade.springboot.web;

import java.io.FileInputStream;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

import com.andrade.springboot.web.model.Email;
import com.andrade.springboot.web.service.EmailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mongodb.BasicDBObject;
import com.mongodb.util.JSON;

@SpringBootApplication
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
public class SpringBootFirstWebApplication implements CommandLineRunner{

	@Autowired
	private ElasticsearchOperations es;

	@Autowired
	private EmailService emailService;

	public static void main(String args[]) {
		SpringApplication.run(SpringBootFirstWebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		FileInputStream fileInputStream = null;
		if(args.length != 1) {
			System.err.println("Invalid command line, exactly one argument required");
		}
		else{
			fileInputStream = new FileInputStream(args[0]);
			Scanner scanner = new Scanner(fileInputStream);
			while (scanner.hasNext()) {
				BasicDBObject basicDBObject = (BasicDBObject) JSON.parse(scanner.nextLine());			
				JsonObject jsonObject = new Mongo2gson().getAsJsonObject(basicDBObject);

				Email email = new Gson().fromJson(jsonObject, Email.class);

				emailService.save(email);
			}
			scanner.close();
		}

		System.out.println("----dsadasda----adsaasd");
		List<Email> emails = emailService.findBySender("rosalee.fleming@enron.com");

		emails.forEach(x -> System.out.println(x));
	}

}
