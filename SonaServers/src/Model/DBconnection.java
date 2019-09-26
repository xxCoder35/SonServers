package Model;


import java.sql.*;



public class DBconnection {
	
	
	
public static boolean BDDconnection(String url,String user,String passwd)
{
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn= DriverManager.getConnection(url.concat("?serverTimezone=UTC"), user, passwd);
		conn.close();
		return true;
	} catch (SQLException | ClassNotFoundException e) {
		e.printStackTrace();
		return false;
	}

	
}
}
