
package com.cl.packapp.backcard.model;

import org.springframework.data.annotation.Id;

/**
 * @author fhippolyte
 */

public class CardType{
	
	@Id
    private String id;
	private String label;
	
    public CardType() {
    	
    }
    
    public CardType(String id, String label) {
    	this.id = id;
    	this.label = label;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
    
    
	
}
