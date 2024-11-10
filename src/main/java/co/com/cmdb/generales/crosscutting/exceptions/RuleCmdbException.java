package co.com.cmdb.generales.crosscutting.exceptions;

import co.com.cmdb.generales.crosscutting.exceptions.enums.Layer;

public class RuleCmdbException extends CmdbException {

	private static final long serialVersionUID = 1L;

	public RuleCmdbException(final String technicalMessage, final String userMessage, final Exception rootException) {
		super(technicalMessage, userMessage, Layer.RULE, rootException);
	}
	
	public static final RuleCmdbException create( final String userMessage,final String technicalMessage, final Exception rootException) {
		
		return new RuleCmdbException( userMessage,technicalMessage, rootException);
		
	}
	
	public static final RuleCmdbException create(final String userMessage, final Exception rootException) {
		
		return new RuleCmdbException(userMessage, userMessage, rootException);
		
	}
	
	public static final RuleCmdbException create( final String userMessage,final String technicalMessage) {
		
		return new RuleCmdbException( userMessage,technicalMessage, new Exception());
		
	}
	
	public static final RuleCmdbException create(final String userMessage) {
		
		return new RuleCmdbException(userMessage, userMessage, new Exception());
		
	}
	
	
	
	
	

}
