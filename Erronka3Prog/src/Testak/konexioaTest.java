package Testak;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import master.Filma;
import master.Modelo;
import master.konexioa;

public class konexioaTest {

    private Connection connection;

    @Before
    public void konexioSortu() throws SQLException {
        // Konexioa sortu datu-basearekin
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/db_e3zinema", "root", "");
    }

    @After
    public void konexioItxi() throws SQLException {
        // Konexioa itxi
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
    
    
    @Test
    public void testHasi() {
    	konexioa kone = new konexioa();
        // Testatu konexioa hasi
        Connection konexioa = kone.hasi();
        // Konexioa ezin daiteke null izan
        assertNotNull(konexioa);
        try {
            // Egiaztatu konexioa ez dela itxita
            assertFalse(konexioa.isClosed());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAretoload() {
        konexioa kone = new konexioa();
        assertNotNull(connection);
        // Aretoload metodoa probatu
        assertNotNull(kone.areotoload(1, connection)); // ID bezala parametroa
    }

    @Test
    public void testBezeroload() {
        konexioa kone = new konexioa();
        Modelo mDatuak = new Modelo();
        assertNotNull(connection);
 
    }

    @Test
    public void testFilmaload() {
        konexioa kone = new konexioa();
        assertNotNull(connection);
        // Filmaload metodoa probatu
        Filma film = kone.filmaload(1, 1, connection); // ID-ak ondo daudenean
        assertNotNull(film); // Film objektua ezin daiteke null izan
    }

    @Test
    public void testSaioaload() {
        konexioa kone = new konexioa();
        assertNotNull(connection);
       
        assertNotNull(kone.saioaload(1, connection)); // ID bezala parametroa
    }



  
}