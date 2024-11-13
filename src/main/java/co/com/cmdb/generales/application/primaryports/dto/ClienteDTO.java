package co.com.cmdb.generales.application.primaryports.dto;

import co.com.cmdb.generales.crosscutting.helpers.LongHelper;
import co.com.cmdb.generales.crosscutting.helpers.ObjectHelper;
import co.com.cmdb.generales.crosscutting.helpers.TextHelper;

public class ClienteDTO {
	
	private TipoDocumentoDTO tipoDocumento;
	private String numeroDocumento;
	private String nombre;
	private String apellidos;
	private String correo;
	private long telefono;
	
	public ClienteDTO() {
		
		setNumeroDocumento(TextHelper.EMPTY);
		setTipoDocumento(TipoDocumentoDTO.create());
		setNombre(TextHelper.EMPTY);
		setApellidos(TextHelper.EMPTY);
		setCorreo(TextHelper.EMPTY);
		setTelefono(LongHelper.DEFAULT_LONG);
		
	}
	
	public ClienteDTO(final TipoDocumentoDTO tipoDocumento, final String numeroDocumento , final String nombre, final String apellidos,
			final String correo, final long telefono) {
		
		setTipoDocumento(tipoDocumento);
		setNumeroDocumento(numeroDocumento);
		setNombre(nombre);
		setApellidos(apellidos);
		setCorreo(correo);
		setTelefono(telefono);
		
	}
	
	public static final ClienteDTO create(final TipoDocumentoDTO tipoDocumento, final String numeroDocumento, final String nombre, final String apellidos,
			final String correo, final long telefono) {
		
		return new ClienteDTO(tipoDocumento, numeroDocumento, nombre, apellidos, correo, telefono);
		
	}
	
	public static final ClienteDTO create() {
		
		return new ClienteDTO();
		
	}

	public TipoDocumentoDTO getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumentoDTO tipoDocumento) {
		this.tipoDocumento = ObjectHelper.getDefault(tipoDocumento, TipoDocumentoDTO.create());
	}
	
	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = TextHelper.applyTrim(numeroDocumento);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = TextHelper.applyTrim(apellidos);
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = TextHelper.applyTrim(correo);
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = LongHelper.getDefaultValue(telefono);
	}
	
}
