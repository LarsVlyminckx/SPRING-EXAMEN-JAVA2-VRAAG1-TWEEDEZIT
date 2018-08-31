package edu.ap.spring.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.TransferHandler;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UI implements InitializingBean {

	@Autowired
	EventHandler eventHandler;
	
	
	private JFrame jFrame;
	private JPanel controlPanel;

	private JTextField searchQuote;
    private JButton btnImportQuotes;
    
    public void setupUI() {
	    jFrame = new JFrame("Spring JFrame");
	    jFrame.setLayout(new FlowLayout());
	    	
	    controlPanel = new JPanel();
	    controlPanel.setLayout(new GridLayout(4, 2));
	    
	    btnImportQuotes = new JButton();
	    btnImportQuotes.setText("Import quotes");
	    btnImportQuotes.setTransferHandler(new TransferHandler("text"));
	    btnImportQuotes.addActionListener(eventHandler::whenImportButtonClicked);
	    
	    controlPanel.add(btnImportQuotes);

		jFrame.add(controlPanel);
		        
		jFrame.setSize(400, 400);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.pack();
		jFrame.setVisible(true);
    }

	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.setProperty("java.awt.headless", "false");
	}
}
