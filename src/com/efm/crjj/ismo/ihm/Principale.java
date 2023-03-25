

package com.efm.crjj.ismo.ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import com.efm.crjj.ismo.dao.DaoEmploye;
import com.efm.crjj.ismo.metier.IMetier;
import com.efm.crjj.ismo.metier.MetierEmploye;
import com.efm.crjj.ismo.model.Employe;

import antlr.collections.List;

import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class Principale extends JFrame  implements MouseListener, ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	IMetier<Employe> emp=new MetierEmploye();
	private static String[] depart = { "RH", "Finance", "Production" };
	private DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(depart);
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_1_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principale frame = new Principale();
					frame.setVisible(true);
					frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principale() {
		setTitle("Gestion des employes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1197, 628);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Nouvel Employe", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBounds(10, 21, 242, 219);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom et prenom :");
		lblNewLabel.setBounds(10, 16, 222, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 41, 222, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Departement");
		lblNewLabel_1.setBounds(10, 72, 222, 14);
		panel.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 91, 222, 22);
		panel.add(comboBox);
		comboBox.setModel(model);
		
		JLabel lblNewLabel_2 = new JLabel("Salaire : ");
		lblNewLabel_2.setBounds(10, 129, 222, 14);
		panel.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 154, 222, 20);
		panel.add(textField_1);
		textField_1.setDocument(new DoubleValidate());
		textField_1.setColumns(10);
		
		Icon icon = new ImageIcon("C:\\Users\\omar hayay\\examenswing\\src\\diskette.png");
		btnNewButton = new JButton(icon);
		btnNewButton.setBounds(10, 185, 222, 23);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Liste des employes", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 251, 616, 322);
		contentPane.add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 27, 576, 241);
		panel_1.add(scrollPane);
		
		
		DefaultTableModel model = new DefaultTableModel();
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Zaid alag", "RH", null},
				{"ZHRI Riyad", "Finance", "34000"},
			},
			new String[] {
				"Nom et Prenom", "Departement", "Salaire"
			}
		));
		Icon icon1 = new ImageIcon("C:\\Users\\omar hayay\\examenswing\\src\\delete.png");
		btnNewButton_1 = new JButton(icon1);
		btnNewButton_1.setBounds(472, 286, 124, 23);
		panel_1.add(btnNewButton_1);
		
		Icon icon2 = new ImageIcon("C:\\Users\\omar hayay\\examenswing\\src\\printing.png");
		btnNewButton_1_1 = new JButton(icon2);
		btnNewButton_1_1.setBounds(327, 286, 135, 23);
		panel_1.add(btnNewButton_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_2.setBounds(262, 35, 364, 147);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre des employes ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblNewLabel_3.setBounds(10, 25, 344, 44);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("0");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_3_1.setBounds(10, 80, 344, 44);
		panel_2.add(lblNewLabel_3_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Nombre Employe par departement", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(646, 124, 537, 387);
		contentPane.add(panel_3);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();

		contentPane.removeAll();
		contentPane.revalidate();
		contentPane.repaint();

		switch (b.getText().toLowerCase()) {
		case "dashboard":
			
			break;
		case "les avions":
			
			break;
		case "les pilotes":
			
			break;
		case "les trajets":
			
			break;
		case "reporting":
			
			break;
		case "les vols":
			
			break;
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
class PiloteTableModel extends AbstractTableModel {

	private String[] cols = { "Code Pilote", "Nom Pilote", "Prenom Pilote" };
	List<Pilote> pilotes;

	public PiloteTableModel(List<Pilote> pilotes) {
		super();
		this.pilotes = pilotes;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return pilotes.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return cols.length;
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return cols[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Pilote p = pilotes.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return String.format("P%04d", p.getId());
		case 1:
			return p.getNom().toUpperCase();
		case 2:
			return p.getPrenom().toUpperCase();
		}
		return null;
	}

}

