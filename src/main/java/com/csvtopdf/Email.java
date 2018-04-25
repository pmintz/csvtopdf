package com.csvtopdf;

import java.awt.Desktop;
import java.beans.EventHandler;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

//import com.itext.tool.xml.html.HTML;
//import javax.swing.text.html.HTML;

public class Email {
	
	String uri;
	//HTML link = new HTML();
	
	
	public String getUri() {
		return uri;
	}


	public String setUri(String uri) throws URISyntaxException, IOException {
		new Email(uri);
		this.uri = uri;
		return uri;
	}


	Email(String uri) throws URISyntaxException, IOException{
		URI email = new URI(uri);
		Desktop.getDesktop().browse(email);
	/*	link.setText("http://www.yahoo.com");
		link.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent e) {
		        
		    }
		});*/
	}
	
	


}
