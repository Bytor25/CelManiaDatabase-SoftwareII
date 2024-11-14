package co.com.cmdb.generales.infrastructure.primaryadapters.controller.login;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.cmdb.generales.application.primaryports.dto.LoginDTO;
import co.com.cmdb.generales.application.primaryports.interactor.login.ProcesarLoginInteractor;
import co.com.cmdb.generales.crosscutting.exceptions.CmdbException;
import co.com.cmdb.generales.infrastructure.primaryadapters.controller.response.LoginResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/generales/api/v1/login")
@RequiredArgsConstructor
public class LoginController {
	
	private ProcesarLoginInteractor procesarLoginInteractor;
	
	public LoginController(ProcesarLoginInteractor procesarLoginInteractor) {
		this.procesarLoginInteractor = procesarLoginInteractor;
	}
	
	
	@PostMapping
	public ResponseEntity<LoginResponse> validar(@RequestBody LoginDTO login){
		
		var httpStatusCode = HttpStatus.ACCEPTED;
		var loginResponse = new LoginResponse();
		
		try {
			
			procesarLoginInteractor.execute(login);
			
			var userMessage = "El usuario ha sido validado exitosamente.";
			loginResponse.getMensajes().add(userMessage);
			
		} catch (final CmdbException excepcion) {
			
			httpStatusCode = HttpStatus.BAD_REQUEST;
			loginResponse.getMensajes().add(excepcion.getUserMessage());
			excepcion.printStackTrace();
			
		} catch (final Exception excepcion) {
			
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			
			var mensajeUsuario = "Se presentó un problema validando el usuario";
			loginResponse.getMensajes().add(mensajeUsuario);
			
			excepcion.printStackTrace();
			
		}
		 
		return new ResponseEntity<>(loginResponse, httpStatusCode);
	}
	
}
