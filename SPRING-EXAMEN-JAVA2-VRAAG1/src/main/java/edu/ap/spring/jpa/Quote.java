package edu.ap.spring.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Quote {
	
	   @Id
	   @GeneratedValue
	   private Long id;
	   
	   @Column
	   private String quote;

	public Quote() {
	}

	public Quote(String quote) {
		this.quote = quote;
	}

	@Override
	public String toString() {
		return "Quote [id=" + id + ", quote=" + quote + "]";
	}
	   
	
}
