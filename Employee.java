package application;

public class Employee {
	
	public Employee(int no, String name, String gender, String hireDate) {
		
		mNo = no;
		
		mName = name;
		
		mGender = gender;
		
		mHireDate = hireDate;
		
		
	}
	
	private int mNo;
	
	private String mName;
	
	private String mGender;
	
	private String mHireDate;
	
	public int no () {
		
		return mNo;
		
	}
	
	public String name() {
		
		return mName;
		
	}
	
	public String gender() {
		
		return mGender;
		
	}
	
	public String hireDate() {
		
		return mHireDate;
		
	}
	
}
