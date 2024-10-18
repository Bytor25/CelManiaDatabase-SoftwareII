package co.com.cmdb.generales.crosscutting.exceptions;

import co.com.cmdb.generales.crosscutting.exceptions.enums.Layer;

public class DomainCmdbException extends CmdbException {

	private static final long serialVersionUID = 1L;

	public DomainCmdbException(final String technicalMessage, final String userMessage, final Exception rootException) {
		super(technicalMessage, userMessage, Layer.DOMAIN, rootException);
	}
	
	public static DomainCmdbException create(final String technicalMessage, final String userMessage, final Exception rootException) {
		
		return new DomainCmdbException(technicalMessage, userMessage, rootException);
		
	}
	
	public static DomainCmdbException create(final String userMessage, final Exception rootException) {
		
		return new DomainCmdbException(userMessage, userMessage, rootException);
		
	}
	
	public static DomainCmdbException create(final String technicalMessage, final String userMessage) {
		
		return new DomainCmdbException(technicalMessage, userMessage, new Exception());
		
	}
	
	public static DomainCmdbException create(final String userMessage) {
		
		return new DomainCmdbException(userMessage, userMessage, new Exception());
		
	}
	
	
	
	
	

}
