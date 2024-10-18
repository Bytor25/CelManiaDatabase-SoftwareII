package co.com.cmdb.generales.crosscutting.exceptions;

import co.com.cmdb.generales.crosscutting.exceptions.enums.Layer;

public class DtoCmdbException extends CmdbException {

	private static final long serialVersionUID = 1L;

	public DtoCmdbException(final String technicalMessage, final String userMessage, final Exception rootException) {
		super(technicalMessage, userMessage, Layer.DTO, rootException);
	}
	
	public static DtoCmdbException create(final String technicalMessage, final String userMessage, final Exception rootException) {
		
		return new DtoCmdbException(technicalMessage, userMessage, rootException);
		
	}
	
	public static DtoCmdbException create(final String userMessage, final Exception rootException) {
		
		return new DtoCmdbException(userMessage, userMessage, rootException);
		
	}
	
	public static DtoCmdbException create(final String technicalMessage, final String userMessage) {
		
		return new DtoCmdbException(technicalMessage, userMessage, new Exception());
		
	}
	
	public static DtoCmdbException create(final String userMessage) {
		
		return new DtoCmdbException(userMessage, userMessage, new Exception());
		
	}
	
	
	
	
	

}
