package interfaces;

import java.util.ArrayList;

import classes.Employee;

public interface employeeOperators {
	public abstract void addEmployee(String name, int phone, String designation, double salary);
	
	public void searchEmployee(String name);
	
	public void editEmployee(String name, int phone, String designation, double salary);
	
	public void deleteEmployee(String name);
	
	public ArrayList<Employee> listEmployee();
}
