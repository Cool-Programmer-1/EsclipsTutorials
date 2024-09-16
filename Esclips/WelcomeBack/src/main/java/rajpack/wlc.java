package rajpack;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/wlc")
public class wlc extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public wlc() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        String s = request.getParameter("t1");
        pw.println("<h1>Hello, " + s + "</h1>");
        pw.println("<form action='logout' method='get'>");
        pw.println("<input type='submit' value='Logout'>");
        pw.println("</form>");
        pw.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
