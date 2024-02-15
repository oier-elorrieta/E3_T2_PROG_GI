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
             * Description: Bi bide zabaltzen dira, admin eta erabiltzailea, bakoitzak
             * programan sartzeko modu desberdinak dira.
             */
            public void actionPerformed(ActionEvent e) {
                if (loginAdmin()) {
                    // Admin baldin bada, atera VAmenua
                    JOptionPane.showMessageDialog(contentPane, "    Barruan zaude" + '\n' + "Administrazailearen baimenak");
                } else if (textErabiltzailea.getText().equals("erabili") && textPasahitza.getText().equals("4321")) {
                    // Erabiltzailea baldin bada, atera GeneroAutaketaMenua
                    JOptionPane.showMessageDialog(contentPane, "    Barruan zaude" + '\n' + " Erabiltzailearen baimenak");
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Zeozer txarto idatzi duzu");
                }
            }
        });
        btnAdos.setBounds(171, 183, 89, 23);
        contentPane.add(btnAdos);
    }

    /**
     * Description: Berifikatu administratzailea
     * 
     * @return
     */
    private boolean loginAdmin() {
        boolean loginAdminOk = modelo.baieztatuAdmin(textErabiltzailea.getText(), textPasahitza.getText());
        return loginAdminOk;
    }
}