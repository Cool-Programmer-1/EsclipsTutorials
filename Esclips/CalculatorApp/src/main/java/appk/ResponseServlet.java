package appk;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/resp")
public class ResponseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer result = (Integer) request.getAttribute("result");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String operation = (String) request.getAttribute("operation");
        out.println(operation + " Result: <b>" + result + "</b><br/>");
        RequestDispatcher rd = request.getRequestDispatcher("Calculator.html");
        rd.include(request, response);
    }
}
