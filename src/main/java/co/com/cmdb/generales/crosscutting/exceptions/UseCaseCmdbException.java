package co.com.cmdb.generales.crosscutting.exceptions;

import co.com.cmdb.generales.crosscutting.exceptions.enums.Layer;

public class UseCaseCmdbException extends CmdbException {

	private static final long serialVersionUID = 1L;

	public UseCaseCmdbException(final String technicalMessage, final String userMessage, final Exception rootException) {
		super(technicalMessage, userMessage, Layer.USECASE, rootException);
	}
	
	public static UseCaseCmdbException create(final String technicalMessage, final String userMessage, final Exception rootException) {
		
		return new UseCaseCmdbException(technicalMessage, userMessage, rootException);
		
	}
	
	public static UseCaseCmdbException create(final String userMessage, final Exception rootException) {
		
		return new UseCaseCmdbException(userMessage, userMessage, rootException);
		
	}
	
	public static UseCaseCmdbException create(final String technicalMessage, final String userMessage) {
		
		return new UseCaseCmdbException(technicalMessage, userMessage, new Exception());
		
	}
	
	public static UseCaseCmdbException create(final String userMessage) {
		
		return new UseCaseCmdbException(userMessage, userMessage, new Exception());
		
	}
	
	
	
	
	

}
