package modelo;

public class ProductoClass extends Connect{

	protected int id_producto;
	protected String nombre;
	protected double precio;
	protected int id_marca;
	protected String imagen;
	public ProductoClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductoClass(int id_producto, String nombre, double precio, int id_marca, String imagen) {
		super();
		this.id_producto = id_producto;
		this.nombre = nombre;
		this.precio = precio;
		this.id_marca = id_marca;
		this.imagen = imagen;
	}
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
	public int getId_marca() {
		return id_marca;
	}
	public void setId_marca(int id_marca) {
		this.id_marca = id_marca;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
	
	
}
