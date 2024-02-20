package vista;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import master.Modelo;
import master.Saioa;
import master.Zinema;

import javax.swing.SpringLayout;

public class vData extends JFrame {

    private static final long serialVersionUID = 1L;

    public vData() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        Modelo mDatuak = new Modelo();
        vData(mDatuak);
    }

    private void vData(Modelo mDatuak) {
        UtilDateModel model = new UtilDateModel();
        Properties properties = new Properties();
        properties.put("text.today", "Hoy");
        properties.put("text.month", "Mes");
        properties.put("text.year", "Año");

        model.setDate(2024, Calendar.FEBRUARY, 1);

        JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());
        SpringLayout springLayout = (SpringLayout) datePicker.getLayout();
        springLayout.putConstraint(SpringLayout.WEST, datePicker.getJFormattedTextField(), 10, SpringLayout.WEST, datePicker);
        datePicker.setBounds(41, 5, 202, 23);
        datePicker.getJFormattedTextField().setEditable(true);

        // Botón "Seleccionar Fecha"
        JButton btnSeleccionarFecha = new JButton("Aukeratu");
        btnSeleccionarFecha.setBounds(96, 39, 77, 23);
        btnSeleccionarFecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validarFechaSeleccionada(datePicker, model, mDatuak);
            }
        });

        Container container = getContentPane();
        getContentPane().setLayout(null);
        container.add(datePicker);
        container.add(btnSeleccionarFecha);

        model.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("value".equals(evt.getPropertyName())) {

                }
            }
        });

        setSize(300, 200);
        setVisible(true);
    }

    private void validarFechaSeleccionada(JDatePickerImpl datePicker, UtilDateModel model, Modelo mDatuak) {
        Date selectedDate = model.getValue();
        Date currentDate = new Date();
        
        //Data gaurko eguna baino zaharragoa bada ezin da aukeratu
        if (selectedDate != null && selectedDate.before(currentDate)) {
            model.setDate(2024, Calendar.FEBRUARY, 1);
            model.setSelected(true);
            JOptionPane.showMessageDialog(this, "Ezin duzu data zaharrak aukeratu");
        } else {
            // Dataren formatua zuzena
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String aukeratutakoData = sdf.format(selectedDate);

            // probak egiteko datak
            String[] fechasPrueba = { "2024-03-15", "2024-04-10", "2024-05-05" };
            Saioak[] saioak = new Zinema[mDatuak.azinema]

            // Egiaztatu probako datekin
            boolean dataZuzena = false;
            
            for (String fecha : fechasPrueba) {
                if (aukeratutakoData.equals(fecha)) {
                    dataZuzena = true;
                    break;
                }
            }

            if (dataZuzena) {
                
                JOptionPane.showMessageDialog(this,  "Aukeratu duzun data zuzena da: " + aukeratutakoData);
            } else {
                
                JOptionPane.showMessageDialog(this,
                        "Data hau ez dago erabilgarri, mesedez beste bat aukeratu");
            }
        }
    }

    //Dataren eguna edo urtea edo hilabetea ateratzeko bakarrik
    /*
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(selectedDate);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            // Imprimir solo el día
            System.out.println("Día seleccionado: " + day);*/
    
    
    
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                vData frame = new vData();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
