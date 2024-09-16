import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/NumberCheckServlet")
public class NumberCheckServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int number = Integer.parseInt(request.getParameter("number"));
        
        // Display success message with a "Return" button
        response.getWriter().write(
            "<html><body>" +
            "<h2>Success! The number you entered is a prime number: " + number + "</h2>" +
            "<form action='index.jsp' method='get'>" +
            "<input type='submit' value='Return'>" +
            "</form>" +
            "</body></html>"
        );
    }
}