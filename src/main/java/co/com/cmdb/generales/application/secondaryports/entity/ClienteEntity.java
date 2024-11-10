package co.com.cmdb.generales.application.secondaryports.entity;

import java.util.UUID;

import co.com.cmdb.generales.crosscutting.helpers.BooleanHelper;
import co.com.cmdb.generales.crosscutting.helpers.LongHelper;
import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import co.com.cmdb.generales.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cliente")
public class ClienteEntity {
	
	@Id
	@Column(name = "id")
	private UUID id;
	
	@Column(name = "numeroDocumento")
	private String numeroDocumento;

	@ManyToOne
	@JoinColumn(name = "TipoDocumento") 
	private TipoDocumentoEntity tipoDocumento;
	
	@Column(name = "nombre")
	private String name;
	
	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "correo")
	private String correo;
	
	@Column(name = "teléfono")
	private Long telefono;
	
	@Column(name = "estado")
	private boolean estado;
	
	ClienteEntity() {
		
		setId(UUIDHelper.getDefault());
		setNumeroDocumento(TextHelper.EMPTY);
		setTipoDocumento(TipoDocumentoEntity.create());
		setName(TextHelper.EMPTY);
		setApellido(TextHelper.EMPTY);
		setCorreo(TextHelper.EMPTY);
		setTelefono(LongHelper.getDefaultValue(telefono));
		setEstado(BooleanHelper.getDefaultValue(estado));
		
	}
	
	public ClienteEntity(final UUID id, final String numeroDocumento, final TipoDocumentoEntity tipoDocumento, final String name, final String apellido, final String correo, final Long telefono, final boolean estado) {
		
		setId(id);
		setNumeroDocumento(numeroDocumento);
		setTipoDocumento(tipoDocumento);
		setName(name);
		setApellido(apellido);
		setCorreo(correo);
		setTelefono(telefono);
		setEstado(estado);
		
	}
	
	public static final ClienteEntity create() {
		
		return new ClienteEntity();
		
	}
	
	public static final ClienteEntity create(final UUID id) {
		
		return new ClienteEntity(id, TextHelper.EMPTY, TipoDocumentoEntity.create(), TextHelper.EMPTY, TextHelper.EMPTY, TextHelper.EMPTY, LongHelper.DEFAULT_LONG, BooleanHelper.DEFAULT_BOOLEAN);
		
	}
	
	public static final ClienteEntity create(final UUID id, final String numeroDocumento, final TipoDocumentoEntity tipoDocumento, final String name, final String apellido, final String correo, final Long telefono, final Boolean estado) {
		
		return new ClienteEntity(id,numeroDocumento, tipoDocumento, name, apellido, correo, telefono, estado);
		
		
	}
	
	

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UUIDHelper.getDefault();
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = TextHelper.applyTrim(numeroDocumento);
	}
	
	public TipoDocumentoEntity getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumentoEntity tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = TextHelper.getDefault(name, TextHelper.EMPTY);
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = TextHelper.getDefault(apellido, TextHelper.EMPTY);
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = TextHelper.getDefault(correo, TextHelper.EMPTY);
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = LongHelper.getDefaultValue(telefono);
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = BooleanHelper.getDefaultValue(estado);
	}
	
	
	
	

}
