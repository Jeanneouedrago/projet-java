package com.gestionDossiers.service;

import com.gestionDossiers.dao.RendezVousDAO;
import com.gestionDossiers.model.RendezVous;

import java.util.List;

public class RendezVousService {
    private RendezVousDAO rendezVousDAO;

    public RendezVousService() {
        this.rendezVousDAO = new RendezVousDAO();
    }

    public void ajouterRendezVous(RendezVous rendezVous) {
        rendezVousDAO.ajouterRendezVous(rendezVous);
    }

    public void modifierRendezVous(RendezVous rendezVous) {
        rendezVousDAO.modifierRendezVous(rendezVous);
    }

    public void supprimerRendezVous(int id) {
        rendezVousDAO.supprimerRendezVous(id);
    }

    public List<RendezVous> getAllRendezVous() {
        return rendezVousDAO.getAllRendezVous();
    }

    public RendezVous getRendezVousById(int id) {
        return rendezVousDAO.getRendezVousById(id);
    }
}
