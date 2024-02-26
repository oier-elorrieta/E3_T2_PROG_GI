package Testak;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import master.Bezero;
import master.Modelo;
import master.Zinema;
import master.konexioa;
import master.Saioa;

import java.sql.Connection;
import java.util.Date;

public class ModeloTest {

    private Modelo modelo;

    @Before
    public void setUp() {
        modelo = new Modelo();
    }

    @Test
    public void testEgiaztatuDatuak() {
        Modelo mDatuak = new Modelo();

        // Konexioa eta datuak
        konexioa k1 = new konexioa();
        Connection saioa = k1.hasi();
        k1.fullLoad(saioa, mDatuak);
        k1.bezeroLoad(saioa, mDatuak);

        // Datuak sortu
        String erabiltzailea = "juan";
        String pasahitza = "1234";

        // Metodoa deitu eta emaitza egiaztatu
        assertFalse(mDatuak.baieztatuAdmin(null, null)); // Dena hutsik dagoenean
        assertFalse(mDatuak.baieztatuAdmin(null, pasahitza)); // Erabiltzaile eremua hutsik denean
        assertFalse(mDatuak.baieztatuAdmin(erabiltzailea, null)); // Pasahitz eremua hutsik denean
        assertTrue(mDatuak.baieztatuAdmin(erabiltzailea, pasahitza)); // Bi eremuak beteta daudenean
    }

    @Test
    public void testAbrirvEtorria() {
        // Metodoa exekutatzen den konprobatu eta erroreak ez ematea ziurtatu
        modelo.abrirvEtorria();
    }
    
    @Test
    public void testAzinema() {
    	modelo.setAzinema(modelo.getAzinema());
    	assertEquals(modelo.getAzinema(), 0);
    }

    @Test
    public void testAfilma() {
        int a = 42;
        modelo.setAfilma(a);
        assertEquals(modelo.getAfilma(), a);
    }
    
    @Test
    public void testAsaioa() {
        int a = 42;
        modelo.setAsaioa(a);
        assertEquals(modelo.getAsaioa(), a);
    }
    @Test
    public void testisIrekiLogin() {
    	modelo.setIrekiLogin(modelo.getIrekiLogin());
    	assertEquals(modelo.getIrekiLogin(), false);
    }
    @Test
    public void testSaioaklength() {
        // Asegúrate de que la lógica interna de tu programa esté funcionando correctamente
        // Puedes crear instancias de Zinema, Saioa, y otros objetos según sea necesario
        // y agregarlos al modelo antes de ejecutar las pruebas

        // Configura el estado necesario para la prueba (puedes modificar esto según tus necesidades)
        Zinema zinema = new Zinema(/* parámetros necesarios */);
        Saioa[] saioak = new Saioa[] { new Saioa(), /* más instancias de Saioa si es necesario */ };
        zinema.setSaioak(saioak);
        modelo.setZinemak(new Zinema[] { zinema });
        modelo.setAzinema(0); // Selecciona el índice del Zinema que has agregado

        // Ejecuta la función que estás probando
        int result = modelo.saioaklength();

        // Realiza la aserción (prueba)
        assertEquals(saioak.length, result);
    }
    

}
