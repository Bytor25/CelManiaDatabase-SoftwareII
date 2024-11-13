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
import co.com.cmdb.generales.application.primaryports.interactor.cliente.ConsultarClienteInteractor;
import co.com.cmdb.generales.application.primaryports.interactor.cliente.RegistrarClienteInteractor;
import co.com.cmdb.generales.crosscutting.exceptions.CmdbException;
import co.com.cmdb.generales.infrastructure.primaryadapters.controller.response.ClienteResponse;
import co.com.cmdb.generales.infrastructure.secondaryadapters.service.redis.MessageCatalogService;

@RestController
@RequestMapping("/generales/api/v1/clientes")

public class ClienteController {
	
	private RegistrarClienteInteractor registrarClienteInteractor;
	private MessageCatalogService messageCatalogService;
	private ConsultarClienteInteractor consultarClienteInteractor;
	
	public ClienteController(final RegistrarClienteInteractor registrarClienteInteractor, final MessageCatalogService messageCatalogService, final ConsultarClienteInteractor consultarClienteInteractor) {
		
		this.registrarClienteInteractor = registrarClienteInteractor;
		this.messageCatalogService = messageCatalogService;
		this.consultarClienteInteractor = consultarClienteInteractor;
		
	}
	
	TipoDocumentoDTO tipoDocumento = TipoDocumentoDTO.create(1, "Cédula de Ciudadanía");
	
	@GetMapping
	public ResponseEntity<ClienteResponse> consultarCliente() {
		
		var httpStatusCode = HttpStatus.ACCEPTED;
		var clienteResponse = new ClienteResponse();
		
		try {
			var consultarClienteDto = ClienteDTO.create();
			
			clienteResponse.setDatos(consultarClienteInteractor.execute(consultarClienteDto));
			var userMessage = "Usuarios consultados exitosamente";
			clienteResponse.getMensajes().add(userMessage);
			
			
		}catch(CmdbException exception){
			httpStatusCode = HttpStatus.BAD_REQUEST;
			var userMessage = "Se ha presentado un error a la hora de consultar un cliente";
			
			clienteResponse.getMensajes().add(userMessage);
			
			exception.printStackTrace();
		}
		
		return new ResponseEntity<>(clienteResponse , httpStatusCode);
	}
	
	@PostMapping
	public ResponseEntity<ClienteResponse> create(@RequestBody ClienteDTO cliente) {
		
		var httpStatusCode = HttpStatus.ACCEPTED;
		var clienteResponse = new ClienteResponse();
		
		try {
			
			registrarClienteInteractor.execute(cliente); 
	        clienteResponse.getMensajes().add(messageCatalogService.getMessage("clienteRegister"));
			
			
		} catch (final CmdbException exception) {
			
			httpStatusCode = HttpStatus.BAD_REQUEST;
			clienteResponse.getMensajes().add(exception.getUserMessage());
			exception.printStackTrace();
			
		} catch (final Exception exception) {
			
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			var userMessage = messageCatalogService.getMessage("errorClientRegister");
			clienteResponse.getMensajes().add(userMessage);
			exception.printStackTrace();
			
		}
		
		return new ResponseEntity<>(clienteResponse, httpStatusCode);
		
		
	}
	

}
