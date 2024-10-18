package co.com.cmdb.generales.crosscutting.exceptions;

import co.com.cmdb.generales.crosscutting.exceptions.enums.Layer;

public class ApplicationCmdbException extends CmdbException {

	private static final long serialVersionUID = 1L;

	public ApplicationCmdbException(final String technicalMessage, final String userMessage, final Exception rootException) {
		super(technicalMessage, userMessage, Layer.APPLICATION, rootException);
	}
	
	public static ApplicationCmdbException create(final String technicalMessage, final String userMessage, final Exception rootException) {
		
		return new ApplicationCmdbException(technicalMessage, userMessage, rootException);
		
	}
	
	public static ApplicationCmdbException create(final String userMessage, final Exception rootException) {
		
		return new ApplicationCmdbException(userMessage, userMessage, rootException);
		
	}
	
	public static ApplicationCmdbException create(final String technicalMessage, final String userMessage) {
		
		return new ApplicationCmdbException(technicalMessage, userMessage, new Exception());
		
	}
	
	public static ApplicationCmdbException create(final String userMessage) {
		
		return new ApplicationCmdbException(userMessage, userMessage, new Exception());
		
	}
	
	
	
	
	

}
