package Testak;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import master.konexioa;

public class konexioaTest {

	@Test
	public void testhasi() {
        Connection conexioa = null;
		try {
            conexioa = DriverManager.getConnection("jdbc:mysql://localhost:3307/db_zinema", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
		Connection egokia = konexioa.hasi();
		assertEquals(egokia, conexioa);
	}
	
	@Test
	public void testAretoload() {
		Connection egokia = konexioa.hasi();
		konexioa k1 = new konexioa();
		
		assertEquals(k1.Aretoload(egokia), k1.Aretoload(egokia));
	}
	
	@Test
	public void testBezeroload() {
		Connection egokia = konexioa.hasi();
		konexioa k1 = new konexioa();
		
		assertEquals(k1.Bezeroload(egokia), k1.Bezeroload(egokia));
	}
	@Test
	public void testFilmaload() {
		Connection egokia = konexioa.hasi();
		konexioa k1 = new konexioa();
		
		assertEquals(k1.Filmaload(egokia), k1.Filmaload(egokia));
	}
	@Test
	public void testSaioaload() {
		Connection egokia = konexioa.hasi();
		konexioa k1 = new konexioa();
		
		assertEquals(k1.Saioaload(egokia), k1.Saioaload(egokia));
	}
	@Test
	public void testSarreraload() {
		Connection egokia = konexioa.hasi();
		konexioa k1 = new konexioa();
		
		assertEquals(k1.Sarreraload(egokia), k1.Sarreraload(egokia));
	}
	@Test
	public void testZinemaload() {
		Connection egokia = konexioa.hasi();
		konexioa k1 = new konexioa();
		
		assertEquals(k1.Zinemaload(egokia), k1.Zinemaload(egokia));
	}
	@Test
	public void testErosketaload() {
		Connection egokia = konexioa.hasi();
		konexioa k1 = new konexioa();
		
		assertEquals(k1.Erosketaload(egokia), k1.Erosketaload(egokia));
	}
	
	
}
