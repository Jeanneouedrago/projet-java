package com.gestionDossiers.ui;

import com.gestionDossiers.model.Medecin;
import com.gestionDossiers.service.MedecinService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MedecinPanel extends JPanel {
    private MedecinService medecinService;

    public MedecinPanel() {
        medecinService = new MedecinService();
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(4, 2));
        JTextField nomField = new JTextField();
        JTextField specialiteField = new JTextField();
        JButton ajouterButton = new JButton("Ajouter Médecin");

        formPanel.add(new JLabel("Nom:"));
        formPanel.add(nomField);
        formPanel.add(new JLabel("Spécialité:"));
        formPanel.add(specialiteField);
        formPanel.add(ajouterButton);

        ajouterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nom = nomField.getText();
                String specialite = specialiteField.getText();

                Medecin medecin = new Medecin();
                medecin.setNom(nom);
                medecin.setSpecialite(specialite);

                medecinService.ajouterMedecin(medecin);
                JOptionPane.showMessageDialog(null, "Médecin ajouté avec succès!");
            }
        });

        add(formPanel, BorderLayout.CENTER);
    }
}
