package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MarcaModel extends MarcaClass {

	ArrayList<MarcaModel> list = new ArrayList<MarcaModel>();

	/**
		 * 
		 */
	public MarcaModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id_marca
	 * @param nombre
	 */
	public MarcaModel(int id_marca, String nombre) {
		super(id_marca, nombre);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param list
	 */
	public MarcaModel(ArrayList<MarcaModel> list) {
		super();
		this.list = list;
	}

	/**
	 * @return the list
	 */
	public ArrayList<MarcaModel> getList() {
		return list;
	}

	/**
	 * @param list
	 *            the list to set
	 */
	public void setList(ArrayList<MarcaModel> list) {
		this.list = list;
	}

	public void LoadData() throws SQLException {

		this.CreateConection();

		Statement st = this.con.createStatement();
		ResultSet rs = st.executeQuery("CALL LoadData_Marcas");

		while (rs.next()) { // reads the table line by line

			MarcaModel myMarca = new MarcaModel();
			myMarca.setId_marca(Integer.parseInt(rs.getString(1)));
			myMarca.setNombre(rs.getString(2));
			this.list.add(myMarca);
		}
		this.disconnect();
	}
}
