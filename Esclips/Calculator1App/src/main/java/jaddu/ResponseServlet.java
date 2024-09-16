package jaddu;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseServlet
 */
@WebServlet("/resp")
public class ResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer result=(Integer)request.getAttribute("result");
		RequestDispatcher rd=request.getRequestDispatcher("/Home.html");
		if(result==null){
		rd.forward(request,response);
		return;
	     }
		
		
		try{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String op=(String)request.getAttribute("operation");
		out.println(op+"Result: <b>"+result.intValue()+"<b>,<br/>");
		rd.include(request,response);
		}
		catch(Exception e){};
		
		
	}

}
