package com.andrade.springboot.web.service;

import java.util.List;

import com.andrade.springboot.web.model.Email;

public interface EmailService {

    Email save(Email email);

    void delete(Email email);

    Email findOne(String id);

    Iterable<Email> findAll();

    List<Email> findByText(String title);

    List<Email> findBySender(String title);

}