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

import modelo.MarcaModel;

/**
 * Servlet implementation class CJsonMarca
 */
@WebServlet("/CJsonMarca")
public class CJsonMarca extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CJsonMarca() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
MarcaModel myMarca = new MarcaModel();
 		
 		try {
			myMarca.LoadData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
 		ArrayList<JSONObject> jsonArray=new ArrayList<JSONObject>();
 		
 		for (int i=0; i<myMarca.getList().size();i++) {
 			JSONObject jsonObject=new JSONObject();
 			jsonObject.put("nombre", myMarca.getList().get(i).getNombre());
 			jsonArray.add(jsonObject);
 		}
 		
 		response.getWriter().write(jsonArray.toString());	
 		System.out.print(jsonArray.toString());
				
 		response.setHeader("Access-Control-Allow-Origin","*"); //json deia denean ez da behar
 		response.setContentType("application/json"); // json bihurtzeko erabiltzen da
 		response.setCharacterEncoding("UTF-8");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
