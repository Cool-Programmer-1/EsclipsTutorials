package advanceJava;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class database {
	public static void main(String[] args) throws Exception
	{ 
		String name="shamshad12";
		String email1="shamshad@gmail.com";
		String city1="Narkatiyaganj";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sam","root","Shamshad1@");
		 PreparedStatement ps =con.prepareStatement("insert into student values(?,?,?)");
		 ps.setString(1,name);
		 ps.setString(2, email1);
		 ps.setString(3, city1);
			int i=ps.executeUpdate();
			if(i>0) {
				System.out.println("Connected successfull");
			}
			else {
				System.out.println("fail");
			}
			con.close();
		
	}

}
