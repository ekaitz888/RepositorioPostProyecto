package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import modelo.ProductoModel;

/**
 * Servlet implementation class CJson
 */
@WebServlet("/CJson")
public class CJson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CJson() {
        super();
        // TODO Auto-generated constructor stub
    }
 //edit
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductoModel myProduct = new ProductoModel();
		 
		
		try {
			myProduct.LoadData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//START JSON
 		ArrayList<JSONObject> jsonArrayProducto=new ArrayList<JSONObject>();
 	 	
 		for (int i=0;i<myProduct.getList().size();i++){
 			
 			JSONObject jsonObjectProducto=new JSONObject();
 			jsonObjectProducto.put("nombre", myProduct.getList().get(i).getNombre());
 			jsonObjectProducto.put("precio", myProduct.getList().get(i).getPrecio());
 			jsonObjectProducto.put("id_filtro", myProduct.getList().get(i).getId_filtro());
 			jsonObjectProducto.put("imagen", myProduct.getList().get(i).getImagen());
 			
 			jsonArrayProducto.add(jsonObjectProducto);	
 		}
 		
 		MarcaModel myMarca = new MarcaModel();
 		
 		try {
			myMarca.LoadData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
 		ArrayList<JSONObject> jsonArrayMarca=new ArrayList<JSONObject>();
 		
 		for (int i=0; i<myMarca.getList().size();i++) {
 			JSONObject jsonObjectMarca=new JSONObject();
 			jsonObjectMarca.put("nombre", myMarca.getList().get(i).getNombre());
 			jsonArrayMarca.add(jsonObjectMarca);
 		}
 		
 		ArrayList<JSONObject> jsonArray=new ArrayList<JSONObject>();
 		jsonArray.addAll(jsonArrayProducto);
 		jsonArray.addAll(jsonArrayMarca);

 		response.getWriter().write(jsonArray.toString());	
 		System.out.print(jsonArray.toString());
				
 		response.setHeader("Access-Control-Allow-Origin","*"); //json deia denean ez da behar
 		response.setContentType("application/json");
 		response.setCharacterEncoding("UTF-8");
 	
 		//END JSON
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
