package co.com.cmdb.generales.domain.cliente;

import java.util.UUID;

import co.com.cmdb.generales.domain.Domain;
import co.com.cmdb.generales.domain.tipoDocumento.TipoDocumentoDomain;

public final class ClienteDomain extends Domain {
	
	private String numeroDocumento;
	private TipoDocumentoDomain tipoDocumento;
	private String nombre;
	private String apellidos;
	private String correo;
	private long telefono;
	private boolean estado;

	private ClienteDomain(final UUID id, final String numeroDocumento, 
			final TipoDocumentoDomain tipoDocumento, final String nombre, final String apellidos, final String correo,
			  final long telefono, final boolean estado ) {
		super(id);
		setNumeroDocumento(numeroDocumento);
		setTipoDocumento(tipoDocumento);
		setNombre(nombre);
		setApellidos(apellidos);
		setCorreo(correo);
		setTelefono(telefono);
		setEstado(estado);
	}

	// Numero Documento
	public final String getNumeroDocumento() {
		return numeroDocumento;
	}

	private final void setNumeroDocumento(String numeroDocumento2) {
		this.numeroDocumento = numeroDocumento2;
	}
	
	// Tipo Documento

	public final TipoDocumentoDomain getTipoDocumento() {
		return tipoDocumento;
	}

	private final void setTipoDocumento(TipoDocumentoDomain tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
	// Nombre

	public final String getNombre() {
		return nombre;
	}

	private final void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// Apellidos
	public final String getApellidos() {
		return apellidos;
	}

	private final void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	// Correo
	public final String getCorreo() {
		return correo;
	}

	private final void setCorreo(String correo) {
		this.correo = correo;
	}

	// Teléfono
	public final long getTelefono() {
		return telefono;
	}

	private final void setTelefono(long telefono) {
		this.telefono = telefono;
	}
	
	// Estado

	public final boolean isEstado() {
		return estado;
	}

	private final void setEstado(boolean estado) {
		this.estado = estado;
	}
	
}
