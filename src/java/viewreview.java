
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
import java.sql.ResultSet;
import java.sql.Statement;
@WebServlet(urlPatterns = {"/viewreview"})
public class viewreview extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException,ClassNotFoundException,SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String moviename;
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbmsproject","root","hellomfs");
        pst = con.prepareStatement("select * from userrating where mov_name=?");
        try ( PrintWriter out = response.getWriter()) {
            moviename = request.getParameter("moviename");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title></title>");            
            out.println("</head>");
            out.println("<body>");
            out.println(moviename);
            pst.setString(1,moviename);
            rs = pst.executeQuery();
            out.println("<table border = 1> <tr> <th>Movie</th> <th>Rating</th> <th>Review</th></tr>");
            while(rs.next())
            {
                
                out.println("<tr>"+"<td>"+rs.getString(1)+"</td>"+"<td>"+rs.getInt(2)+"</td>"+"<td>"+rs.getString(3)+"</td>"+"</tr>");
            }
            out.println("</table>");
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
