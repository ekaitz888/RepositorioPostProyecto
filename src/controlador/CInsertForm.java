package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import modelo.FacturaModel;
import modelo.LineaModel;
import modelo.ProductoModel;

/**
 * Servlet implementation class CInsertForm
 */
@WebServlet("/CInsertForm")
public class CInsertForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CInsertForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setHeader("Access-Control-Allow-Origin", "*"); // json deia denean ez da behar
		response.setContentType("application/json"); // json bihurtzeko erabiltzen da
		response.setCharacterEncoding("UTF-8");
		
		JSONObject JSONObject= new JSONObject();
		JSONObject.put("nombre", "hola");
		
		out.print(JSONObject.toString());
		out.flush();
		
	/*	try {
			myFactura.LoadData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String Nombre = request.getParameter("nombre");
		String Apellidos = request.getParameter("apellidos");
		int Telefono = Integer.parseInt(request.getParameter("telefono"));
		String Direccion = request.getParameter("direccion");
		String myCarrito = request.getParameter("myCarrito");
		
		JSONArray arrJson = new JSONArray(myCarrito);
		
		for (int i = 0; i < arrJson.length(); i++) {
			
			int id = Integer.parseInt(arrJson.getJSONObject(i).getString("id")) ;
			int cant = Integer.parseInt(arrJson.getJSONObject(i).getString("cant"));
			
			
			System.out.println("id:"+id+"cant"+cant);
		}*/
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String stMyCarrito = request.getParameter("myCarrito");
		LineaModel list = new LineaModel();
		ProductoModel myProduct = new ProductoModel();
		
		try {
			myProduct.LoadData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();
		response.setHeader("Access-Control-Allow-Origin", "*"); // json deia denean ez da behar
		response.setContentType("application/json"); // json bihurtzeko erabiltzen da
		response.setCharacterEncoding("UTF-8");
		
		System.out.println(stMyCarrito);
		JSONArray JSONArray = new JSONArray(stMyCarrito);
		
		
		for (int i=0; i<JSONArray.length();i++) {
			System.out.println(JSONArray.getJSONObject(i));
			JSONObject explrObject = JSONArray.getJSONObject(i);
			System.out.println(explrObject.getInt("id") +" "+ explrObject.get("cant"));
			
			
			
		}
		out.print(JSONArray);
		out.flush();
		for (int j=0; j<JSONArray.length();j++) {
			for (int i=0; i<myProduct.getList().size();i++) {				
				if(JSONArray.getJSONObject(j).getInt("id")==myProduct.getList().get(i).getId_producto()) {
					list.setId_producto(myProduct.getList().get(i).getId_producto());
					list.setCantidad(JSONArray.getJSONObject(j).getInt("cant"));
					list.setPrecio(myProduct.getList().get(i).getPrecio()*JSONArray.getJSONObject(j).getInt("cant"));
					System.out.println(list.getId_producto()+" "+ list.getCantidad()+" "+ list.getPrecio());
				}
			}
		}
		
		
	}

}
