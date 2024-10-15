package com.gestionDossiers.ui;

import com.gestionDossiers.model.Patient;
import com.gestionDossiers.model.Traitement;
import com.gestionDossiers.service.TraitementService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TraitementPanel extends JPanel {
    private TraitementService traitementService;

    public TraitementPanel() {
        traitementService = new TraitementService();
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(5, 2));
        JTextField patientIdField = new JTextField();
        JTextField typeTraitementField = new JTextField();
        JTextField posologieField = new JTextField();
        JTextField dureeField = new JTextField();
        JButton ajouterButton = new JButton("Ajouter Traitement");

        formPanel.add(new JLabel("ID Patient:"));
        formPanel.add(patientIdField);
        formPanel.add(new JLabel("Type de Traitement:"));
        formPanel.add(typeTraitementField);
        formPanel.add(new JLabel("Posologie:"));
        formPanel.add(posologieField);
        formPanel.add(new JLabel("Durée:"));
        formPanel.add(dureeField);
        formPanel.add(ajouterButton);

        ajouterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int patientId = Integer.parseInt(patientIdField.getText());
                String typeTraitement = typeTraitementField.getText();
                String posologie = posologieField.getText();
                String duree = dureeField.getText();

                Patient patient = new Patient();
                patient.setId(patientId);

                Traitement traitement = new Traitement();
                traitement.setPatient(patient);
                traitement.setTypeTraitement(typeTraitement);
                traitement.setPosologie(posologie);
                traitement.setDuree(duree);

                traitementService.ajouterTraitement(traitement);
                JOptionPane.showMessageDialog(null, "Traitement ajouté avec succès!");
            }
        });

        add(formPanel, BorderLayout.CENTER);
    }
}
