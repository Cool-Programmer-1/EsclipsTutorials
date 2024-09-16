package appk;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/sub")
public class SubServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int op1 = (Integer) request.getAttribute("n1");
        int op2 = (Integer) request.getAttribute("n2");
        int result = op1 - op2;
        request.setAttribute("operation", "Subtraction");
        request.setAttribute("result", result);
        RequestDispatcher rd = request.getRequestDispatcher("/resp");
        rd.forward(request, response);
    }
}
