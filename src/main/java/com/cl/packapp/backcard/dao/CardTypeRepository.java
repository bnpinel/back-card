package com.cl.packapp.backcard.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cl.packapp.backcard.model.CardType;

public interface CardTypeRepository extends MongoRepository<CardType, String> {


	
}
