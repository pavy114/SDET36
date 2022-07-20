package practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SelectQueryTest {
	

	public static void main(String[] args) throws Throwable {
		
		Connection conn=null;
		try
		
		{
			Driver driverref= new Driver();
		//Register to the Database
		 DriverManager.registerDriver(driverref);
		 //connect to the database
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		 System.out.println("connection is made");
		 //create query statement
		 	Statement stat = conn.createStatement();
		 	String query = "select * from students_info";
		 	// Execute the Query
		 	ResultSet result = stat.executeQuery(query);
		 	//or stat.executeQuery("select * from students_info");
		 	while(result.next())
		 	{
		 		System.out.println(result.getInt(1));
		 	}
		}
		catch (Exception e) {
			
		}
		finally {
		
		 	
		 	
		 	 conn.close();
		 	System.out.println("Close ");
		}
		}

	}


