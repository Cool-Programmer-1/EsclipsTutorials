package nd.sp.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class RegisterDao {
    public String registerUser(RegisterBean registerBean) {
        String fullName = registerBean.getFullName();
        String email = registerBean.getEmail();
        String userName = registerBean.getUserName();
        String password = registerBean.getPassword();

        Connection con = null;
        PreparedStatement preparedStatement = null;
        try {
            con = DBCconnection.createConnection();
            String query = "INSERT INTO users (fullName, Email, userName, password) VALUES (?, ?, ?, ?)"; // Insert user details into the table 'users'
            preparedStatement = con.prepareStatement(query); // Using prepared statements to insert data
            preparedStatement.setString(1, fullName);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, userName);
            preparedStatement.setString(4, password);

            int i = preparedStatement.executeUpdate();

            if (i != 0) { // Ensure data has been inserted into the database
                return "SUCCESS";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return "Oops.. Something went wrong there..!"; // On failure, send a message from here.
    }
}
