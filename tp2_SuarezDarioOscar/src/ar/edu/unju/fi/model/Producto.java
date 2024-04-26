package ar.edu.unju.fi.model;
public class Producto {

	//ATRIBUTO
	private String codigo;
	private String descripcion;
	private double precioUnitario;
	private OrigenFabricacion origenFabricacion;
	private Categoria categoria;
	
	
	//ENUMERADOS
	public enum OrigenFabricacion {
		ARGENTINA, CHINA, BRASIL, URUGUAY;
	}
	
	public enum Categoria{
		TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS;
	}

	
	
	
	
	//METODOS
	
    
	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", descripcion=" + descripcion + ", precioUnitario=" + precioUnitario
				+ ", origenFabricacion=" + origenFabricacion + ", categoria=" + categoria + "]";
	}

	
	
	// CONSTRUCTORES
	
	/**
	 * Sin Parametro
	 */
	public Producto() {
		super();
	}


/**
 * Parametrizado
 * @param codigo
 * @param descripcion
 * @param precioUnitario
 * @param origenFabricacion
 * @param categoria
 */
	public Producto(String codigo, String descripcion, double precioUnitario, OrigenFabricacion origenFabricacion,
			Categoria categoria) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.origenFabricacion = origenFabricacion;
		this.categoria = categoria;
	}






	//GETTER Y SETTER 
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public OrigenFabricacion getOrigenFabricacion() {
		return origenFabricacion;
	}



	public void setOrigenFabricacion(OrigenFabricacion origenFabricacion) {
		this.origenFabricacion = origenFabricacion;
	}


	public Categoria getCategoria() {
		return categoria;
	}



	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}



	public String getCodigo() {
		return codigo;
	}



	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
	
	
	
	
	
	
	
	
}
