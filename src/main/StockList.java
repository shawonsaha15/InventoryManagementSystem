package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import classes.Stock;

import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class StockList extends JFrame {

	private JPanel contentPane;
	@SuppressWarnings("unused")
	private JTable table;
	private JTable table_1;

	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockList frame = new StockList();
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
	public StockList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("INVENTORY MANAGEMENT SYSTEM");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 635, 50);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(10, 61, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StockAdd stockAdd = new StockAdd();
				stockAdd.setVisible(true);
				dispose();
			}
		});

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StockSearch stockSearch = new StockSearch();
				stockSearch.setVisible(true);
				dispose();
			}
		});
		btnSearch.setBounds(10, 128, 89, 23);
		contentPane.add(btnSearch);

		JButton btnList = new JButton("List");
		btnList.setBounds(10, 203, 89, 23);
		contentPane.add(btnList);
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StockList stockLists = new StockList();
				stockLists.setVisible(true);
				dispose();
			}
		});

		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(10, 390, 89, 23);
		contentPane.add(btnLogout);
		btnLogout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});

		JLabel lblNewLabel_1 = new JLabel("LIST STOCK");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(232, 61, 316, 28);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton_1 = new JButton("List Table");
		btnNewButton_1.setBounds(343, 100, 89, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(131, 140, 481, 292);
				contentPane.add(scrollPane);

				table_1 = new JTable();

				table_1.setBackground(new Color(176, 196, 222));
				model = new DefaultTableModel();

				Object[] column = { "Name", "Price", "Quantity", "Product Tag" };

				Stock s = new Stock();
				ArrayList<Stock> list = s.listStock();

				model.setColumnIdentifiers(column);

				for (int i = 0; i < list.size(); i++) {
					Object[] row = new Object[4];
					row[0] = list.get(i).getName();
					row[1] = list.get(i).getPrice();
					row[2] = list.get(i).getQuantity();
					row[3] = list.get(i).getTag();
					model.addRow(row);
				}
				
				table_1.setModel(model);
				scrollPane.setViewportView(table_1);
			}
		});

	}
}
