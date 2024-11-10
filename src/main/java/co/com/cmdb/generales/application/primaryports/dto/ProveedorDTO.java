package co.com.cmdb.generales.application.primaryports.dto;

public final class ProveedorDTO {
	
	private String numeroDocumento;
	private TipoDocumentoDTO tipoDocumento;
	private String nombre;
	private long telefono;
	
	public ProveedorDTO(final String numeroDocumento, final TipoDocumentoDTO tipoDocumento, final String nombre, final long telefono) {
		setNumeroDocumento(numeroDocumento);
		setTipoDocumento(tipoDocumento);
		setNombre(nombre);
		setTelefono(telefono);
		
	}
	
	public static ProveedorDTO create(final String numeroDocumento, final TipoDocumentoDTO tipoDocumento, final String nombre,  final long telefono) {
		return new ProveedorDTO( numeroDocumento,  tipoDocumento,  nombre,  telefono);
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	private void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public TipoDocumentoDTO getTipoDocumento() {
		return tipoDocumento;
	}

	private void setTipoDocumento(TipoDocumentoDTO tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public long getTelefono() {
		return telefono;
	}

	private void setTelefono(long telefono) {
		this.telefono = telefono;
	}

}
