package utility;
import java.sql.*;

public class DBConnection {
	public static Connection createConnection()
	{
		Connection conn = null;
		String url = "jdbc:sqlserver://s16988308.onlinehome-server.com:1433;"
		    	      		+ "databaseName=CUNY_DB;integratedSecurity=false;";
		String username = "cst3613";
		String password = "password1";
		try
		{		
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");			
			conn = DriverManager.getConnection(url, username, password);		 
		}
		catch (Exception e)
		{
		 
		}		 
		return conn;
	}
}
