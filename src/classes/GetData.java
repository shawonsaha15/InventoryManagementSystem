package classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GetData {

	private JFrame frame;

	File admin = new File("admin.txt");
	File stock = new File("stock.txt");
	File employee = new File("employee.txt");

	// LOGIN
	public ArrayList<String> fileReadAdmin() {
		ArrayList<String> data = new ArrayList<String>();
		try {
			FileReader fr = new FileReader(admin);
			BufferedReader br = new BufferedReader(fr);
			while (br.ready()) {
				data.add(br.readLine());
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public boolean loginCheck(String user, String pass, String mode) {
		ArrayList<String> data = fileReadAdmin();
		Boolean result = false;

		for (int i = 0; i < data.size(); i++) {

			String[] data_column = data.get(i).split(",");

			if (data_column[0].equals(user) && data_column[1].equals(pass) && data_column[2].equals(mode)) {

				result = true;
				break;
			} else {
				result = false;
			}
		}
		return result;
	}

	public void register(String user, String pass, String mode) {
		try {
			ArrayList<String> data = fileReadAdmin();
			FileWriter fw = new FileWriter(admin, true);

			if (data.size() < 0) {
				fw.write(System.lineSeparator() + user + "," + pass + "," + mode);
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// STOCK
	public void fileWriteStock(ArrayList<Stock> fullstock) {
		try {
			ArrayList<String> data = fileReadStock();
			FileWriter fw = new FileWriter(stock, true);

			if (stock.exists() == false) {
				stock.createNewFile();
			}

			for (int i = 0; i < fullstock.size(); i++) {
				if (data.size() > 0) {
					fw.write(System.lineSeparator() + fullstock.get(i).name + "," + fullstock.get(i).price + ","
							+ fullstock.get(i).quantity + "," + fullstock.get(i).tag);
				} else {
					fw.write(fullstock.get(i).name + "," + fullstock.get(i).price + "," + fullstock.get(i).quantity
							+ "," + fullstock.get(i).tag);
				}
			}

			fw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> fileReadStock() {
		ArrayList<String> data = new ArrayList<String>();
		try {
			FileReader fr = new FileReader(stock);
			BufferedReader br = new BufferedReader(fr);
			while (br.ready()) {
				data.add(br.readLine());
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public ArrayList<Stock> fileStockCheck(String name) {
		ArrayList<String> data = fileReadStock();
		ArrayList<Stock> fullstock = new ArrayList<Stock>();

		try {
			for (int i = 0; i < data.size(); i++) {

				String[] data_column = data.get(i).split(",");

				if (data_column[0].equals(name)) {
					fullstock.add(0, new Stock(data_column[0], Double.valueOf(data_column[1]),
							Double.valueOf(data_column[2]), data_column[3]));
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return fullstock;
	}

	public void fileStockEdit(String name, ArrayList<Stock> fullstock) {
		ArrayList<String> data = fileReadStock();

		try {
			for (int i = 0; i < data.size(); i++) {

				String[] data_column = data.get(i).split(",");

				if (data_column[0].equals(name)) {
					data.remove(i);
					break;
				}
			}

			FileWriter fw = new FileWriter(stock);

			for (int i = 0; i < fullstock.size(); i++) {
				fw.write(fullstock.get(i).name + "," + fullstock.get(i).price + "," + fullstock.get(i).quantity + ","
						+ fullstock.get(i).tag);
			}

			if (data.size() != 0) {
				for (int j = 0; j < data.size(); j++) {
					fw.write(System.lineSeparator() + data.get(j));
				}
			}

			JOptionPane.showMessageDialog(frame, "Stock edited successfully!");
			fw.close();
		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}

	public void fileStockDelete(String name) {
		ArrayList<String> data = fileReadStock();

		try {
			for (int i = 0; i < data.size(); i++) {

				String[] data_column = data.get(i).split(",");

				if (data_column[0].equals(name)) {
					data.remove(i);
					JOptionPane.showMessageDialog(frame, "Stock removed successfully!");
					break;
				}
			}

			FileWriter fw = new FileWriter(stock);

			if (stock.exists() == false) {
				stock.createNewFile();
			}

			for (int i = 0; i < data.size(); i++) {
				fw.write(data.get(i));
			}

			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Stock> fileStockList() {
		ArrayList<String> data = fileReadStock();
		ArrayList<Stock> fullstock = new ArrayList<Stock>();

		try {
			for (int i = 0; i < data.size(); i++) {

				String[] data_column = data.get(i).split(",");

				fullstock.add(new Stock(data_column[0], Double.valueOf(data_column[1]), Double.valueOf(data_column[2]),
						data_column[3]));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fullstock;
	}

	// EMPLOYEE
	public void fileWriteEmployee(ArrayList<Employee> fullemployee) {
		try {
			ArrayList<String> data = fileReadStock();
			FileWriter fw = new FileWriter(employee, true);

			if (employee.exists() == false) {
				employee.createNewFile();
			}

			for (int i = 0; i < fullemployee.size(); i++) {
				if (data.size() > 0) {
					fw.write(System.lineSeparator() + fullemployee.get(i).name + "," + fullemployee.get(i).phone + ","
							+ fullemployee.get(i).designation + "," + fullemployee.get(i).salary);
				} else {
					fw.write(fullemployee.get(i).name + "," + fullemployee.get(i).phone + ","
							+ fullemployee.get(i).designation + "," + fullemployee.get(i).salary);
				}
			}

			fw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> fileReadEmployee() {
		ArrayList<String> data = new ArrayList<String>();
		try {
			FileReader fr = new FileReader(employee);
			BufferedReader br = new BufferedReader(fr);
			while (br.ready()) {
				data.add(br.readLine());
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public ArrayList<Employee> fileEmployeeCheck(String name) {
		ArrayList<String> data = fileReadEmployee();
		ArrayList<Employee> fullemployee = new ArrayList<Employee>();

		try {
			for (int i = 0; i < data.size(); i++) {

				String[] data_column = data.get(i).split(",");

				if (data_column[0].equals(name)) {
					fullemployee.add(0, new Employee(data_column[0], Integer.valueOf(data_column[1]), data_column[2],
							Double.valueOf(data_column[3])));
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fullemployee;
	}

	public void fileEmployeeEdit(String name, ArrayList<Employee> fullemployee) {
		ArrayList<String> data = fileReadEmployee();

		try {
			for (int i = 0; i < data.size(); i++) {

				String[] data_column = data.get(i).split(",");

				if (data_column[0].equals(name)) {
					data.remove(i);
					break;
				}
			}

			FileWriter fw = new FileWriter(employee);

			for (int i = 0; i < fullemployee.size(); i++) {
				fw.write(fullemployee.get(i).name + "," + fullemployee.get(i).phone + ","
						+ fullemployee.get(i).designation + "," + fullemployee.get(i).salary);
			}

			if (data.size() != 0) {
				for (int j = 0; j < data.size(); j++) {
					fw.write(System.lineSeparator() + data.get(j));
				}
			}
			JOptionPane.showMessageDialog(frame, "Employee edited successfully!");
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void fileEmployeeDelete(String name) {
		ArrayList<String> data = fileReadEmployee();

		try {
			for (int i = 0; i < data.size(); i++) {

				String[] data_column = data.get(i).split(",");

				if (data_column[0].equals(name)) {
					data.remove(i);
					JOptionPane.showMessageDialog(frame, "Employee removed successfully!");
					break;
				}
			}

			FileWriter fw = new FileWriter(employee);

			if (employee.exists() == false) {
				employee.createNewFile();
			}

			for (int i = 0; i < data.size(); i++) {
				fw.write(data.get(i));
			}

			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Employee> fileEmployeeList() {
		ArrayList<String> data = fileReadEmployee();
		ArrayList<Employee> fullemployee = new ArrayList<Employee>();

		try {
			for (int i = 0; i < data.size(); i++) {

				String[] data_column = data.get(i).split(",");

				fullemployee.add(new Employee(data_column[0], Integer.valueOf(data_column[1]), data_column[2],
						Double.valueOf(data_column[3])));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fullemployee;
	}
}
