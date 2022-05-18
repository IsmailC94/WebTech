

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
public class createServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(lookup = "java:jboss/datasources/ingoshop")
	private DataSource ds;
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Product form = new Product();
		form.setProductname(request.getParameter("productname"));
		form.setQuantity(Integer.valueOf(request.getParameter("quantity")));
		
		
		String dateString = request.getParameter("proddate");
		String[] dateArray = dateString.split("-");
		Calendar cal = Calendar.getInstance();
		int year = Integer.parseInt(dateArray[0]);
		int month = Integer.parseInt(dateArray[1])-1;
		int day = Integer.parseInt(dateArray[2]);
		cal.set(year, month, day);
		form.setProddate(cal.getTime());
		
		String timeString = request.getParameter("prodtime");
		String[] timeArray = timeString.split(":");
		cal.set(year, month, day, Integer.parseInt(timeArray[0]), Integer.parseInt(timeArray[1]));
		form.setProdtime(cal.getTime());
		
		persist(form);
		
		request.setAttribute("form", form);
		
		final RequestDispatcher dispatcher = request.getRequestDispatcher("uebung5/1_outputdata.jsp");
		dispatcher.forward(request, response);
	}	
	
    public createServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	private void persist(Product form) throws ServletException {
		String[] generatedKeys = new String[] {"id"};
		
		try (Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
					"INSERT INTO products (productname,quantity,proddate,prodtime) VALUES (?,?,?,?)", 
					generatedKeys)){

			pstmt.setString(1, form.getProductname());
			pstmt.setInt(2, form.getQuantity());
			pstmt.setDate(3, new java.sql.Date(form.getProddate().getTime()));
			pstmt.setTime(4, new java.sql.Time(form.getProdtime().getTime()));
			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			while (rs.next()) {
				form.setId(rs.getLong(1));
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}