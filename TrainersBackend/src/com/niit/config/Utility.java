package com.niit.config;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Utility 
{
	Connection con=null;	
	String userName=null;
	String password=null;
	String driverClass=null;
	String url=null;
	
	public Connection createConnection() throws IOException
	{
		try {
				
			String propFileName = "db_config.properties";
			File file = new File(propFileName);
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			fileInput.close();
			userName = properties.getProperty("user");
			password = "";
			driverClass = properties.getProperty("driver");
			url = properties.getProperty("url");
			System.out.println(userName+" "+driverClass+"  "+url);
			Class.forName(driverClass); //class not found exception
			con = DriverManager.getConnection(url, userName, password);
			System.out.println("Connection Established");
			
		}
	 catch (Exception e) {
		System.out.println("Exception: " + e);
	} 
		return con;
	}
	public static void main(String a[]) throws IOException, SQLException
	{
		
		Utility u = new Utility();
		Connection con = u.createConnection();
		con.close();
	}
	

}
