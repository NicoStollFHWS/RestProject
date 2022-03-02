package com.example.dao;

import com.example.model.Fachverfahren;
import com.example.model.ITVerfahren;
import com.example.model.Verfahrensliste;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repository {

    Connection conn;

    public Repository() {
        this.conn = new CreateDB().getConn();
    }

    /**
     * Gibt die komplette Verfahrensliste aus
     * @return Verfahrensliste
     */
    public Verfahrensliste getVerfahrensliste() {

        Verfahrensliste verfahrensliste = new Verfahrensliste();
        verfahrensliste.setFachverfahren(getAllFachverfahren());
        return verfahrensliste;
    }

    /**
     * Gibt alle Fachverfahren mit dazugehörigen ItVerfahren aus
     * @return List<Fachverfahren>
     */
    public List<Fachverfahren> getAllFachverfahren() {
        List<Fachverfahren> fachverfahren = new ArrayList<>();
        String getSQL = "SELECT * FROM fachverfahren";
        try {
            PreparedStatement stmt = conn.prepareStatement(getSQL);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while(rs.next()) {
                Fachverfahren f = new Fachverfahren(rs.getInt(1), rs.getString(2));
                f.setItVerfahren(getAllItVerfahren(f.getId()));
                fachverfahren.add(f);
            }
        } catch (SQLException e) {
            System.err.println("Methode getAllFachverfahren hat nicht funktioniert: \n" + e.getErrorCode());
        }
        return fachverfahren;
    }


    /**
     * Gibt alle ItVerfahren zu einem bestimmten Fachverfahren aus
     * @return List<ITVerfahren>
     */
    public List<ITVerfahren> getAllItVerfahren(int fachverfahrenId) {
        String getSQL = "SELECT * FROM fachverfahren f " +
                "JOIN itverfahren i on f.id = i.fachverfahrenId " +
                "WHERE f.id = " + fachverfahrenId;

        List<ITVerfahren> itVerfahren = new ArrayList<>();

        try {
            PreparedStatement stmt = conn.prepareStatement(getSQL);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while(rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String itKuerzel = rs.getString(3);
                String team = rs.getString(4);
                String ansprechpartner = rs.getString(5);

                itVerfahren.add(new ITVerfahren(id, name, itKuerzel, team, ansprechpartner));

            }
        } catch (SQLException e) {
            System.err.println("Methode getAllItVerfahren hat nicht funktioniert:\n" + e.getMessage());
        }

        return itVerfahren;

    }

    public ITVerfahren getItVerfahren(int fachverfahrensId, int itVerfahrensId) {
        String SQL =
                "SELECT * "
                + "FROM itverfahren"
                + "WHERE id =" + itVerfahrensId + " AND fachverfahrenId = " + fachverfahrensId + " ;";
        ITVerfahren itVerfahren = null;

        try {
            PreparedStatement stmt = conn.prepareStatement(SQL);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while(rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String itKuerzel = rs.getString(3);
                String team = rs.getString(4);
                String ansprechpartner = rs.getString(5);

                itVerfahren = new ITVerfahren(id, name, itKuerzel, team, ansprechpartner);
            }
        } catch (SQLException e) {
            System.err.println("Methode getItVerfharen SQLAbfrage hat nicht funktioniert:\n" + e.getErrorCode());
        }

        return itVerfahren;
    }


}
