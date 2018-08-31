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
		
//		Path newPath1 = Paths.get(newFileName1);
		List<String> stringArray = new ArrayList<>();
		try (Stream<String> streams = Files.lines(Paths.get(fileName))) {
			stringArray = streams.collect(Collectors.toList());

			String quoteString = "";
			for(String item : stringArray){
				if (item.equals("")) {
					quoteRepository.save(new Quote(quoteString));
					quoteString = "";
//					System.out.println("delete line");
				}
				quoteString = quoteString + item;
			}
			

		} catch (IOException e) {
			e.printStackTrace();
		}    
		
		System.out.println(quoteRepository.findAll());
    }
}
