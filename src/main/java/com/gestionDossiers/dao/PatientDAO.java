package com.gestionDossiers.dao;

import com.gestionDossiers.model.Medecin;
import com.gestionDossiers.model.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {
    public void ajouterPatient(Patient patient) {
        String sql = "INSERT INTO patients (nom, email, date_naissance, antecedents_medicaux, medecin_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, patient.getNom());
            pstmt.setString(2, patient.getEmail());
            pstmt.setString(3, patient.getDateNaissance());
            pstmt.setString(4, patient.getAntecedentsMedicaux());
            pstmt.setInt(5, patient.getMedecinTraitant().getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifierPatient(Patient patient) {
        String sql = "UPDATE patients SET nom = ?, email = ?, date_naissance = ?, antecedents_medicaux = ?, medecin_id = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, patient.getNom());
            pstmt.setString(2, patient.getEmail());
            pstmt.setString(3, patient.getDateNaissance());
            pstmt.setString(4, patient.getAntecedentsMedicaux());
            pstmt.setInt(5, patient.getMedecinTraitant().getId());
            pstmt.setInt(6, patient.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void supprimerPatient(int id) {
        String sql = "DELETE FROM patients WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Patient> rechercherPatientsParNom(String nom) {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT p.*, m.id as medecin_id, m.nom as medecin_nom, m.specialite as medecin_specialite " +
                "FROM patients p " +
                "JOIN medecins m ON p.medecin_id = m.id " +
                "WHERE p.nom LIKE ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + nom + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Patient patient = new Patient();
                patient.setId(rs.getInt("id"));
                patient.setNom(rs.getString("nom"));
                patient.setEmail(rs.getString("email"));
                patient.setDateNaissance(rs.getString("date_naissance"));
                patient.setAntecedentsMedicaux(rs.getString("antecedents_medicaux"));

                Medecin medecin = new Medecin();
                medecin.setId(rs.getInt("medecin_id"));
                medecin.setNom(rs.getString("medecin_nom"));
                medecin.setSpecialite(rs.getString("medecin_specialite"));

                patient.setMedecinTraitant(medecin);
                patients.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }

    public Patient getPatientById(int id) {
        Patient patient = null;
        String sql = "SELECT p.*, m.id as medecin_id, m.nom as medecin_nom, m.specialite as medecin_specialite " +
                "FROM patients p " +
                "JOIN medecins m ON p.medecin_id = m.id " +
                "WHERE p.id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                patient = new Patient();
                patient.setId(rs.getInt("id"));
                patient.setNom(rs.getString("nom"));
                patient.setEmail(rs.getString("email"));
                patient.setDateNaissance(rs.getString("date_naissance"));
                patient.setAntecedentsMedicaux(rs.getString("antecedents_medicaux"));

                Medecin medecin = new Medecin();
                medecin.setId(rs.getInt("medecin_id"));
                medecin.setNom(rs.getString("medecin_nom"));
                medecin.setSpecialite(rs.getString("medecin_specialite"));

                patient.setMedecinTraitant(medecin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patient;
    }

    public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT p.*, m.id as medecin_id, m.nom as medecin_nom, m.specialite as medecin_specialite " +
                "FROM patients p " +
                "JOIN medecins m ON p.medecin_id = m.id";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Patient patient = new Patient();
                patient.setId(rs.getInt("id"));
                patient.setNom(rs.getString("nom"));
                patient.setEmail(rs.getString("email"));
                patient.setDateNaissance(rs.getString("date_naissance"));
                patient.setAntecedentsMedicaux(rs.getString("antecedents_medicaux"));

                Medecin medecin = new Medecin();
                medecin.setId(rs.getInt("medecin_id"));
                medecin.setNom(rs.getString("medecin_nom"));
                medecin.setSpecialite(rs.getString("medecin_specialite"));

                patient.setMedecinTraitant(medecin);
                patients.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }
}
