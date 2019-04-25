package fr.eni.ecole.projet.bo;

public class Table 
{
	int id, id_Etats_Tables;

	
	
	public Table(int id, int id_Etats_Tables) {
		super();
		this.id = id;
		this.id_Etats_Tables = id_Etats_Tables;
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
	
	
	
	
}
