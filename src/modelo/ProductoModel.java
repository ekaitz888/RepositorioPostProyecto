package modelo;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductoModel extends ProductoClass{
	ArrayList<ProductoModel> list = new ArrayList<ProductoModel>();
	
	public ProductoModel() {
		super();
	}


	

	public ProductoModel(ArrayList<ProductoModel> list) {
		super();
		this.list = list;
	}




	public ProductoModel(int id_producto, String nombre, double precio, int id_marca, String imagen) {
		super(id_producto, nombre, precio, id_marca, imagen);
		// TODO Auto-generated constructor stub
	}




	public void LoadData() throws SQLException {
		
		this.CreateConection();
		
		Statement st = this.con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM `producto`");

		while (rs.next()) { // reads the table line by line

			ProductoModel myProducto = new ProductoModel();
			myProducto.setId_producto(Integer.parseInt(rs.getString(1)));
			myProducto.setNombre(rs.getString(2));
			myProducto.setPrecio(Double.parseDouble(rs.getString(3)));
			myProducto.setId_marca(Integer.parseInt(rs.getString(4)));
			myProducto.setImagen(rs.getString(5));
			this.list.add(myProducto);
		}
		this.disconnect();
	}
	//edit
	public ArrayList<ProductoModel> getList() {
		return list;
	}

	public void setList(ArrayList<ProductoModel> list) {
		this.list = list;
	}
	
}
