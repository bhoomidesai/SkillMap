package com.niit.skillMap.config;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Utility 
{
	private static Connection con=null;	
	private static String userName=null;
	private static String password=null;
	private static String driverClass=null;
	private static String url=null;
	
	public Connection createConnection()
	{
		try {
				
			String propFileName = "D:\\WS\\SkillMap\\src\\db_config.properties";
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
			 //class not found exception
			Class.forName(driverClass);
			System.out.println("Connection Not Established yet "+driverClass);
			con = DriverManager.getConnection("jdbc:h2:~/niitSkillMap", "sa", "");
			
			System.out.println("Connection Established");
			
		}
	 catch (Exception e) 
		{
		 	System.out.println("Exception: " + e);
		 	try {
		 		if(con !=null)
		 			con.close();
		 	} catch (SQLException e1)
		 	{
			// TODO Auto-generated catch block
		 		e1.printStackTrace();
		 	}
		} 
		return con;
	}
	public static void main(String a[])
	{
		System.out.println("begin");
		Utility u = new Utility();
		u.createConnection();
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
