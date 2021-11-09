package classes;

import java.util.ArrayList;

import interfaces.employeeOperators;

public class Employee implements employeeOperators {
	protected String name;
	protected int phone;
	protected String designation;
	protected double salary;

	public Employee() {

	}

	Employee(String name, int phone, String designation, double salary) {
		this.name = name;
		this.phone = phone;
		this.designation = designation;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public void addEmployee(String name, int phone, String designation, double salary) {
		// TODO Auto-generated method stub
		this.name = name;
		this.phone = phone;
		this.designation = designation;
		this.salary = salary;

		ArrayList<Employee> fullemployee = new ArrayList<Employee>();
		fullemployee.add(new Employee(name, phone, designation, salary));

		GetData gd = new GetData();
		gd.fileWriteEmployee(fullemployee);
	}

	@Override
	public void searchEmployee(String name) {
		// TODO Auto-generated method stub
		this.name = name;

		GetData gd = new GetData();
		ArrayList<Employee> fullemployee = gd.fileEmployeeCheck(name);

		this.phone = fullemployee.get(0).phone;
		this.designation = fullemployee.get(0).designation;
		this.salary = fullemployee.get(0).salary;
	}

	@Override
	public void editEmployee(String name, int phone, String designation, double salary) {
		// TODO Auto-generated method stub
		this.name = name;
		this.phone = phone;
		this.designation = designation;
		this.salary = salary;
		
		ArrayList<Employee> fullemployee = new ArrayList<Employee>();
		fullemployee.add(new Employee(name, phone, designation, salary));
		
		GetData gd = new GetData();
		
		gd.fileEmployeeEdit(name, fullemployee);
	}

	@Override
	public void deleteEmployee(String name) {
		// TODO Auto-generated method stub
		this.name = name;

		GetData gd = new GetData();

		gd.fileEmployeeDelete(name);
	}

	@Override
	public ArrayList<Employee> listEmployee() {
		// TODO Auto-generated method stub
		GetData gd = new GetData();

		ArrayList<Employee> list = gd.fileEmployeeList();

		return list;
	}

}
