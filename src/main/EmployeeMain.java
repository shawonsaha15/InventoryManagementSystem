package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class EmployeeMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeMain frame = new EmployeeMain();
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
	public EmployeeMain() {
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

		JButton btnNewButton = new JButton("Add Stock");
		btnNewButton.setBounds(265, 153, 107, 23);
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

		JButton btnSearchStock = new JButton("Search Stock");
		btnSearchStock.setBounds(265, 209, 107, 23);
		contentPane.add(btnSearchStock);
		btnSearchStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StockSearch stockSearch = new StockSearch();
				stockSearch.setVisible(true);
				dispose();
			}
		});

		JButton btnListStock = new JButton("List Stock");
		btnListStock.setBounds(265, 271, 107, 23);
		contentPane.add(btnListStock);
		btnListStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StockList stockLists = new StockList();
				stockLists.setVisible(true);
				dispose();
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("MAIN MENU");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 61, 635, 34);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.setBounds(265, 383, 107, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});
	}

}
