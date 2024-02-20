package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import master.Modelo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
* Description: Admin menua
*/



public class vZinema extends JFrame {
	/**
	 * Description: Hasierako aldagaiak
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel model;
	/**
	 * Description: Admin menuaren konstruktorea
	 *
	 * @param Modelo
	 */
	public vZinema(Modelo Modelo) {
		//setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\in1dm3-d\\Downloads\\logoErronka2.jpg"));
		
		// Hasierako leihoa konfiguratu
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Admin menua");
		setSize(500, 300);
		// taularen modeloa sortu
		model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Izena");
		model.addColumn("Aukera");
		// Taula berriaren modeloa sortu
		JTable table = new JTable(model);
		// Agregar un ActionListener al radio button para gestionar la selección única
		table.getColumnModel().getColumn(2).setCellEditor(new RadioButtonEditor());
		table.getColumnModel().getColumn(2).setCellRenderer(new RadioButtonRenderer());
		// Taula JScrollPane barruan ezarri
		JScrollPane scrollPane = new JScrollPane(table);
		Modelo.ezarrizinemak(model);
		// Gorde botoia sortu
		JButton closeButton = new JButton("Jarraitu");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowCount = model.getRowCount();
				// Fila bat baino gehiago dagoela konfirmatu
				if (rowCount > 1) {
					int selectedRow = table.getSelectedRow();
					if (selectedRow >= 0) {
						model.removeRow(selectedRow);
						JOptionPane.showMessageDialog(vZinema.this, table.getModel().getValueAt(selectedRow, 1).toString(), "Aukera", JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(vZinema.this, "Aukeratu Zinema bat", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		// Botoiak panel barruan sartu
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(closeButton);
		// Komponenteak aukeratu non sartuko diren
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
	}
	
	
	
	
	
// Radio buttonak ikusgarri agertzeko
	class RadioButtonRenderer implements TableCellRenderer {
		private JRadioButton button;
		public RadioButtonRenderer() {
			button = new JRadioButton();
			button.setHorizontalAlignment(SwingConstants.CENTER);
		}
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			button.setSelected((value != null && (Boolean) value));
			return button;
		}
	}
// Barruko klasea Radio buttonak editatzeko
	class RadioButtonEditor extends DefaultCellEditor implements ActionListener {
		/**
		 * Description: Botoiaren izaera definitzen du
		 */
		private static final long serialVersionUID = 1L;
		private JRadioButton button;
		private int selectedRow;
		public RadioButtonEditor() {
			super(new JCheckBox());
			this.button = new JRadioButton();
			this.button.setHorizontalAlignment(SwingConstants.CENTER);
			button.addActionListener(this);
		}
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			this.selectedRow = row;
			button.setSelected((value != null && (Boolean) value));
			return button;
		}
		// Radio button bakarra aukeratuta dagoela berifikatu
		public Object getCellEditorValue(DefaultTableModel model) {
			for (int i = 0; i < model.getRowCount(); i++) {
				model.setValueAt(i == selectedRow, i, 2);
			}
			return true;
		}
		public void actionPerformed(ActionEvent e) {
			super.fireEditingStopped();
		}
	}
	
}

