package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db {
	public static Connection getConnection(){
		 String driver = "com.mysql.jdbc.Driver";
//		    String url = "jdbc:mysql://localhost:3306/health_system";
//		    String username = "root";
//		    String password = "8880610";
		   String url = "jdbc:mysql://101.201.235.217:3306/health_system";
		    String username = "root";
		    String password = "mysqlpasswd";
		    Connection conn = null;
		    try {
		        Class.forName(driver); //classLoader,加载对应驱动
		        conn = (Connection) DriverManager.getConnection(url, username, password);
		    } catch (ClassNotFoundException e) {
		        e.printStackTrace();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return conn;
		    
	}
}
