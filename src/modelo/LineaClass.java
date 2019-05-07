package modelo;

public class LineaClass extends Connect{

	protected int id_linea;
	protected int id_producto;
	protected double precio;
	public LineaClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LineaClass(int id_linea, int id_producto, double precio) {
		super();
		this.id_linea = id_linea;
		this.id_producto = id_producto;
		this.precio = precio;
	}
	public int getId_linea() {
		return id_linea;
	}
	public void setId_linea(int id_linea) {
		this.id_linea = id_linea;
	}
	public int getId_producto() {
		return id_producto;
	}
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	//prueba
}
