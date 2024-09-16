package calculatorApp;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class ValidationServlet
 */
@WebServlet("/entry")
public class ValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		request.setAttribute("n1",new Integer(request.getParameter("op1")));
		request.setAttribute("n2",new Integer(request.getParameter("op2")));
		RequestDispatcher rd=request.getRequestDispatcher("/Home.html");
		}
		catch(Exception e){
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("value should be number");
			RequestDispatcher rd=request.getRequestDispatcher("/Home.html");
			rd.include(request, response);
			return;
		}
				
		String action=request.getParameter("action");
		 RequestDispatcher rd=null;
		if(action.equals("Add"))
			rd=request.getRequestDispatcher("/add");
		else
			rd=request.getRequestDispatcher("/sub");
		rd.forward(request,response);
	}

}
