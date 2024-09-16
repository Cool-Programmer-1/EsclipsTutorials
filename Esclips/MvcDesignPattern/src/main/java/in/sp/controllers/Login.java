package in.sp.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.sp.dbcon.DbConnection;
import in.sp.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/loginForm")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Implementation here
    	PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        
        String myemail = request.getParameter("email");
        String mypass = request.getParameter("password");
        
        try
        {
            Connection con = DbConnection.getConnection();
            String select_sql_query = "SELECT * FROM register WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(select_sql_query);
            
            ps.setString(1, myemail);
            ps.setString(2, mypass);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                User user = new User();
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setCity(rs.getString("city"));
                
                HttpSession session = request.getSession();
                session.setAttribute("session_user", user);
                
                RequestDispatcher rd = request.getRequestDispatcher("/profile.jsp");
                rd.forward(request, response);
            }
            else
            {
                out.println("<h3 style='color:red'>Email id and password didn't match</h3>");
                RequestDispatcher rd = request.getRequestDispatcher("/login.html");
                rd.include(request, response);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            out.close();
        }
    	
    }
}
