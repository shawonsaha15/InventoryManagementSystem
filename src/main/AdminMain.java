package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class AdminMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMain frame = new AdminMain();
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
	public AdminMain() {
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
		btnNewButton.setBounds(113, 174, 107, 23);
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
		btnSearchStock.setBounds(113, 236, 107, 23);
		contentPane.add(btnSearchStock);
		btnSearchStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StockSearch stockSearch = new StockSearch();
				stockSearch.setVisible(true);
				dispose();
			}
		});

		JButton btnListStock = new JButton("List Stock");
		btnListStock.setBounds(113, 303, 107, 23);
		contentPane.add(btnListStock);
		btnListStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StockList stockLists = new StockList();
				stockLists.setVisible(true);
				dispose();
			}
		});

		JButton btnSearchEmployee = new JButton("Search Employee");
		btnSearchEmployee.setBounds(420, 236, 137, 23);
		contentPane.add(btnSearchEmployee);
		btnSearchEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeSearch employeeSearch = new EmployeeSearch();
				employeeSearch.setVisible(true);
				dispose();
			}
		});

		JButton btnAddEmployee = new JButton("Add Employee");
		btnAddEmployee.setBounds(420, 174, 137, 23);
		contentPane.add(btnAddEmployee);
		btnAddEmployee.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				EmployeeAdd employeeAdd = new EmployeeAdd();
				employeeAdd.setVisible(true);
				dispose();
			}
		});

		JButton btnListEmployee = new JButton("List Employee");
		btnListEmployee.setBounds(420, 303, 137, 23);
		contentPane.add(btnListEmployee);
		btnListEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeList employeeLists = new EmployeeList();
				employeeLists.setVisible(true);
				dispose();
			}
		});

		JLabel lblNewLabel_1 = new JLabel("MAIN MENU");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 61, 635, 34);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.setBounds(273, 383, 89, 23);
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
