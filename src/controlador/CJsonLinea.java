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
import modelo.LineaModel;

/**
 * Servlet implementation class CJsonLinea
 */
@WebServlet("/CJsonLinea")
public class CJsonLinea extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CJsonLinea() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LineaModel myLinea = new LineaModel();
		try {
			myLinea.LoadData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// Json arraya sortu
				ArrayList<JSONObject> jsonArray = new ArrayList<JSONObject>();

				for (int i = 0; i < myLinea.getList().size(); i++) {
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("id_linea", myLinea.getList().get(i).getId_linea());
					jsonObject.put("id_factura", myLinea.getList().get(i).getId_producto());
					jsonObject.put("total", myLinea.getList().get(i).getPrecio());
					jsonArray.add(jsonObject);
				}

				response.getWriter().write(jsonArray.toString());
				System.out.print(jsonArray.toString());

				response.setHeader("Access-Control-Allow-Origin", "*"); // json deia denean ez da behar
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
