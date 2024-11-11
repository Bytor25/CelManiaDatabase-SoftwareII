package co.com.cmdb.generales.infrastructure.primaryadapters.controller.response;

import java.util.ArrayList;

import co.com.cmdb.generales.application.primaryports.dto.ClienteDTO;

public class ClienteResponse extends Response<ClienteDTO> {
	
	public ClienteResponse() {
		
		setMensajes(new ArrayList<>());
		setDatos(new ArrayList<>());

	}

}
