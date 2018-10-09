package com.cl.packapp.backcard;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.cl.packapp.backcard.dao.CardTypeRepository;
import com.cl.packapp.backcard.model.CardType;

@RestController
public class CardTypeController {
	
	@Autowired
	private CardTypeRepository repository;
	
	
	@RequestMapping(value="/cardtype/{id}", method=RequestMethod.GET)
	public Optional<CardType> getCardTypeById(@PathVariable("id") String id) {
		return repository.findById(id);
	}
	
	@RequestMapping(value="/cardtype", method=RequestMethod.GET)
	public List<CardType> viewCardByCustomerID() {
		
		return repository.findAll();
	}
	
	
	@RequestMapping(value="/cardtype", method=RequestMethod.POST)
	public ResponseEntity<?> editCard(@RequestBody CardType cardtype, UriComponentsBuilder ucBuilder) {
		
		cardtype = repository.save(cardtype);
		
		System.out.println("---- CardType " + cardtype.getId() + " added");
		
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/cardtype/{id}").buildAndExpand(cardtype.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	

}
