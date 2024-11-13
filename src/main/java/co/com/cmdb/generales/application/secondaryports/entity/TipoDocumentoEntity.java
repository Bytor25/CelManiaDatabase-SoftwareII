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
	private int id;
	
	@Column(name = "nombre")
	private String nombre;
	
	public TipoDocumentoEntity() {
		
		setId(NumericHelper.DEFAULT_INT);
		setNombre(TextHelper.EMPTY);
		
	}
	
	public TipoDocumentoEntity(final int id, final String nombre) {
		
		setId(id);
		setNombre(nombre);
		
	}
	
	public static final TipoDocumentoEntity create() {
		
		return new TipoDocumentoEntity();
		
	}
	
	public static final TipoDocumentoEntity create(final int id) {
		
		return new TipoDocumentoEntity(id, TextHelper.EMPTY);
		
	}
	
	public static final TipoDocumentoEntity create(final int id, final String name) {
		
		return new TipoDocumentoEntity(id, name);
				
	}

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = NumericHelper.getDefaultValue(id);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = TextHelper.getDefault(nombre, TextHelper.EMPTY);
	}
	
	

}
