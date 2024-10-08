package co.com.cmdb.generales.domain.tipoDocumento;

public final class TipoDocumentoDomain {
	
	private int identificador;
	private String nombre;
	
	private TipoDocumentoDomain() {
		super();
		
	}
	
	private TipoDocumentoDomain(final int identificador, final String nombre) {
	}
	
	public static TipoDocumentoDomain build(final int identificador, final String nombre) {
		
		return new TipoDocumentoDomain(identificador, nombre);
	}

	// Identificador
	
	public final int getIdentificador() {
		return identificador;
	}

	public final void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	
	// Nombre
	public final String getNombre() {
		return nombre;
	}

	public final void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
