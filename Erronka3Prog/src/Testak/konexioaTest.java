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
	public void test

}
