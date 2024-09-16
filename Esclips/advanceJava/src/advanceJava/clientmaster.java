package advanceJava;

import java.sql.Connection;
import java.sql.DriverManager;

public class clientmaster {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String url = "jdbc:mysql://localhost:3306/sam";
			String userName = "root";
			String password = "Shamshad1@"; 
			Connection conn = DriverManager.getConnection(url,userName,password);	
			System.out.println("Connected Successfully");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
