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

    public static void main(String[] args) {
        CreateDB db = new CreateDB();
        db.testDerby();
    }
    public void testDerby() {
        Connection conn = null;
        PreparedStatement pstmt;
        Statement stmt;
        ResultSet rs;

        String createFachverfahrenSQL =
                "CREATE TABLE IF NOT EXISTS fachverfahren ( "
                + "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                + "name VARCHAR(255) NOT NULL, "
                + "CONSTRAINT primary_key PRIMARY KEY(id)); ";


        String createITVerfahrenSQL =
                "CREATE TABLE IF NOT EXISTS itverfahren("
                + "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                + "name VARCHAR(255) NOT NULL, "
                + "itKuerzel VARCHAR(255) NOT NULL, "
                + "team VARCHAR(255) NOT NULL, "
                + "ansprechpartner VARCHAR(255) NOT NULL, "
                + "fachverfahrenId INTEGER NOT NULL"
                + "CONSTRAINT primary_key PRIMARY KEY(id), "
                + "CONSTRAINT fachverfahren_id_ref FOREIGN KEY (fachverfahrenId) REFERENCES fachverfahren(id));";

        try {
            Driver derbyEmbeddedDriver = new EmbeddedDriver();
            DriverManager.registerDriver(derbyEmbeddedDriver);
            conn = DriverManager.getConnection
                    ("jdbc:derby:verfahrensliste;create=true");
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            stmt.execute(createFachverfahrenSQL);
            stmt.execute(createITVerfahrenSQL);

            /*

            pstmt = conn.prepareStatement("insert into person (name,email,phone) values(?,?,?)");
            pstmt.setString(1, "Hagar the Horrible");
            pstmt.setString(2, "hagar@somewhere.com");
            pstmt.setString(3, "1234567890");
            pstmt.executeUpdate();



            rs = stmt.executeQuery("select * from person");
            while (rs.next()) {
                System.out.printf("%d %s %s %sn",
                        rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4));
            }

            stmt.execute("drop table person");

            conn.commit();

             */

        } catch (SQLException ex) {
            System.out.println("in connection" + ex);
        }

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
}
