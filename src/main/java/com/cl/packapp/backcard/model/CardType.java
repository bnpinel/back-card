
package com.cl.packapp.backcard.model;

import org.springframework.data.annotation.Id;

/**
 * @author fhippolyte
 */

public class CardType{
	
	@Id
    private String id;
	private String name;
	
    public CardType() {
    	
    }
    
    public CardType(String id, String label) {
    	this.id = id;
    	this.name = label;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
    
	
}
