package fr.eni.ecole.projet.bo;

public class Reservation 
{
	int id, id_Table, nbPersonnes;
	String nom, telephone_reserv;
	
	public Reservation() {
		super();
	}
	
	public Reservation(int id_Table, int nbPersonnes, String nom, String telephone_reserv) {
		super();
		this.id_Table = id_Table;
		this.nbPersonnes = nbPersonnes;
		this.nom = nom;
		this.telephone_reserv = telephone_reserv;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_Table() {
		return id_Table;
	}
	public void setId_Table(int id_Table) {
		this.id_Table = id_Table;
	}
	public int getNbPersonnes() {
		return nbPersonnes;
	}
	public void setNbPersonnes(int nbPersonne) {
		this.nbPersonnes = nbPersonne;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getTelephone_reserv() {
		return telephone_reserv;
	}
	public void setTelephone_reserv(String telephone_reserv) {
		this.telephone_reserv = telephone_reserv;
	}
}