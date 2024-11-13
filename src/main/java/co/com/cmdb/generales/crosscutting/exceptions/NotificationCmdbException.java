package co.com.cmdb.generales.crosscutting.exceptions;

import co.com.cmdb.generales.crosscutting.exceptions.enums.Layer;

public class NotificationCmdbException extends CmdbException {

	private static final long serialVersionUID = 1L;

	public NotificationCmdbException( final String userMessage, final String technicalMessage,
			final Exception rootException) {
		super( userMessage, technicalMessage, Layer.INTERACTOR,rootException);
	}
	
	public static final NotificationCmdbException create( final String userMessage,final String technicalMessage, final Exception rootException) {
		
		return new NotificationCmdbException( userMessage,technicalMessage, rootException);
		
	}
	
	public static final NotificationCmdbException create(final String userMessage, final Exception rootException) {
		
		return new NotificationCmdbException(userMessage, userMessage, rootException);
		
	}
	
	public static final NotificationCmdbException create( final String userMessage,final String technicalMessage) {
		
		return new NotificationCmdbException( userMessage,technicalMessage, new Exception());
		
	}
	
	public static final NotificationCmdbException create(final String userMessage) {
		
		return new NotificationCmdbException(userMessage, userMessage, new Exception());
		
	}

}
