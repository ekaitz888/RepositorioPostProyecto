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
import modelo.LineaModel;

/**
 * Servlet implementation class CDeleteFactura
 */
@WebServlet("/CDeleteFactura")
public class CDeleteFactura extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CDeleteFactura() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.setHeader("Access-Control-Allow-Origin", "*"); // json deia denean
////		// ez da behar
//		 response.setContentType("application/json"); // json bihurtzeko erabiltzen da
//		 response.setCharacterEncoding("UTF-8");
		String arrFactura = request.getParameter("arrFactura");

		JSONArray JSONArray = new JSONArray(arrFactura);

		FacturaModel myFactura = new FacturaModel();
		LineaModel myLinea = new LineaModel();
		try {
			myLinea.LoadData();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			myFactura.LoadData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < JSONArray.length(); i++) {
					myFactura.setId_factura(JSONArray.getJSONObject(i).getInt("id"));
					try {
						myFactura.deletetData();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			
		
	}

}
