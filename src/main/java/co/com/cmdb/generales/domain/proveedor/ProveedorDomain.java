package co.com.cmdb.generales.domain.proveedor;

import java.util.UUID;

import co.com.cmdb.generales.domain.Domain;
import co.com.cmdb.generales.domain.tipoDocumento.TipoDocumentoDomain;

public final class ProveedorDomain extends Domain{
	
	private String numeroDocumento;
	private TipoDocumentoDomain tipoDocumento;
	private String nombre;
	private long telefono;
	private boolean estado;

	private ProveedorDomain(final UUID identificador,final String numeroDocumento, final TipoDocumentoDomain tipoDocumento, 
			  final String nombre, final long telefono, final boolean estado) {
		super(identificador);
		setNumeroDocumento(numeroDocumento);
		setTipoDocumento(tipoDocumento);
		setNombre(nombre);
		setTelefono(telefono);
		setEstado(estado);
		
	}

	// Número Documento
	public final String getNumeroDocumento() {
		return numeroDocumento;
	}

	private final void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
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
