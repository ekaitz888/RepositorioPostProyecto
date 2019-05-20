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
	 * @param total
	 * @param nombre
	 * @param apellidos
	 * @param telefono
	 * @param direccion
	 * @param tarjetaCredito
	 */
	public FacturaModel(int id_factura, double total, String nombre, String apellidos, String telefono, String direccion,
			String tarjetaCredito) {
		super(id_factura, total, nombre, apellidos, telefono, direccion, tarjetaCredito);
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
		ResultSet rs = st.executeQuery("CALL LoadData_Facturas");

		while (rs.next()) { // reads the table line by line

			FacturaModel myFactura = new FacturaModel();
			myFactura.setId_factura(Integer.parseInt(rs.getString(1)));
			myFactura.setTotal(Double.parseDouble(rs.getString(2)));
			myFactura.setNombre(rs.getString(3));
			myFactura.setApellidos(rs.getString(4));
			myFactura.setTelefono(rs.getString(5));
			myFactura.setDireccion(rs.getString(6));
			myFactura.setTarjetaCredito((rs.getString(7)));

			this.list.add(myFactura);
		}
		this.disconnect();
	}

	/**
	 * @Description Se usa para hacer un insert de datos en factura
	 * @throws SQLException
	 */
	public int insertData() throws SQLException {

		this.CreateConection();

		Statement st = this.con.createStatement();
		String sql="CALL InsertDatos_Factura("+this.getTotal()+",'"+this.getNombre()+"','"+this.getApellidos()+"','"+this.getTelefono()+"','"+this.getDireccion()+"','"+this.getTarjetaCredito()+"')";
		System.out.println(sql);
		ResultSet rs = st.executeQuery(sql);
		this.disconnect();
		rs.next();
		return rs.getInt("id");
	}

}
