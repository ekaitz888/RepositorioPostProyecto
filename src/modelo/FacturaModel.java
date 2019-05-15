package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FacturaModel extends FacturaClass {

	ArrayList<FacturaModel> list = new ArrayList<FacturaModel>();

	/**
	 * 
	 */
	public FacturaModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id_factura
	 * @param id_linea
	 * @param total
	 * @param nombre
	 * @param apellidos
	 * @param telefono
	 * @param direccion
	 * @param tarjetaCredito
	 */
	public FacturaModel(int id_factura, int id_linea, double total, String nombre, String apellidos, int telefono,
			String direccion, int tarjetaCredito) {
		super(id_factura, id_linea, total, nombre, apellidos, telefono, direccion, tarjetaCredito);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param list
	 */
	public FacturaModel(ArrayList<FacturaModel> list) {
		super();
		this.list = list;
	}

	/**
	 * @return the list
	 */
	public ArrayList<FacturaModel> getList() {
		return list;
	}

	/**
	 * @param list
	 *            the list to set
	 */
	public void setList(ArrayList<FacturaModel> list) {
		this.list = list;
	}

	/**
	 * @Description Hace un select data de la base de datos
	 * @throws SQLException
	 */
	public void LoadData() throws SQLException {

		this.CreateConection();

		Statement st = this.con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM `factura`");

		while (rs.next()) { // reads the table line by line

			FacturaModel myFactura = new FacturaModel();
			myFactura.setId_factura(Integer.parseInt(rs.getString(1)));
			myFactura.setId_linea(Integer.parseInt(rs.getString(2)));
			myFactura.setTotal(Double.parseDouble(rs.getString(3)));
			myFactura.setNombre(rs.getString(4));
			myFactura.setApellidos(rs.getString(5));
			myFactura.setTelefono(Integer.parseInt(rs.getString(6)));
			myFactura.setDireccion(rs.getString(7));
			myFactura.setTarjetaCredito(Integer.parseInt(rs.getString(8)));

			this.list.add(myFactura);
		}
		this.disconnect();
	}

	/**
	 * @Description Se usa para hacer un insert de datos en factura
	 * @throws SQLException
	 */
	public void insertData() throws SQLException {

		this.CreateConection();

		Statement st = this.con.createStatement();

		st.executeUpdate("INSERT INTO `factura`(`total`, `Nombre`, `Apellidos`, `Telefono`, `Direccion`,`tarjetaCredito`) VALUES ("+this.getTotal()+",'"+this.getNombre()+"','"+this.getApellidos()+"',"+this.getTelefono()+",'"+this.getDireccion()+"',"+this.getTarjetaCredito()+")");


		this.disconnect();
	}

}
