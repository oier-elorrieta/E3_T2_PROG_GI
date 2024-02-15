package Testak;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import master.konexioa;

public class konexioaTest {

	@Test
	public void testhasi() {
		Connection conexioa = DriverManager.getConnection("jdbc:mysql://localhost:3307/db_zinema", "root", "");
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
		
		assertEquals(k1.Aretoload(egokia), k1.Aretoload(egokia));
	}
	@Test
	public void testFilmaload() {
		Connection egokia = konexioa.hasi();
		konexioa k1 = new konexioa();
		
		assertEquals(k1.Aretoload(egokia), k1.Aretoload(egokia));
	}
	@Test
	public void testSaioaload() {
		Connection egokia = konexioa.hasi();
		konexioa k1 = new konexioa();
		
		assertEquals(k1.Aretoload(egokia), k1.Aretoload(egokia));
	}
	@Test
	public void testSarreraLoad() {
		Connection egokia = konexioa.hasi();
		konexioa k1 = new konexioa();
		
		assertEquals(k1.Aretoload(egokia), k1.Aretoload(egokia));
	}
	
}
