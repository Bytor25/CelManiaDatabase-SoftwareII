package co.com.cmdb.generales.application.primaryports.dto;

public final class ClienteDTO {
	
	private String numeroDocumento;
	private TipoDocumentoDTO tipoDocumento;
	private String nombre;
	private String apellidos;
	private String correo;
	private long telefono;
	
	public ClienteDTO(final String numeroDocumento, final TipoDocumentoDTO tipoDocumento, final String nombre, final String apellidos,
			final String correo, final long telefono) {
		setNumeroDocumento(numeroDocumento);
		setTipoDocumento(tipoDocumento);
		setNombre(nombre);
		setApellidos(apellidos);
		setCorreo(correo);
		setTelefono(telefono);
		
	}
	
	public static ClienteDTO create(final String numeroDocumento, final TipoDocumentoDTO tipoDocumento, final String nombre, final String apellidos,
			final String correo, final long telefono) {
		return new ClienteDTO( numeroDocumento,  tipoDocumento,  nombre,  apellidos,
				 correo,  telefono);
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

	public String getApellidos() {
		return apellidos;
	}

	private void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	private void setCorreo(String correo) {
		this.correo = correo;
	}

	public long getTelefono() {
		return telefono;
	}

	private void setTelefono(long telefono) {
		this.telefono = telefono;
	}
	
	
	
	
	
	

}
