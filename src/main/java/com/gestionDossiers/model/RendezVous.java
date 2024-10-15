package com.gestionDossiers.model;

public class RendezVous {
    private int id;
    private Patient patient;
    private Medecin medecin;
    private String date;
    private String heure;
    private String statut;

    // Constructeurs
    public RendezVous() {}

    public RendezVous(int id, Patient patient, Medecin medecin, String date, String heure, String statut) {
        this.id = id;
        this.patient = patient;
        this.medecin = medecin;
        this.date = date;
        this.heure = heure;
        this.statut = statut;
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

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
}
