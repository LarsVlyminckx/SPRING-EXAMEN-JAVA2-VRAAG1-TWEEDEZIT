package edu.ap.spring.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.TransferHandler;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.ap.spring.jpa.QuoteRepository;

@Component
public class UI implements InitializingBean {

	@Autowired
	EventHandler eventHandler;
	
	@Autowired
	QuoteRepository quoteRepository;
	
	private JFrame jFrame;
	private JPanel controlPanel;
	private JTextField searchQuote;
    private JButton btnImportQuotes, btnSearch;
    
    private JTextArea quotes, searchedQuotes;
    
    public void setupUI() {
	    jFrame = new JFrame("Spring JFrame");
	    jFrame.setLayout(new FlowLayout());
	    	
	    controlPanel = new JPanel();
	    controlPanel.setLayout(new GridLayout(4, 2));
	    
	    btnImportQuotes = new JButton();
	    btnImportQuotes.setText("Import quotes");
	    btnImportQuotes.setTransferHandler(new TransferHandler("text"));
	    btnImportQuotes.addActionListener(eventHandler::whenImportButtonClicked);
	    
	    btnSearch = new JButton();
	    btnSearch.setText("Search quotes");
	    btnSearch.setTransferHandler(new TransferHandler("text"));
	    btnSearch.addActionListener(eventHandler::whenSearchButtonClicked);
	    
	    searchQuote = new JTextField();
	    
	    quotes = new JTextArea(); 
	    searchedQuotes = new JTextArea(); 
	    
	    controlPanel.add(btnImportQuotes);
	    controlPanel.add(btnSearch);
	    controlPanel.add(searchQuote);
	    controlPanel.add(quotes);
	    controlPanel.add(searchedQuotes);
	    
		jFrame.add(controlPanel);
		

		jFrame.setPreferredSize(new Dimension(500, 500));
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.pack();
		jFrame.setVisible(true);
    }

    
	
	public JButton getBtnSearch() {
		return btnSearch;
	}



	public void setBtnSearch(JButton btnSearch) {
		this.btnSearch = btnSearch;
	}



	



	public JTextArea getSearchedQuotes() {
		return searchedQuotes;
	}



	public void setSearchedQuotes(JTextArea searchedQuotes) {
		this.searchedQuotes = searchedQuotes;
	}



	public void setQuotes(JTextArea quotes) {
		this.quotes = quotes;
	}



	public JTextArea getQuotes() {
		return quotes;
	}



	public void setgetQuotes(JTextArea jTextArea) {
		this.quotes = jTextArea;
	}



	public EventHandler getEventHandler() {
		return eventHandler;
	}



	public void setEventHandler(EventHandler eventHandler) {
		this.eventHandler = eventHandler;
	}



	public QuoteRepository getQuoteRepository() {
		return quoteRepository;
	}



	public void setQuoteRepository(QuoteRepository quoteRepository) {
		this.quoteRepository = quoteRepository;
	}



	public JFrame getjFrame() {
		return jFrame;
	}



	public void setjFrame(JFrame jFrame) {
		this.jFrame = jFrame;
	}



	public JPanel getControlPanel() {
		return controlPanel;
	}



	public void setControlPanel(JPanel controlPanel) {
		this.controlPanel = controlPanel;
	}



	public JTextField getSearchQuote() {
		return searchQuote;
	}



	public void setSearchQuote(JTextField searchQuote) {
		this.searchQuote = searchQuote;
	}



	public JButton getBtnImportQuotes() {
		return btnImportQuotes;
	}



	public void setBtnImportQuotes(JButton btnImportQuotes) {
		this.btnImportQuotes = btnImportQuotes;
	}



	@Override
	public void afterPropertiesSet() throws Exception {
		System.setProperty("java.awt.headless", "false");
	}
}
