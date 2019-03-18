package Bl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dacl.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("uname");
		String pass = request.getParameter("pwd");
		User u;
		boolean valid;
		try {
			u = new User();
			valid = u.validation(name, pass);
			if(valid) {
				RequestDispatcher rd = request.getRequestDispatcher("/Products/Home.jsp");
				HttpSession ss = request.getSession();
				ss.setAttribute("name", name);
				rd.forward(request, response);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("/User/Login.jsp");
				rd.include(request, response);
				out.println("<p align='center'>invalid username and password</p>");
			}
			
		}catch(SQLException e) {
			System.out.println("DB error in Login servlet "+e);
		}
	}

}
