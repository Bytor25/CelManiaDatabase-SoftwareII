package co.com.cmdb.generales.crosscutting.exceptions;

import co.com.cmdb.generales.crosscutting.exceptions.enums.Layer;
import co.com.cmdb.generales.crosscutting.helpers.ObjectHelper;
import co.com.cmdb.generales.crosscutting.helpers.TextHelper;

public class CmdbException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String userMessage;
	private Layer layer;
	
	public CmdbException(final String userMessage, final String technicalMessage,  final Layer layer, final  Exception rootException) {
		
		super(ObjectHelper.getDefault(technicalMessage, TextHelper.applyTrim(userMessage)), ObjectHelper.getDefault(rootException, new Exception()));
		
		setUserMessage(userMessage);
		setLayer(layer);
		
	}

	public String getUserMessage() {
		return userMessage;
	}

	private void setUserMessage(String userMessage) {
		this.userMessage = TextHelper.applyTrim(userMessage);
	}

	public Layer getLayer() {
		return layer;
	}

	private final void setLayer(Layer layer) {
		this.layer = ObjectHelper.getDefault(layer, Layer.GENERAL);
	}
	
	public static CmdbException create( final String userMessage,final String technicalMessage, final Exception rootException) {
		
		return new CmdbException(userMessage, technicalMessage, Layer.GENERAL, rootException);
		
	}

	
	public static CmdbException create(final String userMessage, final Exception rootException) {
		
		return new CmdbException(userMessage, userMessage, Layer.GENERAL, rootException);
		
	}
	
	public static CmdbException create(final String techicalMessage, final String userMessage) {
		
		return new CmdbException( userMessage,techicalMessage, Layer.GENERAL, new Exception());
		
	}
	
	public static CmdbException create(final String userMessage) {
		
		return new CmdbException(userMessage, userMessage, Layer.GENERAL, new Exception());
		
	}
	
	
	
	
	

}
