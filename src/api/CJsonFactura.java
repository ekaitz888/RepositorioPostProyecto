package api;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import modelo.FacturaModel;

/**
 * Servlet implementation class CJsonFactura
 */
@WebServlet("/CJsonFactura")
public class CJsonFactura extends HttpServlet {
	private static final long serialVersionUID = 1L;
       //fdsfsfsf
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CJsonFactura() {
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
		
		
		// Json arraya sortu
				ArrayList<JSONObject> jsonArray = new ArrayList<JSONObject>();

				for (int i = 0; i < myFactura.getList().size(); i++) {
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("id_factura", myFactura.getList().get(i).getId_factura());
					jsonObject.put("id_linea", myFactura.getList().get(i).getId_linea());
					jsonObject.put("total", myFactura.getList().get(i).getTotal());
					jsonObject.put("Nombre", myFactura.getList().get(i).getNombre());
					jsonObject.put("Apellidos", myFactura.getList().get(i).getApellidos());
					jsonObject.put("Telefono", myFactura.getList().get(i).getTelefono());
					jsonObject.put("Direccion", myFactura.getList().get(i).getDireccion());
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
