package com.gestionDossiers.service;

import com.gestionDossiers.dao.TraitementDAO;
import com.gestionDossiers.model.Traitement;

import java.util.List;

public class TraitementService {
    private TraitementDAO traitementDAO;

    public TraitementService() {
        this.traitementDAO = new TraitementDAO();
    }

    public void ajouterTraitement(Traitement traitement) {
        traitementDAO.ajouterTraitement(traitement);
    }

    public void modifierTraitement(Traitement traitement) {
        traitementDAO.modifierTraitement(traitement);
    }

    public void supprimerTraitement(int id) {
        traitementDAO.supprimerTraitement(id);
    }

    public List<Traitement> getAllTraitements() {
        return traitementDAO.getAllTraitements();
    }

    public Traitement getTraitementById(int id) {
        return traitementDAO.getTraitementById(id);
    }
}
