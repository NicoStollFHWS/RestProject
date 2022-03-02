package com.example.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.derby.jdbc.EmbeddedDriver;

public class CreateDB {

    private Connection conn = null;

    public CreateDB() {
        createDerbyDB();
    }
    public void createDerbyDB() {
        PreparedStatement pstmt;
        Statement stmt;
        ResultSet rs;

        String createFachverfahrenSQL =
                "CREATE TABLE fachverfahren ( "
                + "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                + "name VARCHAR(255) NOT NULL, "
                + "CONSTRAINT primary_key_fachverfahren PRIMARY KEY(id))";

        String createITVerfahrenSQL =
                "CREATE TABLE itverfahren ( "
                + "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                + "name VARCHAR(255) NOT NULL, "
                + "itKuerzel VARCHAR(255) NOT NULL, "
                + "team VARCHAR(255) NOT NULL, "
                + "ansprechpartner VARCHAR(255) NOT NULL, "
                + "fachverfahrenId INTEGER NOT NULL, "
                + "CONSTRAINT primary_key_itverfahren PRIMARY KEY(id), "
                + "CONSTRAINT fachverfahren_id_ref FOREIGN KEY (fachverfahrenId) REFERENCES fachverfahren(id))";

        try {
            Driver derbyEmbeddedDriver = new EmbeddedDriver();
            DriverManager.registerDriver(derbyEmbeddedDriver);
            this.conn = DriverManager.getConnection
                    ("jdbc:derby:verfahrensliste;create=true");
            this.conn.setAutoCommit(false);
            stmt = conn.createStatement();
            stmt.execute(createFachverfahrenSQL);
            stmt.execute(createITVerfahrenSQL);

            this.conn.commit();

        } catch (SQLException ex) {
            System.out.println("in connection " + ex);
        }

        dummyData();
    }

    public void shutDown() {
        try {
            DriverManager.getConnection
                    ("jdbc:derby:;shutdown=true");
        } catch (SQLException ex) {
            if (((ex.getErrorCode() == 50000) &&
                    ("XJ015".equals(ex.getSQLState())))) {
                System.out.println("Derby shut down normally");
            } else {
                System.err.println("Derby did not shut down normally");
                System.err.println(ex.getMessage());
            }
        }
    }

    public void dummyData() {
        PreparedStatement pstmt;
        Statement stmt;
        ResultSet rs;

        try {
            stmt = this.conn.createStatement();
            pstmt = this.conn.prepareStatement("insert into fachverfahren (name) values(?)");
            pstmt.setString(1, "F.001 Anspruchs und Antwartschaftüberführungsgesetz");
            pstmt.executeUpdate();

            pstmt = this.conn.prepareStatement("INSERT INTO itverfahren (name, itKuerzel, team, ansprechpartner, fachverfahrenId) values (?,?,?,?,?)");
            pstmt.setString(1, "C.001.01 Anspruchs- und Anwartschaftsüberführungsgesetz");
            pstmt.setString(2, "aaug");
            pstmt.setString(3, "0551-11");
            pstmt.setString(4, "Wolfgang Möckl");
            pstmt.setInt(5, 1);
            pstmt.executeUpdate();

            rs = stmt.executeQuery(
                        "SELECT * "
                            + "FROM itverfahren "
                            + "JOIN fachverfahren on fachverfahren.id = itverfahren.fachverfahrenId");
            while (rs.next()) {
                System.out.printf("%d %s %s %s %s %s %s %s\n",
                        rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getString(8));
            }

        } catch (SQLException e) {
            System.err.println(e.getErrorCode());
        }

    }

    public Connection getConn() {
        return conn;
    }
}
