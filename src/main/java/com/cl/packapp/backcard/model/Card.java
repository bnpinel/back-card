
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
	private String birthDate;
    private String cardTypeID;
    private String customerID;
    private List<String> paymentIDList;
    
    public Card() {
    	
    }
    
    public Card(String id, String birthDate, String cardTypeID, String customerID) {
    	this.id = id;
    	this.birthDate = birthDate;
    	this.cardTypeID = cardTypeID;
    	this.customerID = customerID;
    }
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

}
