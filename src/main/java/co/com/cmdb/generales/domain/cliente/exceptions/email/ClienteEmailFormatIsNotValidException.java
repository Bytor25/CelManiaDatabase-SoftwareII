package co.com.cmdb.generales.domain.cliente.exceptions.email;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;

public class ClienteEmailFormatIsNotValidException  extends RuleCmdbException{

	private static final long serialVersionUID = 1L;

	public ClienteEmailFormatIsNotValidException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);

	}
	
	public static final ClienteEmailFormatIsNotValidException create() {
		var userMessage = "El formato del correo electrónico ingresado no es válido. Por favor, verifica e intenta nuevamente.";
		return new ClienteEmailFormatIsNotValidException(userMessage, userMessage, new Exception());
	}

}
