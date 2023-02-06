
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
@WebServlet(urlPatterns = {"/reviewmovie"})
public class reviewmovie extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException,ClassNotFoundException,SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String moviename,review;
        int rating;
        Connection con;
        PreparedStatement pst;
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbmsproject","root","hellomfs");
        pst = con.prepareStatement("insert into userrating values(?,?,?)");
        try ( PrintWriter out = response.getWriter()) {
            moviename = request.getParameter("moviename");
            rating = Integer.parseInt(request.getParameter("rating"));
            review = request.getParameter("review");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Add Review</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<p>Name : "+moviename+"<br>");
            out.println("<p>Rating : "+rating+"<br>");
            out.println("<p>Review : "+review+"<br>");
            pst.setString(1,moviename);
            pst.setInt(2,rating);
            pst.setString(3,review);
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
