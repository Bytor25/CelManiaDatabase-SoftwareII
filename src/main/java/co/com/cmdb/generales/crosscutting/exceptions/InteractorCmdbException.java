package co.com.cmdb.generales.crosscutting.exceptions;

import co.com.cmdb.generales.crosscutting.exceptions.enums.Layer;

public class InteractorCmdbException extends CmdbException {

	private static final long serialVersionUID = 1L;

	public InteractorCmdbException( final String userMessage, final String technicalMessage,
			final Exception rootException) {
		super( userMessage, technicalMessage, Layer.NOTIFICATION,rootException);
	}
	
	public static final InteractorCmdbException create( final String userMessage,final String technicalMessage, final Exception rootException) {
		
		return new InteractorCmdbException( userMessage,technicalMessage, rootException);
		
	}
	
	public static final InteractorCmdbException create(final String userMessage, final Exception rootException) {
		
		return new InteractorCmdbException(userMessage, userMessage, rootException);
		
	}
	
	public static final InteractorCmdbException create( final String userMessage,final String technicalMessage) {
		
		return new InteractorCmdbException( userMessage,technicalMessage, new Exception());
		
	}
	
	public static final InteractorCmdbException create(final String userMessage) {
		
		return new InteractorCmdbException(userMessage, userMessage, new Exception());
		
	}

}
