package Bl;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dacl.Product;

/**
 * Servlet implementation class selecteditems
 */
@WebServlet("/selecteditems")
public class selecteditems extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selecteditems() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] items = request.getParameterValues("pname");
		double[] priceList = new double[items.length];
		double total=0.0;
		System.out.println("list in selected items");
		for(String i:items) {
			System.out.println(i);
		}
		
		Product p;
		try {
			p = new Product();
            priceList=p.pricelist(items);
            for(double price:priceList) {
            	total+=price;
            }
            System.out.println("total price is "+total);
            request.setAttribute("itemlist", items);
            request.setAttribute("total", total);
            request.setAttribute("pricelist", priceList);
            RequestDispatcher rd = request.getRequestDispatcher("/Products/bill.jsp");
            rd.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
