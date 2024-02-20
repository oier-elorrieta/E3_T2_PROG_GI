package Testak;
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import master.Bezero;
import master.Modelo;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ModeloTest {

    @Test
    public void testEgiaztatuDatuak() {
        Modelo modelo = new Modelo();
        JTextField lblErabiltzailea = new JTextField("Jon69");
        JTextField lblPasahitza = new JTextField("1234");
        assertTrue(modelo.egiaztatuDatuak(lblErabiltzailea, lblPasahitza));
    }

    @Test
    public void testEzarrizinemak() {
        Modelo modelo = new Modelo();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Index");
        model.addColumn("Izena");
        model.addColumn("Selected");
        modelo.ezarrizinemak(model);
        assertEquals(0, model.getValueAt(0, 0));
        assertEquals("TestIzena", model.getValueAt(0, 1)); 
        assertEquals(false, model.getValueAt(0, 2));
    }

    @Test
    public void testEzarrifilmak() {
        Modelo modelo = new Modelo();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Index");
        model.addColumn("Izena");
        model.addColumn("Selected");
        modelo.ezarrifilmak(model);
        assertEquals(0, model.getValueAt(0, 0));
        assertEquals("TestIzena", model.getValueAt(0, 1)); 
        assertEquals(false, model.getValueAt(0, 2));
    }

    @Test
    public void testBaieztatuAdmin() {
        Modelo modelo = new Modelo();
        Bezero[] bezeroArray = new Bezero[1];
        Bezero bezero1 = new Bezero("12345678A", "Jon", "Jon69", "Pérez", new Date(), "jon@gmail.com", 'M', "1234");
        bezeroArray[0] = bezero1;
        modelo.setBezeroak(bezeroArray);
        assertTrue(modelo.baieztatuAdmin("Jon69", "1234"));
    }
}