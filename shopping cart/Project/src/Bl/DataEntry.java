package Bl;
import Dacl.User;
import Dacl.UserInfoValidation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DataEntry
 */
@WebServlet("/DataEntry")
public class DataEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataEntry() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;");
		PrintWriter out = response.getWriter();
		User u;
		UserInfoValidation ui;
		ui =(UserInfoValidation)request.getAttribute("Info");
		boolean status;
		try {
			 u = new User();
			u.setName(ui.getUserName());
			u.setEmail(ui.getEmail());
			u.setMobile(ui.getMobile());
			u.setPassword(ui.getPassword());
			System.out.println(u.getName());
			System.out.println(u.getEmail());
			System.out.println(u.getMobile());
			System.out.println(u.getPassword());
			status=u.updateUser(ui);
			if(status) {
				System.out.println("database updated");
				RequestDispatcher rd = request.getRequestDispatcher("/User/Login.jsp");
				rd.forward(request, response);
			}
			else {
				System.out.println("database not updated");
			}
		}catch(SQLException e) {
			System.out.println("DB error in Data entry "+e);
		}
	}

}
