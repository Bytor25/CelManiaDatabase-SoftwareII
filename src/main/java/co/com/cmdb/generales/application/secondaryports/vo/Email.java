package co.com.cmdb.generales.application.secondaryports.vo;

import java.io.File;
import java.util.List;

import co.com.cmdb.generales.crosscutting.helpers.TextHelper;

public class Email {
	
	private String message;
	private List<File> file;
	
	public Email(final String message, final List<File> file) {
		
		super();
		this.message = message;
		this.file = file;
		
	}
	
	public static Email create(final String message) {
		
        return new Email(message, null);
        
	}
    
    public static Email create(final String message, final List<File> file) {
    	
    	return new Email(message, file);
    	
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = TextHelper.applyTrim(message);
	}

	public List<File> getFile() {
		return file;
	}

	public void setFile(List<File> file) {
		this.file = file;
	}
    
    
	
	
	
}
