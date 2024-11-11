package co.com.cmdb.generales.application.primaryports.dto;

import co.com.cmdb.generales.crosscutting.helpers.NumericHelper;
import co.com.cmdb.generales.crosscutting.helpers.TextHelper;

public class TipoDocumentoDTO {
	
	private int id;
	private String nombre;
	
	public TipoDocumentoDTO() {
		
		setId(NumericHelper.DEFAULT_INT);
		setNombre(TextHelper.EMPTY);
		
	}
	
	public TipoDocumentoDTO(final int id, final String nombre) {
		
		setId(id);
		setNombre(nombre);
		
	}
	
	public static final TipoDocumentoDTO create(final int id, final String nombre) {
		
		return new TipoDocumentoDTO(id, nombre);
		
	}
	
	public static final TipoDocumentoDTO create() {
		
		return new TipoDocumentoDTO();
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = NumericHelper.getDefaultValue(id);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
	}
}
