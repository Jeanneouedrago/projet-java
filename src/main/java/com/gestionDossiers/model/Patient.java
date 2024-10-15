package com.gestionDossiers.model;

public class Patient {
    private int id;
    private String nom;
    private String email;
    private String dateNaissance;
    private String antecedentsMedicaux;
    private Medecin medecinTraitant;

    // Constructeurs
    public Patient() {}

    public Patient(int id, String nom, String email, String dateNaissance, String antecedentsMedicaux, Medecin medecinTraitant) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.dateNaissance = dateNaissance;
        this.antecedentsMedicaux = antecedentsMedicaux;
        this.medecinTraitant = medecinTraitant;
    }

    // Getters et Setters
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getAntecedentsMedicaux() {
        return antecedentsMedicaux;
    }

    public void setAntecedentsMedicaux(String antecedentsMedicaux) {
        this.antecedentsMedicaux = antecedentsMedicaux;
    }

    public Medecin getMedecinTraitant() {
        return medecinTraitant;
    }

    public void setMedecinTraitant(Medecin medecinTraitant) {
        this.medecinTraitant = medecinTraitant;
    }
}
