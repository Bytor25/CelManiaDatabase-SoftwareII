package co.com.cmdb.generales.infrastructure.primaryadapters.controller.response;

import java.util.ArrayList;

import co.com.cmdb.generales.application.primaryports.dto.LoginDTO;

public class LoginResponse extends Response<LoginDTO>{
	public LoginResponse() {
		setMensajes( new ArrayList<String>());
		setDatos(new ArrayList<>());
	}
}
