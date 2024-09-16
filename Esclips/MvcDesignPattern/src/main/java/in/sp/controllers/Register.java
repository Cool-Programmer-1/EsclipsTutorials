package in.sp.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import in.sp.dbcon.DbConnection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/regForm")
public class Register extends HttpServlet 
{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        String myname = request.getParameter("name1");
        String myemail = request.getParameter("email11");
        String mypass = request.getParameter("pass1");
        String mycity = request.getParameter("city1");

        try
        {
            Connection con = DbConnection.getConnection();
            String insert_sql_query = "INSERT INTO register VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(insert_sql_query);
            ps.setString(1, myname);
            ps.setString(2, myemail);
            ps.setString(3, mypass);
            ps.setString(4, mycity);

            int count = ps.executeUpdate();
            if(count > 0)
            {
                out.println("<h3 style='color:green'>Registered Successfully</h3>");
                RequestDispatcher rd = request.getRequestDispatcher("/login.html");
                rd.include(request, response);
            }
            else
            {
                out.println("<h3 style='color:red'>User not registered due to some error</h3>");
                RequestDispatcher rd = request.getRequestDispatcher("/login.html");
                rd.include(request, response);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
