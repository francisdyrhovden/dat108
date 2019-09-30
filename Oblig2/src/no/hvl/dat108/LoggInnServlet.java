package no.hvl.dat108;

import static no.hvl.dat108.UrlMappings.LOGIN_URL;
import static no.hvl.dat108.UrlMappings.WEBSHOP_URL;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoggInnServlet", urlPatterns = "/" + LOGIN_URL)
public class LoggInnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	String riktigPassord;
	int tid;
	
	@Override
	public void init() throws ServletException {
		
		riktigPassord = getServletConfig().getInitParameter("passord");
		tid = Integer.parseInt(getServletConfig().getInitParameter("tid"));
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=ISO-8859-1");

        PrintWriter out = response.getWriter();
        

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"ISO-8859-1\">");
        out.println("<title>Login</title>");
        out.println("</head>");
        out.println("<body>");
        
        String feilkode = request.getParameter("feilkode");
        if (feilkode != null) {
        	if (feilkode.equals("1")) {
           	 out.println("<p>Passordet du ga var feil. Prøv igjen:</p>");
           } else if (feilkode.equals("2")) {
           	out.println("<p>Du må logge inn før du kan se handleliste</p>");
           } else if (feilkode.equals("3")) {
           	out.println("<p>Du ble logget ut.</p>");
           }
        }

        out.println("<form action=\"" + LOGIN_URL + "\" method=\"post\">");
        out.println("  <fieldset>");
        out.println("    <legend>Login</legend>");
        out.println("    <p>Passord: <input type=\"password\" name=\"password\" /></p>");
        out.println("    <p><input type=\"submit\" value=\"Logg inn\" /></p>");
        out.println("  </fieldset>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	String passord = request.getParameter("password");
    	
    	if (!InnloggingUtil.isGyldigPassord(passord, riktigPassord)) {
    		response.sendRedirect(LOGIN_URL + "?feilkode=1");
    	} else {
    		InnloggingUtil.loggInnMedTimeout(request, tid);
    		response.sendRedirect(WEBSHOP_URL);
    	}	

	}

}
