package vista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import master.Modelo;
import vista.vZinema.RadioButtonEditor;
import vista.vZinema.RadioButtonRenderer;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class vSaioa extends JFrame {
	private DefaultTableModel model;

	/**
	 * Description: Admin menuaren konstruktorea
	 *
	 * @param Modelo
	 */
	public vSaioa(Modelo Modelo) {

		// Hasierako leihoa konfiguratu
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Saioak");
		setSize(500, 300);
		// taularen modeloa sortu
		model = new DefaultTableModel();
		model.addColumn("Ordua");
		model.addColumn("Pelikula");
		model.addColumn("Prezioa");
		// Taula berriaren modeloa sortu
		JTable table = new JTable(model);
		// Agregar un ActionListener al radio button para gestionar la selección única
		table.getColumnModel().getColumn(3).setCellEditor(new RadioButtonEditor());
		table.getColumnModel().getColumn(3).setCellRenderer(new RadioButtonRenderer());
		// Taula JScrollPane barruan ezarri
		JScrollPane scrollPane = new JScrollPane(table);
		Modelo.ezarrisaioak(model);
		JButton atzeraButton = new JButton("Atzera");
		atzeraButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modelo.setAfilma(0);
				dispose();
				vLogin vLogin = new vLogin(Modelo);
				vLogin.setVisible(true);
			}
		});
		// Gorde botoia sortu
		JButton closeButton = new JButton("Jarraitu");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowCount = model.getRowCount();
				// Fila bat baino gehiago dagoela konfirmatu
				if (rowCount >= 0) {
					int selectedRow = table.getSelectedRow();
					if (selectedRow >= 0) {
						model.removeRow(selectedRow);
						JOptionPane.showMessageDialog(vSaioa.this,
								table.getModel().getValueAt(selectedRow, 1).toString(), "Aukera",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(vSaioa.this, "Aukeratu saio bat", "Error", JOptionPane.ERROR_MESSAGE);
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
	/**
	 * Create the frame.
	 */
	public vSaioa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
	}
}
