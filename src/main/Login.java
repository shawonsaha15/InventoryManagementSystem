package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.GetData;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Login extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField username;
	private JTextField password;

	String user;
	String pass;
	String mode;

	GetData getData = new GetData();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("INVENTORY MANAGEMENT SYSTEM");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 434, 39);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(32, 50, 81, 23);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(32, 87, 81, 23);
		contentPane.add(lblNewLabel_2);

		username = new JTextField();
		username.setBounds(122, 51, 246, 22);
		contentPane.add(username);
		username.setColumns(10);

		password = new JTextField();
		password.setBounds(122, 88, 246, 22);
		contentPane.add(password);
		password.setColumns(10);

		JRadioButton admin = new JRadioButton("Admin");
		admin.setBounds(122, 132, 109, 23);
		contentPane.add(admin);

		JRadioButton employee = new JRadioButton("Employee");
		employee.setBounds(122, 173, 109, 23);
		contentPane.add(employee);

		// group button
		ButtonGroup group = new ButtonGroup();
		group.add(admin);
		group.add(employee);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(122, 212, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user = username.getText();
				pass = password.getText();

				if (admin.isSelected()) {
					mode = "admin";
					if (getData.loginCheck(user, pass, mode) == true) {
						JOptionPane.showMessageDialog(frame, "Login Successful");

						AdminMain adminMain = new AdminMain();
						adminMain.setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(frame, "Login failed");
					}
				} else if (employee.isSelected()) {
					mode = "employee";
					if (getData.loginCheck(user, pass, mode) == true) {
						JOptionPane.showMessageDialog(frame, "Login Successful");

						EmployeeMain employeeMain = new EmployeeMain();
						employeeMain.setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(frame, "Login failed");
					}
				} else {
					JOptionPane.showMessageDialog(frame, "Fields are empty");
				}
			}
		});

		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.setBounds(279, 212, 89, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				user = username.getText();
				pass = password.getText();

				if (admin.isSelected()) {
					mode = "admin";
					getData.register(user, pass, mode);
					JOptionPane.showMessageDialog(frame, "Registration Successful");
				} else if (employee.isSelected()) {
					mode = "employee";
					getData.register(user, pass, mode);
					JOptionPane.showMessageDialog(frame, "Registration Successful");
				}
			}
		});
	}
}
