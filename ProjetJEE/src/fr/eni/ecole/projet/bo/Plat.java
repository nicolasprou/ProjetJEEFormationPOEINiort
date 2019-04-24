package fr.eni.ecole.projet.bo;

public class Plat 
{
	private int id;
	private String nom;
	private String description_plat;
	private String image_plat;
	private int nbre_commande;
	private float prix;
	private String ingredients;
	
	public Plat() {
		super();
	}

	public Plat(String nom, String description_plat, String image_plat, int nbre_commande, float prix,
			String ingredients) {
		super();
		this.nom = nom;
		this.description_plat = description_plat;
		this.image_plat = image_plat;
		this.nbre_commande = nbre_commande;
		this.prix = prix;
		this.ingredients = ingredients;
	}

	public Plat(int id, String nom, String description_plat, String image_plat, int nbre_commande, float prix,
			String ingredients) {
		super();
		this.id = id;
		this.nom = nom;
		this.description_plat = description_plat;
		this.image_plat = image_plat;
		this.nbre_commande = nbre_commande;
		this.prix = prix;
		this.ingredients = ingredients;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription_plat() {
		return description_plat;
	}

	public void setDescription_plat(String description_plat) {
		this.description_plat = description_plat;
	}

	public String getImage_plat() {
		return image_plat;
	}

	public void setImage_plat(String image_plat) {
		this.image_plat = image_plat;
	}

	public int getNbre_commande() {
		return nbre_commande;
	}

	public void setNbre_commande(int nbre_commande) {
		this.nbre_commande = nbre_commande;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
}
