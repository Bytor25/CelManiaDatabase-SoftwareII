package co.com.cmdb.generales.crosscutting.exceptions;

import co.com.cmdb.generales.crosscutting.exceptions.enums.Layer;

public class DataCmdbException extends CmdbException {

	private static final long serialVersionUID = 1L;

	public DataCmdbException(final String technicalMessage, final String userMessage, final Exception rootException) {
		super(technicalMessage, userMessage, Layer.DATA, rootException);
	}
	
	public static DataCmdbException create(final String technicalMessage, final String userMessage, final Exception rootException) {
		
		return new DataCmdbException(technicalMessage, userMessage, rootException);
		
	}
	
	public static DataCmdbException create(final String userMessage, final Exception rootException) {
		
		return new DataCmdbException(userMessage, userMessage, rootException);
		
	}
	
	public static DataCmdbException create(final String technicalMessage, final String userMessage) {
		
		return new DataCmdbException(technicalMessage, userMessage, new Exception());
		
	}
	
	public static DataCmdbException create(final String userMessage) {
		
		return new DataCmdbException(userMessage, userMessage, new Exception());
		
	}
	
	
	
	
	

}
