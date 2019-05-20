package modelo;

public class FacturaClass extends Connect {
	protected int id_factura;
	protected double total;
	protected String Nombre;
	protected String Apellidos;
	protected int Telefono;
	protected String Direccion;
	protected int tarjetaCredito;

	/**
	 * @Description Es el constructor de la clase superior
	 */
	public FacturaClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id_factura
	 * @param total
	 * @param nombre
	 * @param apellidos
	 * @param telefono
	 * @param direccion
	 * @param tarjetaCredito
	 */
	public FacturaClass(int id_factura, double total, String nombre, String apellidos, int telefono, String direccion,
			int tarjetaCredito) {
		super();
		this.id_factura = id_factura;
		this.total = total;
		Nombre = nombre;
		Apellidos = apellidos;
		Telefono = telefono;
		Direccion = direccion;
		this.tarjetaCredito = tarjetaCredito;
	}

	/**
	 * @return the tarjetaCredito
	 */
	public int getTarjetaCredito() {
		return tarjetaCredito;
	}

	/**
	 * @param tarjetaCredito
	 *            the tarjetaCredito to set
	 */
	public void setTarjetaCredito(int tarjetaCredito) {
		this.tarjetaCredito = tarjetaCredito;
	}

	/**
	 * @return the id_factura
	 */
	public int getId_factura() {
		return id_factura;
	}

	/**
	 * @param id_factura
	 *            the id_factura to set
	 */
	public void setId_factura(int id_factura) {
		this.id_factura = id_factura;
	}

	/**
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(double total) {
		this.total = total;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return Nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return Apellidos;
	}

	/**
	 * @param apellidos
	 *            the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	/**
	 * @return the telefono
	 */
	public int getTelefono() {
		return Telefono;
	}

	/**
	 * @param telefono
	 *            the telefono to set
	 */
	public void setTelefono(int telefono) {
		Telefono = telefono;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return Direccion;
	}

	/**
	 * @param direccion
	 *            the direccion to set
	 */
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

}