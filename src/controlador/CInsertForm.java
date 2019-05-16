package controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import modelo.FacturaModel;

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
		FacturaModel myFactura = new FacturaModel();
		
		try {
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
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
