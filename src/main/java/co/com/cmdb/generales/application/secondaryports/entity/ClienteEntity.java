package co.com.cmdb.generales.application.secondaryports.entity;

import java.util.UUID;

import co.com.cmdb.generales.crosscutting.helpers.BooleanHelper;
import co.com.cmdb.generales.crosscutting.helpers.LongHelper;
import co.com.cmdb.generales.crosscutting.helpers.ObjectHelper;
import co.com.cmdb.generales.crosscutting.helpers.TextHelper;
import co.com.cmdb.generales.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class ClienteEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "identificador")
	private UUID id;
	
	@ManyToOne
	@JoinColumn(name = "tipo_documento") 
	private TipoDocumentoEntity tipoDocumento;
	
	@Column(name = "numero_documento")
	private String numeroDocumento;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellidos")
	private String apellidos;
	
	@Column(name = "correo")
	private String correo;
	
	@Column(name = "telefono")
	private Long telefono;
	
	@Column(name = "estado")
	private boolean estado;
	
	ClienteEntity() {
		
		setId(UUIDHelper.getDefault());
		setTipoDocumento(TipoDocumentoEntity.create());
		setNumeroDocumento(TextHelper.EMPTY);
		setNombre(TextHelper.EMPTY);
		setApellidos(TextHelper.EMPTY);
		setCorreo(TextHelper.EMPTY);
		setTelefono(LongHelper.DEFAULT_LONG);
		setEstado(BooleanHelper.DEFAULT_BOOLEAN);
		
	}
	

	public ClienteEntity(final UUID id, final TipoDocumentoEntity tipoDocumento, final String numeroDocumento, final String nombre, final String apellidos, final String correo, final Long telefono, final boolean estado) {
		
		setId(id);
		setTipoDocumento(tipoDocumento);
		setNumeroDocumento(numeroDocumento);
		setNombre(nombre);
		setApellidos(apellidos);
		setCorreo(correo);
		setTelefono(telefono);
		setEstado(estado);
		
	}
	
	public static final ClienteEntity create() {
		
		return new ClienteEntity();
		
	}
	
	public static final ClienteEntity create(final UUID id) {
		
		return new ClienteEntity(id, TipoDocumentoEntity.create(), TextHelper.EMPTY, TextHelper.EMPTY, TextHelper.EMPTY, TextHelper.EMPTY, LongHelper.DEFAULT_LONG, BooleanHelper.DEFAULT_BOOLEAN);
		
	}
	
	public static final ClienteEntity create(final UUID id, final TipoDocumentoEntity tipoDocumento, final String numeroDocumento, final String nombre, final String apellidos, final String correo, final Long telefono, final boolean estado) {
		
		return new ClienteEntity(id, tipoDocumento, numeroDocumento, nombre, apellidos, correo, telefono, estado);
		
	}
	

	public UUID getId() {
		return id;
	}

	public ClienteEntity setId(UUID id) {
		this.id = UUIDHelper.getDefault();
		return this;
	}
	
	public TipoDocumentoEntity getTipoDocumento() {
		return tipoDocumento;
	}

	public ClienteEntity setTipoDocumento(TipoDocumentoEntity tipoDocumento) {
		this.tipoDocumento = ObjectHelper.getDefault(tipoDocumento, TipoDocumentoEntity.create());
		return this;
	
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public ClienteEntity setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = TextHelper.applyTrim(numeroDocumento);
		return this;
	}

	public String getNombre() {
		return nombre;
	}

	public ClienteEntity setNombre(String nombre) {
		this.nombre = TextHelper.getDefault(nombre, TextHelper.EMPTY);
		return this;
	}

	public String getApellidos() {
		return apellidos;
	}

	public ClienteEntity setApellidos(String apellidos) {
		this.apellidos = TextHelper.getDefault(apellidos, TextHelper.EMPTY);
		return this;
	}

	public String getCorreo() {
		return correo;
	}

	public ClienteEntity setCorreo(String correo) {
		this.correo = TextHelper.getDefault(correo, TextHelper.EMPTY);
		return this;
	}

	public Long getTelefono() {
		return telefono;
	}

	public ClienteEntity setTelefono(Long telefono) {
		this.telefono = LongHelper.getDefaultValue(telefono);
		return this;
	}
	
	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = BooleanHelper.DEFAULT_BOOLEAN;
	}

}
