package modelo;

public class ProductoClass extends Connect {

	protected int id_producto;
	protected String nombre;
	protected double precio;
	protected int id_marca;
	protected String imagen;

	/**
	 * 
	 */
	public ProductoClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id_producto
	 * @param nombre
	 * @param precio
	 * @param id_marca
	 * @param imagen
	 */
	public ProductoClass(int id_producto, String nombre, double precio, int id_marca, String imagen) {
		super();
		this.id_producto = id_producto;
		this.nombre = nombre;
		this.precio = precio;
		this.id_marca = id_marca;
		this.imagen = imagen;
	}

	/**
	 * @return the id_producto
	 */
	public int getId_producto() {
		return id_producto;
	}

	/**
	 * @param id_producto
	 *            the id_producto to set
	 */
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * @param precio
	 *            the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * @return the id_marca
	 */
	public int getId_marca() {
		return id_marca;
	}

	/**
	 * @param id_marca
	 *            the id_marca to set
	 */
	public void setId_marca(int id_marca) {
		this.id_marca = id_marca;
	}

	/**
	 * @return the imagen
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * @param imagen
	 *            the imagen to set
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

}
