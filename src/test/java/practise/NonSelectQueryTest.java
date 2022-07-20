package practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQueryTest {
	public static void main(String[] args) throws Throwable {
		Connection conn = null;
		int result=0;
		// Register into database
		try {
		Driver driverRef= new Driver();
		
		
	DriverManager.registerDriver(driverRef);
	// Establish connection with the Db
	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
	
	
	// Create statement
	Statement stat = conn.createStatement();
	String query = "insert into students_info (regno, firstname, middlename, lastname) values('20', 'Raj','kumar', 'h')";
	
	// Execute Query
	result = stat.executeUpdate(query);
		
	}
		catch (Exception e) {}
		finally
		{
			if (result==1)
			{
				System.out.println("Successfully inserted data");
			}
			else
			{
				System.err.println("Data not inserted- failed");
			}
			
			    conn.close();
			 	System.out.println("Close ");
		}
	}
}
