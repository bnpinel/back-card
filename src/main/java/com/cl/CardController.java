package com.cl;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.cl.model.Card;
import com.cl.model.CardType;

@RestController
public class CardController {
	
	@RequestMapping(value="/card", method=RequestMethod.GET)
	public Card viewCard(@RequestParam(value="id", defaultValue="toto") String id) {
		
		return new Card("1", LocalDate.of(2014, Month.FEBRUARY, 2), CardType.VISA, "01");
	}
	
	
	@RequestMapping(value="/card", method=RequestMethod.POST)
	public ResponseEntity<?> editCard(@RequestBody Card card, UriComponentsBuilder ucBuilder) {
		
		System.out.println("---- Card " + card.getId() + " added");
		
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(card.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value="/card/{id}", method=RequestMethod.PUT)
	public ResponseEntity<?> editCard(@PathVariable("id") long id, @RequestBody Card card, UriComponentsBuilder ucBuilder) {
		
		System.out.println("---- Card " + card.getId() + " edited");
		
        return new ResponseEntity<Card>(card, HttpStatus.OK);
	}

}
