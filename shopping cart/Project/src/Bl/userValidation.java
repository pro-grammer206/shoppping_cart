package Bl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;
import Dacl.UserInfoValidation;;

/**
 * Servlet implementation class userValidation
 */
@WebServlet("/userValidation")
public class userValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userValidation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<Integer,String> error = new HashMap<>(); 
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		error.put(1,"field cannot be empty");
		error.put(2, "the given input data are correct");
		error.put(3, "invalid input format");
		String uname=request.getParameter("fullname");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String pass=request.getParameter("pass");
		String confirm=request.getParameter("confirm_pass");
		UserInfoValidation u = new UserInfoValidation();
		if(u.isEmailValid(email)+u.fieldsValid(uname, mobile)+u.passwordValid(pass, confirm)==6) {
			u.setUserName(uname);
			u.setEmail(email);
			u.setMobile(mobile);
			u.setPassword(pass);
			request.setAttribute("Info", u);
			RequestDispatcher rd = request.getRequestDispatcher("/DataEntry");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("fields", error.get(u.fieldsValid(uname, mobile)));
			request.setAttribute("email", error.get(u.isEmailValid(email)));
			request.setAttribute("mismatch", error.get(u.passwordValid(pass, confirm)));
			System.out.println(error.get(u.fieldsValid(uname, mobile)));
			System.out.println(error.get(u.isEmailValid(email)));
			System.out.println(error.get(u.passwordValid(pass, confirm)));
			RequestDispatcher rd = request.getRequestDispatcher("/User/Register.jsp");
			request.setAttribute("error", "The details entered were incorrect please try again");
			rd.include(request,response);
			out.println("<font-color='red'><b>You have entered invalid data</b></font>");
		}
		
	}

}
