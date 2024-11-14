package co.com.cmdb.generales.application.secondaryports.entity;

import co.com.cmdb.generales.crosscutting.helpers.NumericHelper;
import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipos_documentos")
public class TipoDocumentoEntity {
	
	@Id
	@Column(name = "identificador")
	private int identificador;
	
	@Column(name = "nombre")
	private String nombre;
	
	public TipoDocumentoEntity() {
		
		setIdentificador(NumericHelper.DEFAULT_INT);
		setNombre(TextHelper.EMPTY);
		
	}
	
	public TipoDocumentoEntity(final int identificador, final String nombre) {
		
		setIdentificador(identificador);
		setNombre(nombre);
		
	}
	
	public static final TipoDocumentoEntity create() {
		
		return new TipoDocumentoEntity();
		
	}
	
	public static final TipoDocumentoEntity create(final int identificador) {
		
		return new TipoDocumentoEntity(identificador, TextHelper.EMPTY);
		
	}
	
	public static final TipoDocumentoEntity create(final int identificador, final String name) {
		
		return new TipoDocumentoEntity(identificador, name);
				
	}

	public int getIdentificador() {
		return identificador;
	}

	public TipoDocumentoEntity setIdentificador(final int identificador) {
		this.identificador = NumericHelper.getDefaultValue(identificador);
		return this;
	}

	public String getNombre() {
		return nombre;
	}

	public TipoDocumentoEntity setNombre(String nombre) {
		this.nombre = TextHelper.getDefault(nombre, TextHelper.EMPTY);
		return this;
	}
	
	

}
