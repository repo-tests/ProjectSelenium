package Model.entities;

public class Tache {
	private int id_tache;
	private String nom_tache;
	private String date_debut;
	private String date_fin;
	private String etat;
	private Personnel pr;
	

	public Tache() {
		super();
	}

	public Tache( String nom_tache, String date_debut,
			String date_fin, Personnel pr) {
		super();
	
		this.nom_tache = nom_tache;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.pr = pr;
		this.etat="affecte";
	}

	public int getId_tache() {
		return id_tache;
	}

	public void setId_tache(int id_tache) {
		this.id_tache = id_tache;
	}

	public String getNom_tache() {
		return nom_tache;
	}

	public void setNom_tache(String nom_tache) {
		this.nom_tache = nom_tache;
	}

	public String getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(String date_debut) {
		this.date_debut = date_debut;
	}

	public String getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(String date_fin) {
		this.date_fin = date_fin;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Personnel getPr() {
		return pr;
	}

	public void setPr(Personnel pr) {
		this.pr = pr;
	}
	

}
