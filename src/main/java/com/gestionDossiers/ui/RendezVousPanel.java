package com.gestionDossiers.ui;

import com.gestionDossiers.model.Medecin;
import com.gestionDossiers.model.Patient;
import com.gestionDossiers.model.RendezVous;
import com.gestionDossiers.service.RendezVousService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RendezVousPanel extends JPanel {
    private RendezVousService rendezVousService;

    public RendezVousPanel() {
        rendezVousService = new RendezVousService();
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(6, 2));
        JTextField patientIdField = new JTextField();
        JTextField medecinIdField = new JTextField();
        JTextField dateField = new JTextField();
        JTextField heureField = new JTextField();
        JTextField statutField = new JTextField();
        JButton ajouterButton = new JButton("Ajouter Rendez-vous");

        formPanel.add(new JLabel("ID Patient:"));
        formPanel.add(patientIdField);
        formPanel.add(new JLabel("ID Médecin:"));
        formPanel.add(medecinIdField);
        formPanel.add(new JLabel("Date:"));
        formPanel.add(dateField);
        formPanel.add(new JLabel("Heure:"));
        formPanel.add(heureField);
        formPanel.add(new JLabel("Statut:"));
        formPanel.add(statutField);
        formPanel.add(ajouterButton);

        ajouterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int patientId = Integer.parseInt(patientIdField.getText());
                int medecinId = Integer.parseInt(medecinIdField.getText());
                String date = dateField.getText();
                String heure = heureField.getText();
                String statut = statutField.getText();

                Patient patient = new Patient();
                patient.setId(patientId);

                Medecin medecin = new Medecin();
                medecin.setId(medecinId);

                RendezVous rendezVous = new RendezVous();
                rendezVous.setPatient(patient);
                rendezVous.setMedecin(medecin);
                rendezVous.setDate(date);
                rendezVous.setHeure(heure);
                rendezVous.setStatut(statut);

                rendezVousService.ajouterRendezVous(rendezVous);
                JOptionPane.showMessageDialog(null, "Rendez-vous ajouté avec succès!");
            }
        });

        add(formPanel, BorderLayout.CENTER);
    }
}
