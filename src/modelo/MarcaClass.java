package modelo;

public class MarcaClass extends Connect {

	protected int id_marca;
	protected String Nombre;

	public MarcaClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MarcaClass(int id_marca, String nombre) {
		super();
		this.id_marca = id_marca;
		Nombre = nombre;
	}

	public int getId_marca() {
		return id_marca;
	}

	public void setId_marca(int id_marca) {
		this.id_marca = id_marca;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

}
