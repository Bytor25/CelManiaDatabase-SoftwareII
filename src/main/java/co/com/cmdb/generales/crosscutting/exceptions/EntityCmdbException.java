package co.com.cmdb.generales.crosscutting.exceptions;

import co.com.cmdb.generales.crosscutting.exceptions.enums.Layer;

public class EntityCmdbException extends CmdbException {

	private static final long serialVersionUID = 1L;

	public EntityCmdbException(final String technicalMessage, final String userMessage, final Exception rootException) {
		super(technicalMessage, userMessage, Layer.ENTITY, rootException);
	}
	
	public static EntityCmdbException create(final String technicalMessage, final String userMessage, final Exception rootException) {
		
		return new EntityCmdbException(technicalMessage, userMessage, rootException);
		
	}
	
	public static EntityCmdbException create(final String userMessage, final Exception rootException) {
		
		return new EntityCmdbException(userMessage, userMessage, rootException);
		
	}
	
	public static EntityCmdbException create(final String technicalMessage, final String userMessage) {
		
		return new EntityCmdbException(technicalMessage, userMessage, new Exception());
		
	}
	
	public static EntityCmdbException create(final String userMessage) {
		
		return new EntityCmdbException(userMessage, userMessage, new Exception());
		
	}
	
	
	
	
	

}
