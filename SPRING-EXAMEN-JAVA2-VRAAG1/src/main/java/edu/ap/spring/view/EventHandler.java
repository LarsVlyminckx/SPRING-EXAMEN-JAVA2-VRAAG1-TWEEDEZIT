package edu.ap.spring.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import edu.ap.spring.jpa.Quote;
import edu.ap.spring.jpa.QuoteRepository;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.DefaultListModel;
import javax.swing.JList;
@Service
public class EventHandler {
	
	private UI ui;
    private QuoteRepository quoteRepository;
    

    
    @Autowired
    public void setRepository(QuoteRepository quoteRepository) {
    		this.quoteRepository = quoteRepository;
    }
    
    @Autowired
    public void setUI(UI ui) {
    		this.ui = ui;
    }

    public void whenImportButtonClicked(ActionEvent actionEvent) {
		String fileName = "oscar_wilde.txt";
		
		List<String> stringArray = new ArrayList<>();
		try (Stream<String> streams = Files.lines(Paths.get(fileName))) {
			stringArray = streams.collect(Collectors.toList());
			String quoteString = "";
			for(String item : stringArray){
				if (item.equals("")) {
					quoteRepository.save(new Quote(quoteString));
					quoteString = "";
				}
				quoteString = quoteString + item;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}    
    }
    
    public void whenSearchButtonClicked(ActionEvent actionEvent) {
		String searchedQuote = ui.getSearchQuote().getText();
		
		List<Quote> quotes = quoteRepository.findAll();
		
		for (Quote quote : quotes) {
			if (quote.toString().contains(searchedQuote)) {
				System.out.println(quote);
			}
		}	
    }
}
