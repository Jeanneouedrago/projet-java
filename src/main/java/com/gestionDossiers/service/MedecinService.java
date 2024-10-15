package com.gestionDossiers.service;

import com.gestionDossiers.dao.MedecinDAO;
import com.gestionDossiers.model.Medecin;

import java.util.List;

public class MedecinService {
    private MedecinDAO medecinDAO;

    public MedecinService() {
        this.medecinDAO = new MedecinDAO();
    }

    public void ajouterMedecin(Medecin medecin) {
        medecinDAO.ajouterMedecin(medecin);
    }

    public void modifierMedecin(Medecin medecin) {
        medecinDAO.modifierMedecin(medecin);
    }

    public void supprimerMedecin(int id) {
        medecinDAO.supprimerMedecin(id);
    }

    public List<Medecin> getAllMedecins() {
        return medecinDAO.getAllMedecins();
    }

    public Medecin getMedecinById(int id) {
        return medecinDAO.getMedecinById(id);
    }
}
