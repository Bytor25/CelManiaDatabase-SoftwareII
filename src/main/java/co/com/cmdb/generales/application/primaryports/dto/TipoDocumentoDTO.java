package co.com.cmdb.generales.application.primaryports.dto;

import co.com.cmdb.generales.crosscutting.helpers.NumericHelper;
import co.com.cmdb.generales.crosscutting.helpers.TextHelper;

public class TipoDocumentoDTO {
	
	private int identificador;
	private String nombre;
	
	public TipoDocumentoDTO() {
		
		setIdentificador(NumericHelper.DEFAULT_INT);
		setNombre(TextHelper.EMPTY);
		
	}
	
	public TipoDocumentoDTO(final int identificador, final String nombre) {
		
		setIdentificador(identificador);
		setNombre(nombre);
		
	}
	
	public static final TipoDocumentoDTO create(final int identificador, final String nombre) {
		
		return new TipoDocumentoDTO(identificador, nombre);
		
	}
	
	public static final TipoDocumentoDTO create() {
		
		return new TipoDocumentoDTO();
		
	}
	
	public int getIdentificador() {
		return identificador;
	}
	
	public void setIdentificador(int identificador) {
		this.identificador = NumericHelper.getDefaultValue(identificador);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
	}
}
