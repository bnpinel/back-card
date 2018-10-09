
package com.cl.model;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Simple business object representing a card.
 *
 * @author Wavestone
 */
public class Card  {


    private String id;
	private LocalDate expiryDate;
    private int cardType;
    private String customerID;
    private List<String> paymentIDList;
    
    public Card(String id, LocalDate expiryDate, int cardType, String customerID) {
    	this.id = id;
    	this.expiryDate = expiryDate;
    	this.cardType = cardType;
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
	public int getCardType() {
		return cardType;
	}
	public void setCardType(int cardType) {
		this.cardType = cardType;
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




}
