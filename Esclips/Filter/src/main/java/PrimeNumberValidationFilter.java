import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

@WebFilter("/NumberCheckServlet")
public class PrimeNumberValidationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        String inputParam = req.getParameter("number");

        try {
            int number = Integer.parseInt(inputParam);

            if (number > 0) {
                if (isPrime(number)) {
                    
                    chain.doFilter(request, response);
                } else {
                    
                    request.setAttribute("errorMessage", "It is not a prime number, please enter a prime number.");
                    RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
                    dispatcher.forward(request, response);
                }
            } else {
               
                request.setAttribute("errorMessage", "Please enter a number greater than 0.");
                RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            }
        } catch (NumberFormatException e) {
            
            request.setAttribute("errorMessage", "Enter a number.");
            RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    public void destroy() {}

    
    private boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}