

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

public class panelPilote extends JPanel {

	IMetier<Pilote> metier = new MetierPilote();
	IMetier<Avion> metiertest = new MetierAvion();
	List<Pilote> pilotes;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public panelPilote() {
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new EmptyBorder(0, 30, 0, 30));

		table = new JTable();
		table.setFont(new Font("Verdana", Font.PLAIN, 14));
		table.getTableHeader().setFont(new Font("Verdana", Font.BOLD, 14));
		scrollPane.setViewportView(table);

		pilotes = metier.getAll();
		PiloteTableModel model = new PiloteTableModel(pilotes);
		table.setModel(model);

		JPanel panel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel.getLayout();
		flowLayout_1.setHgap(20);
		panel.setBorder(new EmptyBorder(10, 0, 20, 0));
		add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Nom : ");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		panel.add(lblNewLabel);

		textField = new JTextField();
		panel.add(textField);
		textField.setFont(new Font("Verdana", Font.BOLD, 14));
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Prenom :");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 14));
		panel.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setText("");
		textField_1.setFont(new Font("Verdana", Font.BOLD, 14));
		panel.add(textField_1);
		textField_1.setColumns(10);

		JButton btnNewButton = new JButton("Ajouter pilote");
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 14));
		ImageIcon image = new ImageIcon(getClass().getResource("/add.png"));
		btnNewButton.setIcon(image);
		panel.add(btnNewButton);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(10, 20, 30, 20));
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		add(panel_1, BorderLayout.SOUTH);

		JButton btnNewButton_2 = new JButton("Imprimer");
		btnNewButton_2.setFont(new Font("Verdana", Font.BOLD, 14));
		ImageIcon image1 = new ImageIcon(getClass().getResource("/print.png"));
		btnNewButton_2.setIcon(image1);
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		panel_1.add(btnNewButton_2);

		JButton btnNewButton_1 = new JButton("Supprimer pilote");
		btnNewButton_1.setFont(new Font("Verdana", Font.BOLD, 14));
		ImageIcon image2 = new ImageIcon(getClass().getResource("/delete.png"));
		btnNewButton_1.setIcon(image2);
		panel_1.add(btnNewButton_1);

		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		panel_2.add(scrollPane);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(0, 0, 0, 30));
		FlowLayout flowLayout_2 = (FlowLayout) panel_3.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		panel_2.add(panel_3, BorderLayout.NORTH);

		textField_2 = new JTextField();
		textField_2.setPreferredSize(new Dimension(30, 20));
		panel_3.add(textField_2);
		textField_2.setColumns(10);

		JButton btnNewButton_3 = new JButton("");
		ImageIcon image3 = new ImageIcon(getClass().getResource("/find.png"));
		btnNewButton_3.setIcon(image3);
		panel_3.add(btnNewButton_3);

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