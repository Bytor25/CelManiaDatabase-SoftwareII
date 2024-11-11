package co.com.cmdb.generales.infrastructure.primaryadapters.controller.response;

import java.util.ArrayList;

import co.com.cmdb.generales.application.primaryports.dto.TipoDocumentoDTO;

public class TipoDocumentoResponse extends Response<TipoDocumentoDTO> {
	
	public TipoDocumentoResponse() {
		
		setMensajes(new ArrayList<>());
		setDatos(new ArrayList<>());

	}

}
