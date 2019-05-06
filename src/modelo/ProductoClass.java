package modelo;

public class ProductoClass extends Connect{

	protected int id_producto;
	protected String nombre;
	protected double precio;
	protected int id_filtro;
	protected String imagen;
	
	public ProductoClass() {
		super();
	}

	public ProductoClass(int id_producto, String nombre, double precio, int id_filtro, String imagen) {
		super();
		this.id_producto = id_producto;
		this.nombre = nombre;
		this.precio = precio;
		this.id_filtro = id_filtro;
		this.imagen = imagen;
	}
	//edit
	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getId_filtro() {
		return id_filtro;
	}

	public void setId_filtro(int id_filtro) {
		this.id_filtro = id_filtro;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
}
