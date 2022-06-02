package edu.thi.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionHandlingServlet
 */
@WebServlet("/SessionHandlingServlet")
public class SessionHandlingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// HTTP-Header setzen
		response.setStatus(HttpServletResponse.SC_OK);	// nicht zwingend erforderlich; ist der default-Wert
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		final PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		String vorname = null;
		String nachname = null;
		HttpSession session = null;
		
		switch (action) {
			case "writeToSession":
				vorname = request.getParameter("vorname");
				nachname = request.getParameter("nachname");
				session = request.getSession();
				session.setAttribute("vorname", vorname);
				session.setAttribute("nachname", nachname);
				
				out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.println("<body>");
				out.println("<h3>Schreiben von Daten in eine Sitzung</h3>");
				out.println("Sessiondaten wurden erfolgreich geschrieben!");
				out.println("<form method='post' action='SessionHandlingServlet'>");
				out.println("<div>");
				out.println("<button type='submit' name='action' value='readFromSession'>Daten aus Session lesen</button>");
				out.println("</div>");
				out.println("</form>");
				out.println("</body>");
				out.println("</html>");
				break;
				
			case "readFromSession":
				session = request.getSession();
				vorname = (String) session.getAttribute("vorname");
				nachname = (String) session.getAttribute("nachname");
				out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.println("<body>");
				out.println("<h3>Lesen von Daten aus einer Sitzung</h3>");
				out.println("<b>Gelesene Daten:</b><br>");
				out.println("Vorname: " + vorname + "<br>");
				out.println("Nachname: " + nachname + "<br>");
				out.println("</body>");
				out.println("</html>");
				break;
				
			default:
				out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.println("<body>");
				out.println("<h3>Unbekannte Aktion!</h3>");
				out.println("</body>");
				out.println("</html>");
				break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
