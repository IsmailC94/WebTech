package servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

/**
 * Servlet implementation class getPLZ
 */
@WebServlet("/getPLZ")
public class getPLZ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String plz;

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}
}
