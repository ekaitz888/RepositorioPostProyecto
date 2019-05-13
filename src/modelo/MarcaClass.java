package modelo;

public class MarcaClass extends Connect {

	protected int id_marca;
	protected String Nombre;

	/**
	 * 
	 */
	public MarcaClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id_marca
	 * @param nombre
	 */
	public MarcaClass(int id_marca, String nombre) {
		super();
		this.id_marca = id_marca;
		Nombre = nombre;
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

}
