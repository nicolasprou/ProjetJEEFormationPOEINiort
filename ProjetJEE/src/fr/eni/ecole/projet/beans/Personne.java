package fr.eni.ecole.projet.beans;

public class Personne 
{
	private int id, id_statut;
	private String nom, prenom, mail, mdp, avatar_uri, com;
	
	public Personne() {
		super();
	}
	
	
	public Personne(int id, String nom, String prenom,  int id_statut, String mail, String mdp) {
		super();
		this.id = id ;
		this.nom = nom;
		this.prenom = prenom;
		this.id_statut = id_statut;
		this.mail = mail;
		this.mdp = mdp;
	}


	public Personne(String nom, String prenom,int id_statut, String mail, String mdp) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.id_statut = id_statut;
		this.mail = mail;
		this.mdp = mdp;
	}

	public Personne(int id, int id_statut, String nom, String prenom, String mail, String mdp, String avatar_uri,
			String com) {
		super();
		this.id = id;
		this.id_statut = id_statut;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.mdp = mdp;
		this.avatar_uri = avatar_uri;
		this.com = com;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_statut() {
		return id_statut;
	}

	public void setId_statut(int id_statut) {
		this.id_statut = id_statut;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getAvatar_uri() {
		return avatar_uri;
	}

	public void setAvatar_uri(String avatar_uri) {
		this.avatar_uri = avatar_uri;
	}

	public String getCom() {
		return com;
	}

	public void setCom(String com) {
		this.com = com;
	}

	@Override
	public String toString() {
		return "Personne [id=" + id + ", id_statut=" + id_statut + ", nom=" + nom + ", prenom=" + prenom + ", mail="
				+ mail + ", mdp=" + mdp + ", avatar_uri=" + avatar_uri + ", com=" + com + "]";
	}


	
	
	
}
