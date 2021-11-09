package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import classes.Stock;

@SuppressWarnings("serial")
public class StockSearch extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	private String name;
	private Double price;
	private Double quantity;
	private String tag;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockSearch frame = new StockSearch();
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
	public StockSearch() {
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

		JLabel lblNewLabel_1 = new JLabel("SEARCH STOCK");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(232, 61, 316, 28);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setBounds(167, 130, 89, 19);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Price");
		lblNewLabel_2_1.setBounds(167, 198, 89, 19);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("Quantity");
		lblNewLabel_2_2.setBounds(167, 245, 89, 19);
		contentPane.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_3 = new JLabel("Product Tag");
		lblNewLabel_2_3.setBounds(167, 297, 89, 19);
		contentPane.add(lblNewLabel_2_3);

		textField = new JTextField();
		textField.setBounds(266, 127, 338, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(266, 197, 338, 20);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(266, 244, 338, 20);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(266, 296, 338, 20);
		contentPane.add(textField_3);

		JButton btnNewButton_1_2 = new JButton("Search");
		btnNewButton_1_2.setBounds(515, 158, 89, 23);
		contentPane.add(btnNewButton_1_2);
		btnNewButton_1_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				name = textField.getText();

				Stock s = new Stock();

				s.searchStock(name);

				textField_1.setText(String.valueOf(s.getPrice()));
				textField_2.setText(String.valueOf(s.getQuantity()));
				textField_3.setText(s.getTag());
			}
		});

		JButton btnNewButton_1 = new JButton("Edit");
		btnNewButton_1.setBounds(266, 390, 89, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				name = textField.getText();
				price = Double.valueOf(textField_1.getText());
				quantity = Double.valueOf(textField_2.getText());
				tag = textField_3.getText();

				Stock s = new Stock();

				s.editStock(name, price, quantity, tag);
			}
		});

		JButton btnNewButton_1_1 = new JButton("Delete");
		btnNewButton_1_1.setBounds(515, 390, 89, 23);
		contentPane.add(btnNewButton_1_1);
		btnNewButton_1_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				name = textField.getText();

				Stock s = new Stock();

				s.deleteStock(name);
			}
		});

	}

}
