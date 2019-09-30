package no.hvl.dat108;

import static no.hvl.dat108.UrlMappings.LOGIN_URL;
import static no.hvl.dat108.UrlMappings.WEBSHOP_URL;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringEscapeUtils;

@WebServlet("/" + WEBSHOP_URL)
public class WebShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<String> handleliste;
	
	@Override
	public void init() throws ServletException {
		handleliste = new ArrayList<String>();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (!InnloggingUtil.isInnlogget(request)) {
			response.sendRedirect(LOGIN_URL + "?feilkode=2");
		} else {
			HttpSession sesjon = request.getSession(false);
			String passord = (String) sesjon.getAttribute("passord");

			response.setContentType("text/html; charset=ISO-8859-1");
			PrintWriter out = response.getWriter();

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"ISO-8859-1\">");
			out.println("<title>Handleliste</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Min handleliste:</h1>");
			out.println("<form action=\"" + WEBSHOP_URL + "\" method=\"post\">");
			out.println("    <p><input type=\"submit\" value=\"Legg til\" />"
					+ "<input type=\"text\" name=\"varenavn\" /></p>");
			out.println("</form>");
			
			for (String vare : handleliste) {
				out.println("	<form method=\"post\">");
				out.println("		<input type=\"hidden\" name=\"slett\" value=\"" + vare
						+ "\"><input type=\"submit\" value=\"Slett\"> " + vare + "</form>");
			}
			out.println("</body>");
			out.println("</html>");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (!InnloggingUtil.isInnlogget(request)) {
			response.sendRedirect(LOGIN_URL + "?feilkode=2");
		} else {
			HttpSession sesjon = request.getSession(false);			
			
			//Enten trykket på slett eller legg til knappen
			if (request.getParameter("slett") != null  && handleliste.indexOf((StringEscapeUtils.escapeHtml(request.getParameter("slett")))) != -1) {
				synchronized (handleliste) {
					handleliste.remove(handleliste.indexOf(StringEscapeUtils.escapeHtml(request.getParameter("slett"))));
				}
			} else {
				String varenavn = StringEscapeUtils.escapeHtml(request.getParameter("varenavn"));
				if (varenavn.matches("^\\S(.*)$")) {
					synchronized (handleliste) {
						handleliste.add(varenavn);
					}
				}
			}
			response.sendRedirect(WEBSHOP_URL);
		}
	}
}
