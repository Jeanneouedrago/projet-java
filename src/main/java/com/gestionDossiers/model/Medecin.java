package com.gestionDossiers.model;

import java.util.List;

public class Medecin {
    private int id;
    private String nom;
    private String specialite;
    private List<Patient> patients;

    // Constructeurs
    public Medecin() {}

    public Medecin(int id, String nom, String specialite, List<Patient> patients) {
        this.id = id;
        this.nom = nom;
        this.specialite = specialite;
        this.patients = patients;
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

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
