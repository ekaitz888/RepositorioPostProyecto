package modelo;

public class FacturaClass extends Connect {
protected int id_factura;
protected int id_linea;
protected double total;

public FacturaClass() {
	super();
	// TODO Auto-generated constructor stub
}

public FacturaClass(int id_factura, int id_linea, double total) {
	super();
	this.id_factura = id_factura;
	this.id_linea = id_linea;
	this.total = total;
}

public int getId_factura() {
	return id_factura;
}

public void setId_factura(int id_factura) {
	this.id_factura = id_factura;
}

public int getId_linea() {
	return id_linea;
}

public void setId_linea(int id_linea) {
	this.id_linea = id_linea;
}

public double getTotal() {
	return total;
}

public void setTotal(double total) {
	this.total = total;
}





}
