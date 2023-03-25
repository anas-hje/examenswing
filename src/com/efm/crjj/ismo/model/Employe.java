package com.efm.crjj.ismo.model;

public class Employe {

	private int id;
	private String nom;
	private String departement;
	private double salaire;

	public Employe() {

	}

	public Employe(String nom, String departement, double salaire) {
		super();
		this.nom = nom;
		this.departement = departement;
		this.salaire = salaire;
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

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

}
