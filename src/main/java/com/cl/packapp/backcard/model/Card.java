
package com.cl.packapp.backcard.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;

/**
 * Simple business object representing a card.
 *
 * @author Wavestone
 */
public class Card  {


	@Id
    private String id;
	private LocalDate expiryDate;
    private String cardTypeID;
    private String customerID;
    private List<String> paymentIDList;
    
    public Card() {
    	
    }
    
    public Card(String id, LocalDate expiryDate, String cardTypeID, String customerID) {
    	this.id = id;
    	this.expiryDate = expiryDate;
    	this.cardTypeID = cardTypeID;
    	this.customerID = customerID;
    }
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public List<String> getPaymentIDList() {
		return paymentIDList;
	}
	public void setPaymentIDList(List<String> paymentIDList) {
		this.paymentIDList = paymentIDList;
	}
	public String getCardTypeID() {
		return cardTypeID;
	}
	public void setCardTypeID(String cardTypeID) {
		this.cardTypeID = cardTypeID;
	}




}
