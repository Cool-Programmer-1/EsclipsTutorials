package appk;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/entry")
public class ValidationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int n1 = Integer.parseInt(request.getParameter("op1"));
            int n2 = Integer.parseInt(request.getParameter("op2"));
            request.setAttribute("n1", n1);
            request.setAttribute("n2", n2);
        } catch (Exception e) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("Value should be a number");
            RequestDispatcher rd = request.getRequestDispatcher("Calculator.html");
            rd.include(request, response);
            return;
        }

        String action = request.getParameter("action");
        RequestDispatcher rd = null;
        if ("Add".equals(action))
            rd = request.getRequestDispatcher("/add");
        else if ("Subtract".equals(action))
            rd = request.getRequestDispatcher("/sub");
        rd.forward(request, response);
    }
}
