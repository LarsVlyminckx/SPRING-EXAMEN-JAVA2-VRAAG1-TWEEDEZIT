package edu.ap.spring.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends CrudRepository<Quote, Long> {
	
	List<Quote> findByQuote(String quote);
}

