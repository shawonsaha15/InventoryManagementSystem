package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import classes.Employee;

@SuppressWarnings("serial")
public class EmployeeAdd extends JFrame {
	
	private JFrame frame;

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	private String name;
	private int phone;
	private String designation;
	private double salary;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeAdd frame = new EmployeeAdd();
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
	public EmployeeAdd() {
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
				EmployeeAdd employeeAdd = new EmployeeAdd();
				employeeAdd.setVisible(true);
				dispose();
			}
		});

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeSearch employeeSearch = new EmployeeSearch();
				employeeSearch.setVisible(true);
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
				EmployeeList employeeLists = new EmployeeList();
				employeeLists.setVisible(true);
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

		JLabel lblNewLabel_1 = new JLabel("ADD EMPLOYEE");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(232, 61, 316, 28);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setBounds(167, 130, 89, 19);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Phone");
		lblNewLabel_2_1.setBounds(167, 175, 89, 19);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("Designation");
		lblNewLabel_2_2.setBounds(167, 222, 89, 19);
		contentPane.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_3 = new JLabel("Salary");
		lblNewLabel_2_3.setBounds(167, 274, 89, 19);
		contentPane.add(lblNewLabel_2_3);

		textField = new JTextField();
		textField.setBounds(266, 127, 338, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(266, 174, 338, 20);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(266, 221, 338, 20);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(266, 273, 338, 20);
		contentPane.add(textField_3);

		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.setBounds(266, 390, 89, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				name = textField.getText();
				phone = Integer.valueOf(textField_1.getText());
				designation = textField_2.getText();
				salary = Double.valueOf(textField_3.getText());;

				Employee emp = new Employee();

				emp.addEmployee(name, phone, designation, salary);

				JOptionPane.showMessageDialog(frame, "Employee Added!");
			}
		});

	}

}
