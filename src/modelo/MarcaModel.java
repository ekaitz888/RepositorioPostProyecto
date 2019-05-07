package modelo;

import java.util.ArrayList;

public class MarcaModel extends MarcaClass {

	ArrayList<MarcaModel> list = new ArrayList<MarcaModel>();

	public MarcaModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MarcaModel(int id_marca, String nombre) {
		super(id_marca, nombre);
		// TODO Auto-generated constructor stub
	}

	public MarcaModel(ArrayList<MarcaModel> list) {
		super();
		this.list = list;
	}

	public ArrayList<MarcaModel> getList() {
		return list;
	}

	public void setList(ArrayList<MarcaModel> list) {
		this.list = list;
	}

}
