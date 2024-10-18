package co.com.cmdb.generales.crosscutting.exceptions;

import co.com.cmdb.generales.crosscutting.exceptions.enums.Layer;

public class CrosscuttingCmdbException extends CmdbException {

	private static final long serialVersionUID = 1L;

	public CrosscuttingCmdbException(final String technicalMessage, final String userMessage, final Exception rootException) {
		super(technicalMessage, userMessage, Layer.CROSSCUTTING, rootException);
	}
	
	public static CrosscuttingCmdbException create(final String technicalMessage, final String userMessage, final Exception rootException) {
		
		return new CrosscuttingCmdbException(technicalMessage, userMessage, rootException);
		
	}
	
	public static CrosscuttingCmdbException create(final String userMessage, final Exception rootException) {
		
		return new CrosscuttingCmdbException(userMessage, userMessage, rootException);
		
	}
	
	public static CrosscuttingCmdbException create(final String technicalMessage, final String userMessage) {
		
		return new CrosscuttingCmdbException(technicalMessage, userMessage, new Exception());
		
	}
	
	public static CrosscuttingCmdbException create(final String userMessage) {
		
		return new CrosscuttingCmdbException(userMessage, userMessage, new Exception());
		
	}
	
	
	
	
	

}

