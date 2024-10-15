package com.gestionDossiers.dao;

import com.gestionDossiers.model.Patient;
import com.gestionDossiers.model.Traitement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TraitementDAO {
    public void ajouterTraitement(Traitement traitement) {
        String sql = "INSERT INTO traitements (patient_id, type_traitement, posologie, duree) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, traitement.getPatient().getId());
            pstmt.setString(2, traitement.getTypeTraitement());
            pstmt.setString(3, traitement.getPosologie());
            pstmt.setString(4, traitement.getDuree());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifierTraitement(Traitement traitement) {
        String sql = "UPDATE traitements SET patient_id = ?, type_traitement = ?, posologie = ?, duree = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, traitement.getPatient().getId());
            pstmt.setString(2, traitement.getTypeTraitement());
            pstmt.setString(3, traitement.getPosologie());
            pstmt.setString(4, traitement.getDuree());
            pstmt.setInt(5, traitement.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void supprimerTraitement(int id) {
        String sql = "DELETE FROM traitements WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Traitement> getAllTraitements() {
        List<Traitement> traitements = new ArrayList<>();
        String sql = "SELECT t.*, p.id as patient_id, p.nom as patient_nom, p.email as patient_email, p.date_naissance as patient_date_naissance, p.antecedents_medicaux as patient_antecedents_medicaux " +
                "FROM traitements t " +
                "JOIN patients p ON t.patient_id = p.id";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Traitement traitement = new Traitement();
                traitement.setId(rs.getInt("id"));

                Patient patient = new Patient();
                patient.setId(rs.getInt("patient_id"));
                patient.setNom(rs.getString("patient_nom"));
                patient.setEmail(rs.getString("patient_email"));
                patient.setDateNaissance(rs.getString("patient_date_naissance"));
                patient.setAntecedentsMedicaux(rs.getString("patient_antecedents_medicaux"));

                traitement.setPatient(patient);
                traitement.setTypeTraitement(rs.getString("type_traitement"));
                traitement.setPosologie(rs.getString("posologie"));
                traitement.setDuree(rs.getString("duree"));
                traitements.add(traitement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return traitements;
    }

    public Traitement getTraitementById(int id) {
        Traitement traitement = null;
        String sql = "SELECT t.*, p.id as patient_id, p.nom as patient_nom, p.email as patient_email, p.date_naissance as patient_date_naissance, p.antecedents_medicaux as patient_antecedents_medicaux " +
                "FROM traitements t " +
                "JOIN patients p ON t.patient_id = p.id " +
                "WHERE t.id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                traitement = new Traitement();
                traitement.setId(rs.getInt("id"));

                Patient patient = new Patient();
                patient.setId(rs.getInt("patient_id"));
                patient.setNom(rs.getString("patient_nom"));
                patient.setEmail(rs.getString("patient_email"));
                patient.setDateNaissance(rs.getString("patient_date_naissance"));
                patient.setAntecedentsMedicaux(rs.getString("patient_antecedents_medicaux"));

                traitement.setPatient(patient);
                traitement.setTypeTraitement(rs.getString("type_traitement"));
                traitement.setPosologie(rs.getString("posologie"));
                traitement.setDuree(rs.getString("duree"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return traitement;
    }
}
