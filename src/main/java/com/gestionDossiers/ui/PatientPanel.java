package com.gestionDossiers.ui;

import com.gestionDossiers.model.Medecin;
import com.gestionDossiers.model.Patient;
import com.gestionDossiers.service.PatientService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PatientPanel extends JPanel {
    private PatientService patientService;

    public PatientPanel() {
        patientService = new PatientService();
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(6, 2));
        JTextField nomField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField dateNaissanceField = new JTextField();
        JTextField antecedentsField = new JTextField();
        JTextField medecinIdField = new JTextField();
        JButton ajouterButton = new JButton("Ajouter Patient");

        formPanel.add(new JLabel("Nom:"));
        formPanel.add(nomField);
        formPanel.add(new JLabel("Email:"));
        formPanel.add(emailField);
        formPanel.add(new JLabel("Date de Naissance:"));
        formPanel.add(dateNaissanceField);
        formPanel.add(new JLabel("Antécédents Médicaux:"));
        formPanel.add(antecedentsField);
        formPanel.add(new JLabel("ID Médecin:"));
        formPanel.add(medecinIdField);
        formPanel.add(ajouterButton);

        ajouterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nom = nomField.getText();
                String email = emailField.getText();
                String dateNaissance = dateNaissanceField.getText();
                String antecedents = antecedentsField.getText();
                int medecinId = Integer.parseInt(medecinIdField.getText());

                Medecin medecin = new Medecin();
                medecin.setId(medecinId);

                Patient patient = new Patient();
                patient.setNom(nom);
                patient.setEmail(email);
                patient.setDateNaissance(dateNaissance);
                patient.setAntecedentsMedicaux(antecedents);
                patient.setMedecinTraitant(medecin);

                patientService.ajouterPatient(patient);
                JOptionPane.showMessageDialog(null, "Patient ajouté avec succès!");
            }
        });

        add(formPanel, BorderLayout.CENTER);
    }
}
