package modelo;

public class FacturaClass extends Connect {
	protected int id_factura;
	protected double total;
	protected String Nombre;
	protected String Apellidos;
	protected String Telefono;
	protected String Direccion;
	protected String tarjetaCredito;

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
	public FacturaClass(int id_factura, double total, String nombre, String apellidos, String telefono, String direccion,
			String tarjetaCredito) {
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
	public String getTarjetaCredito() {
		return tarjetaCredito;
	}

	/**
	 * @param tarjetaCredito
	 *            the tarjetaCredito to set
	 */
	public void setTarjetaCredito(String tarjetaCredito) {
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
	

	

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return Direccion;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	/**
	 * @param direccion
	 *            the direccion to set
	 */
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

}