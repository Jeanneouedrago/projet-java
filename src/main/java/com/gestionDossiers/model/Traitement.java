package com.gestionDossiers.model;

public class Traitement {
    private int id;
    private Patient patient;
    private String typeTraitement;
    private String posologie;
    private String duree;

    // Constructeurs
    public Traitement() {}

    public Traitement(int id, Patient patient, String typeTraitement, String posologie, String duree) {
        this.id = id;
        this.patient = patient;
        this.typeTraitement = typeTraitement;
        this.posologie = posologie;
        this.duree = duree;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getTypeTraitement() {
        return typeTraitement;
    }

    public void setTypeTraitement(String typeTraitement) {
        this.typeTraitement = typeTraitement;
    }

    public String getPosologie() {
        return posologie;
    }

    public void setPosologie(String posologie) {
        this.posologie = posologie;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }
}
