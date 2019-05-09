package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FacturaModel extends FacturaClass {

	ArrayList<FacturaModel> list = new ArrayList<FacturaModel>();

	
	
	public FacturaModel(ArrayList<FacturaModel> list) {
		super();
		this.list = list;
	}

	public FacturaModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FacturaModel(int id_factura, int id_linea, double total) {
		super(id_factura, id_linea, total);
		// TODO Auto-generated constructor stub
	}

	public ArrayList<FacturaModel> getList() {
		return list;
	}

	public void setList(ArrayList<FacturaModel> list) {
		this.list = list;
	}
	
	public void LoadData() throws SQLException {
		
		this.CreateConection();
		
		Statement st = this.con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM `factura`");

		while (rs.next()) { // reads the table line by line

			FacturaModel myFactura = new FacturaModel();
			myFactura.setId_factura(Integer.parseInt(rs.getString(1)));
			myFactura.setId_linea(Integer.parseInt(rs.getString(2)));
			myFactura.setTotal(Double.parseDouble(rs.getString(3)));
			
			this.list.add(myFactura);
		}
		this.disconnect();
	}
	
}
