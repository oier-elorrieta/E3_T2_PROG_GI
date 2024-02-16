package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;

import master.Modelo;
import master.konexioa;

public class vData extends JFrame {
	private JCalendar egutegia;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtAukeratuEguna;
	private Modelo modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modelo modelo = new Modelo();
					vData frame = new vData(modelo);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public vData(Modelo modelo) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtAukeratuEguna = new JTextField();
		txtAukeratuEguna.setBounds(5, 5, 424, 28);
		txtAukeratuEguna.setHorizontalAlignment(SwingConstants.CENTER);
		txtAukeratuEguna.setBackground(SystemColor.menu);
		txtAukeratuEguna.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtAukeratuEguna.setText("Aukeratu eguna:");
		contentPane.add(txtAukeratuEguna);
		txtAukeratuEguna.setColumns(10);
		
		egutegia = new JCalendar();
		egutegia.setTodayButtonText("");
		egutegia.setSundayForeground(Color.BLUE);
		egutegia.setBounds(112, 33, 212, 223);
		contentPane.add(egutegia);
		
		JButton btnNewButton = new JButton("Hautatu");
		btnNewButton.setBounds(334, 117, 78, 37);
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(e -> {
            java.util.Date erabakitakoEguna = egutegia.getDate();
            System.out.println("Fecha seleccionada: " + erabakitakoEguna);
        });

	}
	
	
}
