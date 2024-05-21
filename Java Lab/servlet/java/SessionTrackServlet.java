

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionTrackServlet")
public class SessionTrackServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Date createTime = new Date(session.getCreationTime());
		Date lastAccessTime = new Date(session.getLastAccessedTime());
		String title = "";
		int visitCount = 0;
		String userID = "";
		if(session.isNew())
		{
			title += "Welcome to my website";
			session.setAttribute("userID", "ABCD");
		}
		else
		{
			title += "Welcome back to my website";
			visitCount = (Integer)session.getAttribute("visitCount");
			visitCount = visitCount + 1;
			userID = (String)session.getAttribute("userID");
		}
		session.setAttribute("visitCount", visitCount);
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String s="<html><body><h1>"+title+"</h1><br><br>";
		s=s+"<h3>Session Information</h3>" + "<br/>" + "ID:" + session.getId() + 
				"</br>" + "Creation Time:" + createTime + "<br/>" + "Time of Last Access:" 
				+ lastAccessTime + "<br/>" + "User ID:" + userID + "<br/>" + "Number of visits:" 
				+ visitCount + "<br/></body></html>";
		pw.println(s);
	}
}
