package co.com.cmdb.generales.domain.login;

import java.util.UUID;

import co.com.cmdb.generales.crosscutting.helpers.BooleanHelper;
import co.com.cmdb.generales.crosscutting.helpers.NumericHelper;
import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import co.com.cmdb.generales.domain.Domain;

public class loginDomain extends Domain{
	
	private String usuario;
	private int password;
	private boolean estado;

	protected loginDomain(final UUID id) {
		super(id);
	}

	public final String getUsuario() {
		return usuario;
	}

	public final void setUsuario(String usuario) {
		this.usuario = TextHelper.applyTrim(usuario);
	}

	public final int getPassword() {
		return password;
	}

	public final void setPassword(int password) {
		this.password = NumericHelper.getDefaultValue(password);
	}

	public final boolean isEstado() {
		return estado;
	}

	public final void setEstado(boolean estado) {
		this.estado = BooleanHelper.getDefaultValue(estado);
	}
	
	

}
