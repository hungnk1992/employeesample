package application;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDatabase {
	
	DBConnector mConnector;
	
	public EmployeeDatabase(DBConnector connector) {
		
		mConnector = connector;
		
	}
	
	public void selectEmployees(int empNum, String gender, List<Employee> employees) {
		
		CallableStatement stmt = null;
		
		try {
			
			stmt = mConnector.getConnection().prepareCall("{call SelectEmployees(?, ?)}");
			
			stmt.setInt(1, empNum);
			
			stmt.setString(2, gender);
			
			stmt.execute();
			
			ResultSet resultSet = stmt.getResultSet();
			
			int tempNo = 0;
			
			String tempName = null;
			
			String tempGender = null;
			
			String tempHireDate = null;

	        while (resultSet.next()) {
	        	
	        	tempNo = resultSet.getInt("emp_no");
	        	
	        	tempName = resultSet.getString("first_name");
	        	
	        	tempGender = resultSet.getString("gender");
	        	
	        	tempHireDate = resultSet.getString("hire_date");
	        	
	        	System.out.println (" == " + tempNo);
	        	
	        	employees.add(new Employee(tempNo, tempName, tempGender, tempHireDate));
	        	
	        }
	        
	        System.out.println(" == Num emp: " + employees.size());
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		finally {
			
			try {
				
				stmt.close();
								
			} catch (SQLException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
	}
}
