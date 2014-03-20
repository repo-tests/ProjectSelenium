package Model.entities;

import java.util.HashSet;
import java.util.Set;

public class Personnel {
	private int id_pers;
	private String nom_pers;
	private String prenom_pers;
	private String date_emb;
	private String role;
	private Set<Tache> taches = new HashSet();

	public Personnel() {
		super();
	}

	public Personnel( String nom_pers, String prenom_pers,
			String date_emb,String role) {
		super();
		
		this.nom_pers = nom_pers;
		this.prenom_pers = prenom_pers;
		this.date_emb = date_emb;
		this.role=role;
	}

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getId_pers() {
		return id_pers;
	}

	public void setId_pers(int id_pers) {
		this.id_pers = id_pers;
	}

	public String getNom_pers() {
		return nom_pers;
	}

	public void setNom_pers(String nom_pers) {
		this.nom_pers = nom_pers;
	}

	public String getPrenom_pers() {
		return prenom_pers;
	}

	public void setPrenom_pers(String prenom_pers) {
		this.prenom_pers = prenom_pers;
	}

	public String getDate_emb() {
		return date_emb;
	}

	public void setDate_emb(String date_emb) {
		this.date_emb = date_emb;
	}

	public Set<Tache> getTaches() {
		return taches;
	}

	public void setTaches(Set<Tache> taches) {
		this.taches = taches;
	}

	public void addTache(Tache t) {
		this.getTaches().add(t);
		t.setPr(this);
	}
	

}
