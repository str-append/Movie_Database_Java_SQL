
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.lang.ClassNotFoundException;
import java.sql.DriverManager;
import java.sql.Statement;
@WebServlet(urlPatterns = {"/addmovie"})
public class addmovie extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException,ClassNotFoundException,SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String moviename,actor,actress,releasedate;
        int movieid;
        Connection con;
        PreparedStatement pst;
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbmsproject","root","hellomfs");
        pst = con.prepareStatement("insert into movies values(?,?,?,?,?)");
        try ( PrintWriter out = response.getWriter()) {
            moviename = request.getParameter("moviename");
            movieid = Integer.parseInt(request.getParameter("movieid"));
            actor = request.getParameter("actor");
            releasedate = request.getParameter("releasedate");
            actress = request.getParameter("actress");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet add_info</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<p>Name : "+moviename+"<br>");
            out.println("<p>Movie Id : "+movieid+"<br>");
            out.println("<p>Actor : "+actor+"<br>");
            out.println("<p>Actress : "+actress+"<br>");
            out.println("<p>Release Date : "+releasedate+"<br>");
            pst.setInt(1,movieid);
            pst.setString(2,moviename);
            pst.setString(3,releasedate);
            pst.setString(4,actor);
            pst.setString(5,actress);
            int count = pst.executeUpdate();
            out.println("<p>The Above Details has been added to the Database</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
        processRequest(request, response);
        }catch(SQLException e){
            
        } catch(ClassNotFoundException e){
            
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
        processRequest(request, response);
        }catch(SQLException e){
            
        } catch(ClassNotFoundException e){
            
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
