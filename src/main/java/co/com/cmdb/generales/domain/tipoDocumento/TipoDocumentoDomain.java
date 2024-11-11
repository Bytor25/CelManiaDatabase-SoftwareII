package co.com.cmdb.generales.domain.tipoDocumento;

public class TipoDocumentoDomain {
	
	private int id;
	private String nombre;
	
	public TipoDocumentoDomain(final int id, final String nombre) {
		
		setId(id);
		setNombre(nombre);

	}
	
	public static final TipoDocumentoDomain create(final int id, final String nombre) {
		
		return new TipoDocumentoDomain(id, nombre);
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
