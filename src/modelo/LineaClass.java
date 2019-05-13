package modelo;

public class LineaClass extends Connect {

	protected int id_linea;
	protected int id_producto;
	protected double precio;
	protected int cantidad;

	/**
	 * 
	 */
	public LineaClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id_linea
	 * @param id_producto
	 * @param precio
	 * @param cantidad
	 */
	public LineaClass(int id_linea, int id_producto, double precio, int cantidad) {
		super();
		this.id_linea = id_linea;
		this.id_producto = id_producto;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	/**
	 * @return the id_linea
	 */
	public int getId_linea() {
		return id_linea;
	}

	/**
	 * @param id_linea
	 *            the id_linea to set
	 */
	public void setId_linea(int id_linea) {
		this.id_linea = id_linea;
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
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad
	 *            the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	// prueba
}
