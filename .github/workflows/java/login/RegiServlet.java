package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
  Servlet implementation class RegiServlet
 */
@jakarta.servlet.annotation.WebServlet("/reg")
public class RegiServlet extends jakarta.servlet.http.HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
Connection con;
@SuppressWarnings("unused")
private Throwable e;
public void init()
{
	try {
		ServletContext sc= getServletContext();
		String s1=sc.getInitParameter("driver");
		String s2=sc.getInitParameter("url");
		String s3=sc.getInitParameter("username");
		String s4=sc.getInitParameter("password");
	  
		Class.forName(s1);
		con=DriverManager.getConnection(s2,s3,s4);
		
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			
		}catch(SQLException e) {
		 e.printStackTrace();
		}
	
}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	

try{
			String s1=request.getParameter("fname");
			String s2=request.getParameter("lname");
			String s3=request.getParameter("uname");
			String s4=request.getParameter("pword");
			String s5=request.getParameter("email");
			String s6=request.getParameter("mobile_no");
			String s7=request.getParameter("city");
			PreparedStatement pstmt=con.prepareStatement("insert into info values(?,?,?,?,?,?,?)");
			pstmt.setString(1, s1);
			pstmt.setString(2, s2);
			pstmt.setString(3, s3);
			pstmt.setString(4, s4);
			pstmt.setString(5, s5);
			pstmt.setString(6, s6);
			pstmt.setString(7, s7);
			pstmt.executeUpdate();
			PrintWriter pw=response.getWriter();
			pw.println("<html><body bgcolor=cyan text=red><centre>");
			pw.println("<h1> You Have Registrered Successfully</h1>");
			pw.println("<a href=login.html>Login</a>");
			pw.println("</center></body></html>");
			
		
	

}catch (SQLException e)
{e.printStackTrace();

}catch(IOException e)
{
	e.printStackTrace();
}
}
}
