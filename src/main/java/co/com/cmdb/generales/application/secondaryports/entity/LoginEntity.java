package co.com.cmdb.generales.application.secondaryports.entity;

import java.util.UUID;

import co.com.cmdb.generales.crosscutting.helpers.BooleanHelper;
import co.com.cmdb.generales.crosscutting.helpers.NumericHelper;
import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import co.com.cmdb.generales.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "logins")
public class LoginEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private UUID id;
	
	@Column(name ="usuario")
	private String usuario;
	
	@Column(name ="password")
	private int password;
	
	@Column(name ="estado")
	private boolean estado;
	
	public LoginEntity(){
		setId(UUIDHelper.getDefault());
		setUsuario(TextHelper.EMPTY);
		setPassword(NumericHelper.DEFAULT_INT);
		setEstado(BooleanHelper.DEFAULT_BOOLEAN);
		
	}

	public LoginEntity(final UUID id, final String usuario, final int password, final boolean estado) {
		
		setId(id);
		setUsuario(usuario);
		setPassword(password);
		setEstado(estado);
	}
	
	public static final LoginEntity create() {
		
		return new LoginEntity();
	}
	
	public static final LoginEntity create(final UUID id, final String usuario, final int password, final boolean estado) {
		
		return new LoginEntity(id, usuario, password, estado);
	}
	
	public static final LoginEntity create(final String usuario, final int password) {
		
		return new LoginEntity(UUIDHelper.getDefault(), usuario, password, BooleanHelper.DEFAULT_BOOLEAN);
	}
	
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UUIDHelper.getDefault();
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
