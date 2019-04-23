package fr.eni.ecole.projet.bo;

import java.util.Date;

public class Commentaire 
{	
	private int id;
	private String contenu;
	private Date dateCom;
	private float note;
	
	/****Pour stocker le nom du plat rattaché au commentaire***/
	private String nomPlat;
	
	public Commentaire() {
		super();
	}

	public Commentaire(String contenu, Date dateCom, float note) {
		super();
		this.contenu = contenu;
		this.dateCom = dateCom;
		this.note = note;
	}

	public Commentaire(int id, String contenu, Date dateCom, float note) {
		super();
		this.id = id;
		this.contenu = contenu;
		this.dateCom = dateCom;
		this.note = note;
	}

	/********Constructeur pour créer un commentaire avec le nom du plat commenté***********/
	public Commentaire(String contenu, Date dateCom, float note, String nomPlat) {
		super();
		this.contenu = contenu;
		this.dateCom = dateCom;
		this.note = note;
		this.nomPlat = nomPlat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Date getDateCom() {
		return dateCom;
	}

	public void setDateCom(Date dateCom) {
		this.dateCom = dateCom;
	}

	public float getNote() {
		return note;
	}

	public void setNote(float note) {
		this.note = note;
	}

	public String getNomPlat() {
		return nomPlat;
	}

	public void setNomPlat(String nomPlat) {
		this.nomPlat = nomPlat;
	}
}
