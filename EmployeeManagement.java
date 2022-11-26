package application;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManagement {
	
	private DBConnector mDbConnector;
	
	private EmployeeDatabase mEmployeeDatabase;
	
	private List<Employee> mEmployees;
	
	public EmployeeManagement() {
		
		mDbConnector = new DBConnector();
		
		mEmployeeDatabase = new EmployeeDatabase(mDbConnector);
		
		mEmployees = new ArrayList<Employee>();
		
	}
	
	public void collectEmployees (int empNum, String gender) {
		
		mEmployees.clear();
		
		mEmployeeDatabase.selectEmployees(empNum, gender, mEmployees);
		
	}
	
	public List<Employee> employees(){
		
		return mEmployees;
		
	}
	
	public String toString () {
		
		String out = "";
		
		if (!mEmployees.isEmpty()) {
			
			out += "   No    |   Name   |   Gender   |   Hire Date \n";
			
		}
		
		for (Employee emp : mEmployees) {
			
			out += emp.no() + "    " + emp.name() + "   " + emp.gender() + "   " + emp.hireDate() + "\n";
			
		}
		
		return out;
		
	}

}
