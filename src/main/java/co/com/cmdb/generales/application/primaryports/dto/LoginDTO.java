package co.com.cmdb.generales.application.primaryports.dto;

import co.com.cmdb.generales.crosscutting.helpers.BooleanHelper;
import co.com.cmdb.generales.crosscutting.helpers.NumericHelper;
import co.com.cmdb.generales.crosscutting.helpers.TextHelper;

public class LoginDTO {
	private String usuario;
	private int password;
	private boolean estado;
	
	public LoginDTO() {
		setUsuario(TextHelper.EMPTY);
		setPassword(NumericHelper.DEFAULT_INT);
		setEstado(BooleanHelper.DEFAULT_BOOLEAN);
	}
	
	public LoginDTO(final String usuario, final int password, final boolean estado) {
		setUsuario(usuario);
		setPassword(password);
		setEstado(estado);
	}
	
	public static final LoginDTO create() {
		return new LoginDTO();
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = TextHelper.applyTrim(usuario);
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = NumericHelper.getDefaultValue(password);
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = BooleanHelper.getDefaultValue(estado);
	}
	
	
}