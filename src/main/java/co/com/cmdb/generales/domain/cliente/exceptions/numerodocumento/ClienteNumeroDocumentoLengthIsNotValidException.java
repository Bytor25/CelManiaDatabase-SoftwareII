package co.com.cmdb.generales.domain.cliente.exceptions.numerodocumento;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;

public class ClienteNumeroDocumentoLengthIsNotValidException extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public ClienteNumeroDocumentoLengthIsNotValidException(String technicalMessage, String userMessage,
			Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final ClienteNumeroDocumentoLengthIsNotValidException create(int typeUserMessage) {
		if(typeUserMessage == 1) {
			var userMessage1 = "El numero de documento ingresado es demasiado corto. Por favor, ingresa un numero de documento válido.";
			return new ClienteNumeroDocumentoLengthIsNotValidException(userMessage1, userMessage1, new Exception());
		}
		if(typeUserMessage == 2){
			var userMessage2 = "El numero de documento ingresado es demasiado largo. Por favor, verifica e ingresa un numero de documento con menos caracteres.";
			return new ClienteNumeroDocumentoLengthIsNotValidException(userMessage2, userMessage2, new Exception());
		}
		var userMessage="Se ha producido un error a la hora de validar la longitud del numero de  dodumento, si el problema persiste, contacte al administrador";
		return new ClienteNumeroDocumentoLengthIsNotValidException(userMessage, userMessage, new Exception());
	}

}
