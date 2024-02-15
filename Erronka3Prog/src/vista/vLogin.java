package vista;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JProgressBar;
import master.Modelo;
import master.Controlador;


public class vLogin extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textPasahitza;
	private JTextField textErabiltzailea;

	/**
	 * Create the frame. Description: Idatzitako datuak hartzen ditu eta konparatzen
	 * ditu, hiru bide desberdinetatik pasa ahal da, Admin, erabiltzailea edo txarto
	 * sartutako datuak
	 */
	public vlogin(Modelo Modelo) {
		vlogin vloginPanel = this;
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
				if (loginAdmin(Modelo)) {
					// Admin baldin bada, atera VAmenua
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							new VAmenua(Modelo).setVisible(true);
							vloginPanel.setVisible(false);
						}
					});
				} else if (textErabiltzailea.getText().equals("erabili") && textPasahitza.getText().equals("4321")) {
					// Erabiltzailea baldin bada, atera GeneroAutaketaMenua
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							new GeneroAutaketaMenua(Modelo).setVisible(true);
							vloginPanel.setVisible(false);
						}
					});
					// itxi lehio aktuala (vlogin)
					dispose();
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
	private boolean loginAdmin(Modelo modelo) {
		boolean loginAdminOk = modelo.baieztatuAdmin(textErabiltzailea.getText(), textPasahitza.getText());
		if (loginAdminOk) {
			JOptionPane.showMessageDialog(contentPane, "    Barruan zaude" + '\n' + "Administrazailearen baimenak");
		}
		return loginAdminOk;
	}

	/**
	 * Description: Berifikatu erabiltzailea
	 * 
	 * @return
	 */
	public boolean loginErabiltzailea() {
		boolean login_erabiltzailea_ok = false;

		if (Modelo.baieztatuErabiltzailea(textErabiltzailea.getText(), textPasahitza.getText())) {
			JOptionPane.showMessageDialog(contentPane, "    Barruan zaude" + '\n' + " Erabiltzailearen baimenak");
			login_erabiltzailea_ok = true;
		}
		return login_erabiltzailea_ok;
	}

}
