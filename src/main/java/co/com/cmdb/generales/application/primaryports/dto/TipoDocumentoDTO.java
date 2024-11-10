package co.com.cmdb.generales.application.primaryports.dto;

import co.com.cmdb.generales.crosscutting.helpers.TextHelper;

public class TipoDocumentoDTO {
	private int identificador;
	private String nombre;
	
	public TipoDocumentoDTO(final int identificador, final String nombre) {
		setIdentificador(identificador);
		setNombre(nombre);
	}
	
	public static TipoDocumentoDTO create(final int identificador, final String nombre) {
		return new TipoDocumentoDTO(identificador, nombre);
	}
	
	public int getIdentificador() {
		return identificador;
	}
	private void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	public String getNombre() {
		return nombre;
	}
	private void setNombre(String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
	}
}
