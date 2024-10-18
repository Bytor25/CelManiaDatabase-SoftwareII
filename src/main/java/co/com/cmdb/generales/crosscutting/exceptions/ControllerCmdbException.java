package co.com.cmdb.generales.crosscutting.exceptions;

import co.com.cmdb.generales.crosscutting.exceptions.enums.Layer;

public class ControllerCmdbException extends CmdbException {

	private static final long serialVersionUID = 1L;

	public ControllerCmdbException(final String technicalMessage, final String userMessage, final Exception rootException) {
		super(technicalMessage, userMessage, Layer.CONTROLLER, rootException);
	}
	
	public static ControllerCmdbException create(final String technicalMessage, final String userMessage, final Exception rootException) {
		
		return new ControllerCmdbException(technicalMessage, userMessage, rootException);
		
	}
	
	public static ControllerCmdbException create(final String userMessage, final Exception rootException) {
		
		return new ControllerCmdbException(userMessage, userMessage, rootException);
		
	}
	
	public static ControllerCmdbException create(final String technicalMessage, final String userMessage) {
		
		return new ControllerCmdbException(technicalMessage, userMessage, new Exception());
		
	}
	
	public static ControllerCmdbException create(final String userMessage) {
		
		return new ControllerCmdbException(userMessage, userMessage, new Exception());
		
	}
	
	
	
	
	

}

