package com.gestionDossiers.ui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Gestion de Dossiers Médicaux");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Patients", new PatientPanel());
        tabbedPane.addTab("Médecins", new MedecinPanel());
        tabbedPane.addTab("Rendez-vous", new RendezVousPanel());
        tabbedPane.addTab("Traitements", new TraitementPanel());

        add(tabbedPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}
