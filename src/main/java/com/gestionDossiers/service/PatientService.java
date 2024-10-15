package com.gestionDossiers.service;

import com.gestionDossiers.dao.PatientDAO;
import com.gestionDossiers.model.Patient;

import java.util.List;

public class PatientService {
    private PatientDAO patientDAO;

    public PatientService() {
        this.patientDAO = new PatientDAO();
    }

    public void ajouterPatient(Patient patient) {
        patientDAO.ajouterPatient(patient);
    }

    public void modifierPatient(Patient patient) {
        patientDAO.modifierPatient(patient);
    }

    public void supprimerPatient(int id) {
        patientDAO.supprimerPatient(id);
    }

    public List<Patient> rechercherPatientsParNom(String nom) {
        return patientDAO.rechercherPatientsParNom(nom);
    }

    public Patient getPatientById(int id) {
        return patientDAO.getPatientById(id);
    }

    public List<Patient> getAllPatients() {
        return patientDAO.getAllPatients();
    }
}
