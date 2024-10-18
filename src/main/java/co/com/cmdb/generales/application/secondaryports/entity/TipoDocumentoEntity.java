package co.com.cmdb.generales.application.secondaryports.entity;

import java.util.UUID;

import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import co.com.cmdb.generales.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TipoDocumento")
public final class TipoDocumentoEntity {
	
	@Id
	@Column(name = "id")
	private UUID id;
	
	@Column(name = "nombre")
	private String name;
	
	public TipoDocumentoEntity() {
		
		setId(UUIDHelper.getDefault());
		setName(TextHelper.EMPTY);
		
	}
	
	public TipoDocumentoEntity(final UUID id, final String name) {
		
		setId(id);
		setName(name);
		
	}
	
	public static final TipoDocumentoEntity create() {
		
		return new TipoDocumentoEntity();
		
	}
	
	public static final TipoDocumentoEntity create(final UUID id) {
		
		return new TipoDocumentoEntity(id, TextHelper.EMPTY);
		
	}
	
	public static final TipoDocumentoEntity create(final UUID id, final String name) {
		
		return new TipoDocumentoEntity(id, name);
				
	}

	public final UUID getId() {
		return id;
	}

	public final void setId(final UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = TextHelper.getDefault(name, TextHelper.EMPTY);
	}
	
	

}
