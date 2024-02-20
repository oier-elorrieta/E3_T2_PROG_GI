package vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import master.Modelo;

public class vLogin extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textPasahitza;
    private JTextField textErabiltzailea;
    private Modelo modelo;

    /**
     * Create the frame.
     */
    public vLogin(Modelo modelo) {
        this.modelo = modelo;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblErabiltzailea = new JLabel("Sartu erabiltzailea:");
        lblErabiltzailea.setForeground(new Color(0, 0, 0));
        lblErabiltzailea.setBounds(45, 73, 90, 14);
        contentPane.add(lblErabiltzailea);

        JLabel lblPasahitza = new JLabel("Sartu pasahitza:");
        lblPasahitza.setForeground(new Color(0, 0, 0));
        lblPasahitza.setBounds(45, 125, 90, 14);
        contentPane.add(lblPasahitza);

        textPasahitza = new JTextField();
        textPasahitza.setBounds(145, 122, 142, 20);
        contentPane.add(textPasahitza);
        textPasahitza.setColumns(10);

        textErabiltzailea = new JTextField();
        textErabiltzailea.setBounds(145, 70, 142, 20);
        contentPane.add(textErabiltzailea);
        textErabiltzailea.setColumns(10);

        JButton btnAdos = new JButton("Ados");
        btnAdos.addActionListener(new ActionListener() {
            /**
             * Description: Egiaztatu erabiltzailea eta pasahitza modeloan
             */
            public void actionPerformed(ActionEvent e) {
            	
            	modelo.egiaztatuDatuak(textErabiltzailea, textErabiltzailea);
            	 //String erabiltzailea = textErabiltzailea.getText();
                 //String pasahitza = textPasahitza.getText();
                if (modelo.egiaztatuDatuak(textErabiltzailea, textPasahitza)) {
                    // Datuak koinsiditzen dute
                    JOptionPane.showMessageDialog(contentPane, "Barruan zaude!");
                    vZinema vZinema = new vZinema(modelo);
                    vZinema.setVisible(true);
                    
                } else {
                    // Datuak ez dute koinsiditzen
                    JOptionPane.showMessageDialog(contentPane, "Zeozer txarto dago.");
                }
            }
        });
        btnAdos.setBounds(171, 183, 89, 23);
        contentPane.add(btnAdos);
    }

    /**
     * Description: Erabiltzailea eta pasahitza berifikatu.
     */
   /* private boolean egiaztatuDatuak() {
       // Erabiltzaile eta pasahitza lortu
       
        System.out.println(erabiltzailea);
        // Metodora deitu erabiltzailea eta pasahitza berifikatzeko
        boolean datuakBerif = modelo.baieztatuAdmin(erabiltzailea, pasahitza);
        
        return datuakBerif;
    }*/
    

}