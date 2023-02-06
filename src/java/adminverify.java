
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
@WebServlet(urlPatterns = {"/adminverify"})
public class adminverify extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException,ClassNotFoundException,SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String uname,password;
        Connection con;
        PreparedStatement pst;
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbmsproject","root","hellomfs");
        PreparedStatement ps=con.prepareStatement(  "select * from admin where uname=? and password=?");  
        try ( PrintWriter out = response.getWriter()) {
            uname = request.getParameter("uname");
            password = request.getParameter("password");
            boolean status = false;
            ps.setString(1,uname);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();  
            status = rs.next();
            if(status)
            {
                RequestDispatcher rd=request.getRequestDispatcher("adminpage.html");  
                rd.forward(request,response);  
            }
            else
            {
                out.print("Sorry username or password error");  
                RequestDispatcher rd=request.getRequestDispatcher("adminloginpage.html");  
                rd.include(request,response);  

            }
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
