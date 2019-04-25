package fr.eni.ecole.projet.bo;

public class Table 
{
	private int id, id_Etats_Tables, id_Restaurants;	
	
	public Table(int id, int id_Etats_Tables, int id_Restaurants) {
		super();
		this.id = id;
		this.id_Etats_Tables = id_Etats_Tables;
		this.id_Restaurants = id_Restaurants;
	}

	public Table() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getid_Etats_Tables() {
		return id_Etats_Tables;
	}

	public void setid_Etats_Tables(int id_Etats_Tables) {
		this.id_Etats_Tables = id_Etats_Tables;
	}

	public int getId_Restaurants() {
		return id_Restaurants;
	}

	public void setId_Restaurants(int id_Restaurants) {
		this.id_Restaurants = id_Restaurants;
	}	
}
