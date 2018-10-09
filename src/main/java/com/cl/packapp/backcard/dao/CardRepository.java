package com.cl.packapp.backcard.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cl.packapp.backcard.model.Card;

public interface CardRepository extends MongoRepository<Card, String> {

}
