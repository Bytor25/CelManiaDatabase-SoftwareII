package co.com.cmdb.generales.domain.cliente.exceptions.email;

import co.com.cmdb.generales.crosscutting.exceptions.RuleCmdbException;

public class ClienteEmailLengthIsNotValidException extends RuleCmdbException{


	private static final long serialVersionUID = 1L;

	public ClienteEmailLengthIsNotValidException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
	}
	
	public static final ClienteEmailLengthIsNotValidException create() {
//		if() {
//			var userMessage = "El correo electrónico ingresado es demasiado corto. Por favor, ingresa una dirección de correo electrónico válida.";
//		}else {
//			var userMessage = "El correo electrónico ingresado es demasiado largo. Por favor, verifica e ingresa una dirección de correo electrónico válida con menos caracteres.";
//		}
		return null;
	}

}
