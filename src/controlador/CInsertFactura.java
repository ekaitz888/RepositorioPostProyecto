package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import modelo.FacturaModel;
import modelo.ProductoModel;

/**
 * Servlet implementation class CInsertFactura
 */
@WebServlet("/CInsertFactura")
public class CInsertFactura extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CInsertFactura() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Nombre = request.getParameter("nombre");
		String Apellidos = request.getParameter("apellidos");
		int Telefono = Integer.parseInt(request.getParameter("telefono"));
		String Direccion = request.getParameter("direccion");
		int TarjetaCredito= Integer.parseInt(request.getParameter("tarjetaCredito"));
		String myCarrito = request.getParameter("myCarrito");
		double total=0;
		FacturaModel myFactura = new FacturaModel();
		ProductoModel myProduct= new ProductoModel();
		
		try {
			myProduct.LoadData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Start JSON
		PrintWriter out = response.getWriter();
		response.setHeader("Access-Control-Allow-Origin", "*"); // json deia denean ez da behar
		response.setContentType("application/json"); // json bihurtzeko erabiltzen da
		response.setCharacterEncoding("UTF-8");
		
		System.out.println(myCarrito);
		JSONArray JSONArray = new JSONArray(myCarrito);
		
		for (int i=0; i<JSONArray.length();i++) {
			System.out.println(JSONArray.getJSONObject(i));
			JSONObject explrObject = JSONArray.getJSONObject(i);
			System.out.println(explrObject.getInt("id") +" "+ explrObject.get("cant"));
			
			
			
		}
		
		//START INSERT FACTURA
		for (int i=0; i<JSONArray.length();i++) {
			double totalProducto=0;
			for (int j=0; j<myProduct.getList().size();j++) {
				if (JSONArray.getJSONObject(i).getInt("id")==myProduct.getId_producto()) {
					totalProducto=JSONArray.getJSONObject(i).getInt("cant")*myProduct.getList().get(j).getPrecio();
					total=total+totalProducto;
				}
			}
		}
		myFactura.setApellidos(Apellidos);
		myFactura.setDireccion(Direccion);
		myFactura.setNombre(Nombre);
		myFactura.setTarjetaCredito(TarjetaCredito);
		myFactura.setTelefono(Telefono);
		myFactura.setTotal(total);
		try {
			myFactura.insertData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
