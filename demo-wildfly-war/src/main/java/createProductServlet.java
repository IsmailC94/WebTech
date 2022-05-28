

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Calendar;

import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.resource.cci.ResultSet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class createServlet
 */
@WebServlet(name = "createServlet", urlPatterns = {"/createServlet"})
public class createProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(lookup = "java:jboss/datasources/ingoshop")
	private DataSource ds;
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Product form = new Product();
		form.setId(Long.valueOf(request.getParameter("ProduktNr")));
		form.setProductname(request.getParameter("productname"));
		form.setMenge(Integer.valueOf(request.getParameter("Menge")));
		form.setArtikelGrp(Integer.valueOf(request.getParameter("ArtikelGrp")));
		form.setPreis(Double.valueOf(request.getParameter("preis")));
		
		request.setAttribute("form", form);
		
		final RequestDispatcher dispatcher = request.getRequestDispatcher("uebung5/1_outputdata.jsp");
		dispatcher.forward(request, response);
	}	
	
    public createProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}