package com.gestionDossiers.dao;

import com.gestionDossiers.model.Medecin;
import com.gestionDossiers.model.Patient;
import com.gestionDossiers.model.RendezVous;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RendezVousDAO {
    public void ajouterRendezVous(RendezVous rendezVous) {
        String sql = "INSERT INTO rendez_vous (patient_id, medecin_id, date, heure, statut) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, rendezVous.getPatient().getId());
            pstmt.setInt(2, rendezVous.getMedecin().getId());
            pstmt.setString(3, rendezVous.getDate());
            pstmt.setString(4, rendezVous.getHeure());
            pstmt.setString(5, rendezVous.getStatut());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifierRendezVous(RendezVous rendezVous) {
        String sql = "UPDATE rendez_vous SET patient_id = ?, medecin_id = ?, date = ?, heure = ?, statut = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, rendezVous.getPatient().getId());
            pstmt.setInt(2, rendezVous.getMedecin().getId());
            pstmt.setString(3, rendezVous.getDate());
            pstmt.setString(4, rendezVous.getHeure());
            pstmt.setString(5, rendezVous.getStatut());
            pstmt.setInt(6, rendezVous.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void supprimerRendezVous(int id) {
        String sql = "DELETE FROM rendez_vous WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<RendezVous> getAllRendezVous() {
        List<RendezVous> rendezVousList = new ArrayList<>();
        String sql = "SELECT r.*, p.id as patient_id, p.nom as patient_nom, p.email as patient_email, p.date_naissance as patient_date_naissance, p.antecedents_medicaux as patient_antecedents_medicaux, " +
                "m.id as medecin_id, m.nom as medecin_nom, m.specialite as medecin_specialite " +
                "FROM rendez_vous r " +
                "JOIN patients p ON r.patient_id = p.id " +
                "JOIN medecins m ON r.medecin_id = m.id";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                RendezVous rendezVous = new RendezVous();
                rendezVous.setId(rs.getInt("id"));

                Patient patient = new Patient();
                patient.setId(rs.getInt("patient_id"));
                patient.setNom(rs.getString("patient_nom"));
                patient.setEmail(rs.getString("patient_email"));
                patient.setDateNaissance(rs.getString("patient_date_naissance"));
                patient.setAntecedentsMedicaux(rs.getString("patient_antecedents_medicaux"));

                Medecin medecin = new Medecin();
                medecin.setId(rs.getInt("medecin_id"));
                medecin.setNom(rs.getString("medecin_nom"));
                medecin.setSpecialite(rs.getString("medecin_specialite"));

                rendezVous.setPatient(patient);
                rendezVous.setMedecin(medecin);
                rendezVous.setDate(rs.getString("date"));
                rendezVous.setHeure(rs.getString("heure"));
                rendezVous.setStatut(rs.getString("statut"));
                rendezVousList.add(rendezVous);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rendezVousList;
    }

    public RendezVous getRendezVousById(int id) {
        RendezVous rendezVous = null;
        String sql = "SELECT r.*, p.id as patient_id, p.nom as patient_nom, p.email as patient_email, p.date_naissance as patient_date_naissance, p.antecedents_medicaux as patient_antecedents_medicaux, " +
                "m.id as medecin_id, m.nom as medecin_nom, m.specialite as medecin_specialite " +
                "FROM rendez_vous r " +
                "JOIN patients p ON r.patient_id = p.id " +
                "JOIN medecins m ON r.medecin_id = m.id " +
                "WHERE r.id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                rendezVous = new RendezVous();
                rendezVous.setId(rs.getInt("id"));

                Patient patient = new Patient();
                patient.setId(rs.getInt("patient_id"));
                patient.setNom(rs.getString("patient_nom"));
                patient.setEmail(rs.getString("patient_email"));
                patient.setDateNaissance(rs.getString("patient_date_naissance"));
                patient.setAntecedentsMedicaux(rs.getString("patient_antecedents_medicaux"));

                Medecin medecin = new Medecin();
                medecin.setId(rs.getInt("medecin_id"));
                medecin.setNom(rs.getString("medecin_nom"));
                medecin.setSpecialite(rs.getString("medecin_specialite"));

                rendezVous.setPatient(patient);
                rendezVous.setMedecin(medecin);
                rendezVous.setDate(rs.getString("date"));
                rendezVous.setHeure(rs.getString("heure"));
                rendezVous.setStatut(rs.getString("statut"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rendezVous;
    }
}
