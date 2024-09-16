package in.sp.servlet;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/primeCheck")
public class F1 extends HttpFilter implements Filter {
    private static final long serialVersionUID = 1L;

    public F1() {
        super();
    }

    public void destroy() {
        // Cleanup resources if needed
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        int number = Integer.parseInt(request.getParameter("number"));
        
        out.print("Filter is invoked before processing the request.<br>");
        
        // Check if the number is prime
        if (isPrime(number)) {
            out.print(number + " is a prime number.<br>");
        } else {
            out.print(number + " is not a prime number.<br>");
        }

        // Pass the request along the filter chain
        chain.doFilter(request, response);

        out.print("Filter is invoked after processing the request.<br>");
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public void init(FilterConfig fConfig) throws ServletException {
        // Initialization if needed
    }
}
