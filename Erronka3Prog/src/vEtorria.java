import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.awt.Font;

public class vEtorria extends JFrame {

	private static final long serialVersionUID = 1L;
	private JProgressBar Karga;
	private JLabel lblOngiEtorri;
	private JLabel lblSakatu;
	private Modelo Modelo;

	/**
	 * Description: Leio bat irekitzen da non edozein lekutan klik egin ahal den,
	 * klikatzerakoan leioa eguneratzen da.
	 * 
	 * @param Modelo
	 */
	public vEtorria(Modelo Modelo) {
		this.Modelo = Modelo;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		lblOngiEtorri = new JLabel("Ongi etorri!");
		lblOngiEtorri.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblOngiEtorri.setBounds(115, 42, 202, 76);
		lblOngiEtorri.setVisible(false);
		getContentPane().add(lblOngiEtorri);

		Karga = new JProgressBar();
		Karga.setBounds(136, 165, 146, 14);
		Karga.setVisible(false);
		getContentPane().add(Karga);

	
		lblSakatu = new JLabel("Klikatu leioan programa hasteko");
		lblSakatu.setBounds(125, 115, 208, 27);
		getContentPane().add(lblSakatu);

		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * Description: Hemen lortzen dena, pantaila eguneratzen den ostekoa da, ongi
			 * etorri mezua agertuko da kargatzen den barra batekin
			 */
			public void mouseClicked(MouseEvent e) {
				lblSakatu.setVisible(false);
				lblOngiEtorri.setVisible(true);
				Karga.setVisible(true);

				Thread kargaThread = new Thread(new Runnable() {
					@Override
					/**
					 * Description: Kargatzen den barrari "barridoak" egiten dio "for"-a bitartez, 1
					 * etik 100 eran, 30 pauso bihurtzen ditu.
					 * 
					 */
					public void run() {
						for (int i = 0; i < 100; i++) {
							try {
								Thread.sleep(30);
							} catch (Exception e) {
								System.out.println(e);
							}
							Karga.setValue(i);
						}
						Modelo.irkeiLogin = true;
						dispose();
					}
				});

				kargaThread.start();
			}
		});
	}
}
