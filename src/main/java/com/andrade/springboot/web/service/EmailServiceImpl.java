package com.andrade.springboot.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrade.email.repository.EmailRepository;
import com.andrade.springboot.web.model.Email;

@Service
public class EmailServiceImpl implements EmailService {

    private EmailRepository emailRepository;

    @Autowired
    public void setEmailRepository(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    public Email save(Email email) {
        return emailRepository.save(email);
    }

    public void delete(Email email) {
        emailRepository.delete(email);
    }

    public Email findOne(String id) {
        return emailRepository.findOne(id);
    }

    public Iterable<Email> findAll() {
        return emailRepository.findAll();
    }

	public List<Email> findByText(String text) {
		return emailRepository.findByText(text);
	}

	@Override
	public List<Email> findBySender(String text) {
		return emailRepository.findBySender(text);

	}

}