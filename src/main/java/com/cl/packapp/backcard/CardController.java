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

import com.cl.packapp.backcard.dao.CardRepository;
import com.cl.packapp.backcard.model.Card;

@RestController
public class CardController {
	
	@Autowired
	private CardRepository repository;
	
	
	@RequestMapping(value="/card/{id}", method=RequestMethod.GET)
	public ResponseEntity viewCardById(@PathVariable("id") String id) {
		
		Optional<Card> card = repository.findById(id);
		
		if (card==null || !card.isPresent()	) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Card>(card.get(), HttpStatus.OK);
		}
		
		
	}
	
	@RequestMapping(value="/card/customer/{customerID}", method=RequestMethod.GET)
	public List<Card> viewCardByCustomerID(@PathVariable("customerID") String customerID) {
		
		return repository.findByCustomerID(customerID);
	}
	
	
	@RequestMapping(value="/card", method=RequestMethod.POST)
	public ResponseEntity<?> editCard(@RequestBody Card card, UriComponentsBuilder ucBuilder) {
		
		card = repository.save(card);
		
		System.out.println("---- Card " + card.getId() + " added");
		
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/card/{id}").buildAndExpand(card.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value="/card/{id}", method=RequestMethod.PUT)
	public ResponseEntity<?> editCard(@PathVariable("id") String id, @RequestBody Card card, UriComponentsBuilder ucBuilder) {
		
		card = repository.save(card);
		
		System.out.println("---- Card " + card.getId() + " edited");
		
        return new ResponseEntity<Card>(card, HttpStatus.OK);
	}
	
	@RequestMapping(value="/card/{idcard}/payment/{idpayment}", method=RequestMethod.PUT)
	public ResponseEntity<?> addPaymentOnCard(@PathVariable("idcard") String idcard, @PathVariable("idpayment") String idpayment,  UriComponentsBuilder ucBuilder) {
		
		Optional<Card> card = repository.findById(idcard);
		
		if (card==null || !card.isPresent()	) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		} else {
			
			List<String> listPayment = card.get().getPaymentIDList();
			listPayment.add(idpayment);
			repository.save(card.get());
			
			System.out.println("---- Payment added on " + card.get().getId());
			
			return new ResponseEntity<Card>(card.get(), HttpStatus.OK);
		}
	}
}
