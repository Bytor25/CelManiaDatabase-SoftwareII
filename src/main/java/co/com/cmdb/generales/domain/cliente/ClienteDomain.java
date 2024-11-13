package co.com.cmdb.generales.domain.cliente;

import java.util.UUID;

import co.com.cmdb.generales.domain.Domain;
import co.com.cmdb.generales.domain.tipoDocumento.TipoDocumentoDomain;

public class ClienteDomain extends Domain {
	
	private TipoDocumentoDomain tipoDocumento;
	private String numeroDocumento;
	private String nombre;
	private String apellidos;
	private String correo;
	private long telefono;


	public ClienteDomain (final UUID id, final TipoDocumentoDomain tipoDocumento, final String numeroDocumento, final String nombre, final String apellidos, final String correo,final long telefono) {
		
		super(id);
		setTipoDocumento(tipoDocumento);
		setNumeroDocumento(numeroDocumento);
		setNombre(nombre);
		setApellidos(apellidos);
		setCorreo(correo);
		setTelefono(telefono);
		
	}
	
	public static final ClienteDomain create(final UUID id, final TipoDocumentoDomain tipoDocumento, final String numeroDocumento, final String nombre, final String apellidos, final String correo, final Long telefono) {
		
		return new ClienteDomain(id, tipoDocumento, numeroDocumento, nombre, apellidos, correo, telefono);

	}
	
	// Tipo Documento

	public final TipoDocumentoDomain getTipoDocumento() {
		return tipoDocumento;
	}

	public final void setTipoDocumento(TipoDocumentoDomain tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	// Numero Documento
	
	public final String getNumeroDocumento() {
		return numeroDocumento;
	}

	public final void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	
	// Nombre

	public final String getNombre() {
		return nombre;
	}

	public final void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// Apellidos
	public final String getApellidos() {
		return apellidos;
	}

	public final void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	// Correo
	public final String getCorreo() {
		return correo;
	}

	public final void setCorreo(String correo) {
		this.correo = correo;
	}

	// Teléfono
	public final long getTelefono() {
		return telefono;
	}

	public final void setTelefono(long telefono) {
		this.telefono = telefono;
	}
	

	
}
