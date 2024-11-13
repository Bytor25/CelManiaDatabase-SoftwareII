package co.com.cmdb.generales.domain.tipoDocumento;

public class TipoDocumentoDomain {
	
	private int identificador;
	private String nombre;
	
	public TipoDocumentoDomain(final int identificador, final String nombre) {
		
		setIdentificador(identificador);
		setNombre(nombre);

	}
	
	public static final TipoDocumentoDomain create(final int identificador, final String nombre) {
		
		return new TipoDocumentoDomain(identificador, nombre);
		
	}
	
	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
