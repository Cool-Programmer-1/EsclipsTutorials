package advanceJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String url = "jdbc:mysql://localhost:3306/sam";
			String userName = "root";
			String password = "Shamshad1@"; 
			Connection conn = DriverManager.getConnection(url,userName,password);
			Statement stm = conn.createStatement();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
