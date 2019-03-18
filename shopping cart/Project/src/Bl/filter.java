package Bl;

import Dacl.Product;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class filter
 */
@WebServlet("/filter")
public class filter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public filter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cat = request.getParameter("category");
		Product p;
		ArrayList<Product> prod;
		try {
			p=new Product();
			prod = new ArrayList<>(p.select(cat));
			System.out.println("List in filter");
			for(Product pr:prod) {
				System.out.println(pr.getName());
			}
			request.setAttribute("category", cat);
			request.setAttribute("ProductList", prod);
			RequestDispatcher rd = request.getRequestDispatcher("/Products/Browse.jsp");
			rd.forward(request, response);
			
			
			
		}catch(SQLException e) {
			System.out.println("DB error in filter "+e);
		}
		
	}

}
