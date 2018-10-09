package com.cl.packapp.backcard.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cl.packapp.backcard.model.Card;

public interface CardRepository extends MongoRepository<Card, String> {

	public List<Card> findByCustomerID(String customerID);
	
}
