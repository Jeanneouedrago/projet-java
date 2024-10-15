package com.gestionDossiers.dao;

import com.gestionDossiers.model.Medecin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedecinDAO {
    public void ajouterMedecin(Medecin medecin) {
        String sql = "INSERT INTO medecins (nom, specialite) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, medecin.getNom());
            pstmt.setString(2, medecin.getSpecialite());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifierMedecin(Medecin medecin) {
        String sql = "UPDATE medecins SET nom = ?, specialite = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, medecin.getNom());
            pstmt.setString(2, medecin.getSpecialite());
            pstmt.setInt(3, medecin.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void supprimerMedecin(int id) {
        String sql = "DELETE FROM medecins WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Medecin> getAllMedecins() {
        List<Medecin> medecins = new ArrayList<>();
        String sql = "SELECT * FROM medecins";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Medecin medecin = new Medecin();
                medecin.setId(rs.getInt("id"));
                medecin.setNom(rs.getString("nom"));
                medecin.setSpecialite(rs.getString("specialite"));
                medecins.add(medecin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medecins;
    }

    public Medecin getMedecinById(int id) {
        Medecin medecin = null;
        String sql = "SELECT * FROM medecins WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                medecin = new Medecin();
                medecin.setId(rs.getInt("id"));
                medecin.setNom(rs.getString("nom"));
                medecin.setSpecialite(rs.getString("specialite"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medecin;
    }
}
