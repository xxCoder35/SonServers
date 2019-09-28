package Model;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

import Ressources.ReadConfigProperties;

public final class DBconnection {

    private static final BasicDataSource dataSource = new BasicDataSource();

    static {
    	ReadConfigProperties prop=new ReadConfigProperties();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(prop.getpropretyvalue("conf.properties","cheminBDD").concat("?serverTimezone=UTC"));
        dataSource.setUsername(prop.getpropretyvalue("conf.properties","user"));
        dataSource.setPassword(prop.getpropretyvalue("conf.properties","password"));
        System.out.print("Pool Created! ");
    }

    private DBconnection() {
        //
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
       
    }
    public static void CloseConnection() throws SQLException {
        dataSource.close();
       
    }

}