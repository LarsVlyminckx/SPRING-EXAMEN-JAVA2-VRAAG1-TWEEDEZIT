package edu.ap.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import edu.ap.spring.view.UI;

@SpringBootApplication
public class QuoteApplication {
	
	@Autowired
	UI ui;

	@Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return (args) -> {
		};
    }
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(QuoteApplication.class).headless(false).run(args);
	}
}