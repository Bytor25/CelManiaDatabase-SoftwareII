package co.com.cmdb.generales.infrastructure.primaryadapters.controller.cliente;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.cmdb.generales.application.primaryports.dto.ClienteDTO;
import co.com.cmdb.generales.application.primaryports.dto.TipoDocumentoDTO;
import co.com.cmdb.generales.application.primaryports.interactor.cliente.RegistrarClienteInteractor;
import co.com.cmdb.generales.crosscutting.exceptions.CmdbException;
import co.com.cmdb.generales.crosscutting.helpers.LongHelper;
import co.com.cmdb.generales.infrastructure.primaryadapters.controller.response.ClienteResponse;

@RestController
@RequestMapping("/clientes/api/v1/clientes")

public class ClienteController {
	
	private RegistrarClienteInteractor registrarClienteInteractor;
	
	public ClienteController(final RegistrarClienteInteractor registrarClienteInteractor) {
		
		this.registrarClienteInteractor = registrarClienteInteractor;
		
	}
	
	TipoDocumentoDTO tipoDocumento = TipoDocumentoDTO.create(1, "Cédula de Ciudadanía");
	
	@GetMapping
	public ClienteDTO getDummy() {
		
		return ClienteDTO.create(tipoDocumento, "101031", "juan", "gallego", "gaga@gmail.com", LongHelper.DEFAULT_LONG);
		
	}
	
	@PostMapping
	public ResponseEntity<ClienteResponse> create(@RequestBody ClienteDTO cliente) {
		
		var httpStatusCode = HttpStatus.ACCEPTED;
		var clienteResponse = new ClienteResponse();
		
		try {
			
			registrarClienteInteractor.execute(cliente); 
	        clienteResponse.getMensajes().add("Cliente creado de manera exitosa");
			
			
		} catch (final CmdbException exception) {
			
			httpStatusCode = HttpStatus.BAD_REQUEST;
			clienteResponse.getMensajes().add(exception.getUserMessage());
			exception.printStackTrace();
			
		} catch (final Exception exception) {
			
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			var userMessage = "No se pudo llevar a cabo el registro del cliente";
			clienteResponse.getMensajes().add(userMessage);
			exception.printStackTrace();
			
		}
		
		return new ResponseEntity<>(clienteResponse, httpStatusCode);
		
		
	}
	

}
