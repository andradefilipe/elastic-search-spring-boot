package com.andrade.email.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.andrade.springboot.web.model.Email;

public interface EmailRepository extends ElasticsearchRepository<Email, String> {
	List<Email> findByText(String text);
	List<Email> findBySender(String text);
}