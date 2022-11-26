package application;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
	
	// Configurations
	private static String sDB_URL = "jdbc:mysql://localhost:3306/employees";
	
    private static String sUSER_NAME = "root";
    
    private static String sPASSWORD = "123456";
    
    public Connection getConnection() {
    	
    	return getConnection(sDB_URL, sUSER_NAME, sPASSWORD);
    	
    }
    
    public Connection getConnection(String dbURL, String userName, 
            String password) {
    	
        Connection conn = null;
        
        try {
        	
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conn = DriverManager.getConnection(dbURL, userName, password);
            
            System.out.println("connect successfully!");
            
        } catch (Exception ex) {
        	
            System.out.println("connect failure!");
            
            ex.printStackTrace();
            
        }
        
        return conn;
        
    }
    
    
    

}
