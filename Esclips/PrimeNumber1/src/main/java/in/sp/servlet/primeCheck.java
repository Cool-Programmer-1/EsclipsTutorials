package in.sp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/primeCheck")
public class primeCheck extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public primeCheck() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int number = Integer.parseInt(request.getParameter("number"));
        
        out.println("<html><body>");
        out.println("<h2>Number received: " + number + "</h2>");
        out.println("</body></html>");
    }
}
