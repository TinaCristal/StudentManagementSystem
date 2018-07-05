package common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	private  Connection conn;
	
	public  void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConn() {
		if(conn!=null){
			System.out.println("�������ݿ�����--");
		}
		return conn;
	}
	
	public DBConnection(){
		Properties prop = new Properties();
		try {
			//���ⲿ�ļ���ȡ���ݿ����Ӳ���
			prop.load(new FileInputStream("config/login.properties"));
	
			String driver=prop.getProperty("driver");
			String url=prop.getProperty("url");
			String username=prop.getProperty("username");
			String password=prop.getProperty("password");
			
			//������������ȡ���ݿ�����
			Class.forName(driver);
			conn=DriverManager.getConnection(url, username, password);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
