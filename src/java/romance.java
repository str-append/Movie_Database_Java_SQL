/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

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
import java.sql.ResultSet;

/**
 *
 * @author yashsharma
 */
@WebServlet(urlPatterns = {"/romance"})
public class romance extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException,ClassNotFoundException,SQLException {
        response.setContentType("text/html;charset=UTF-8");
        Connection con;
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbmsproject","root","hellomfs");
        Statement st = con.createStatement();
        ResultSet rs =st.executeQuery("select * from movies where movie_id in (select movie_id from romance);");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>All Movies</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet allmovies at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
              out.println("<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\" /><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" /><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n" +
                           "<link rel=\"stylesheet\" href=\"style2.css\" /><link\n"+
                           "href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\"rel=\"stylesheet\"\n" +
                            "integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\"\n" +
                            "crossorigin=\"anonymous/>\n" +
                            "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"\n" +
                                "integrity=\"sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p\"\n" +     
                                "crossorigin=\"anonymous\"\n" +
                            "></script>\n" +
                            "<title>Movie Reccomendation</title>\n" +
                            "</head>\n" +
                                "<body>\n" +
                                    "<div class=\"main\">\n" +
                                        "<div class=\"nav-bar\">\n" +
                                            "<h1>Movie Mangement</h1>\n" +
                                            "<nav>\n" +
                                                "<ul>\n" +
                                                    "<li><a class=\"nav-link\" href=\"index.html\">Home</a></li>\n" +
                                                    "<li><a class=\"nav-link\" href=\"action\">Action</a></li>\n" +
                                                    "<li><a class=\"nav-link active\" href=\"romance\">Romance</a></li>\n" +
                                                    "<li><a class=\"nav-link\" href=\"comedy\">Comedy</a></li>\n" +
                                                    "<li><a class=\"nav-link\" href=\"allmovies\">All Movies</a></li>\n" +
                                                    "<li><a class=\"nav-link\" href=\"adminloginpage.html\">Admin</a></li>"+
                                               "</ul>\n" +
                                           "</nav>\n" +
                                    "</div>\n" +
                                    "<div class=\"cardContainer\">\n");
              while(rs.next())
              {
                  //out.println("<tr>"+"<td>"+rs.getInt(1)+"</td>"+"<td>"+rs.getString(2)+"</td>"+"<td>"+rs.getString(3)+"</td>"+"<td>"+rs.getString(4)+"</td>"+"<td>"+"</tr>");
                  out.println("<div class=\"card\"> \n" +
                                        "<img src="+rs.getInt(1)+".jpg"+" alt=\"\" height=\"400px\" width=\"350px\" style=\"object-fit: cover;\"/>\n" +
                                        "<div class=\"content\">\n" +
                                            "<table style=\"color: black; padding:20px; border-spacing: 10px;\">\n" +
                                                    "<tr>\n" +
                                                        "<th>Movie Name: </th>\n" +
                                                        "<td>"+rs.getString(2)+"</td>\n" +
                                                    "</tr>\n" +
                                                    "<tr>\n" +
                                                        "<th>Released on: </th>\n" +
                                                        "<td>"+rs.getString(3)+"</td>\n" +
                                                    "</tr>\n" +
                                                    "<tr>\n" +
                                                        "<th>Actor: </th>\n" +
                                                        "<td>"+rs.getString(4)+"</td>\n" +
                                                    "</tr>\n" +
                                                    "<tr>\n" +
                                                        "<th>Actress: </th>\n" +
                                                        "<td>"+rs.getString(5)+"</td>\n" +
                                                    "</tr>\n" +
                                            "</table>\n" +
                                       "</div>\n" +
                                   "</div>\n");
              }
              out.println("</div>");
                         
              
              
              
              
              
              
              out.println("<footer>\n" +
"        <div class=\"footer\">\n" +
"          <p>Made By Yash Sharma </p>\n" +
"        </div>\n" +
"      </footer>" +
                            "</div>\n" +
"<script>\n" +
"      var btns = document.getElementsByClassName(\"nav-link\");\n" +
"      console.log(btns);\n" +
"      for (var i = 0; i < btns.length; i++) {\n" +
"        btns[i].addEventListener(\"click\", function () {\n" +
"          var current = document.getElementsByClassName(\"active\");\n" +
"          current[0].className = current[0].className.replace(\" active\", \"\");\n" +
"          this.className += \" active\";\n" +
"        });\n" +
"      }\n" +
"    </script>\n" +
"  </body>\n" +
"</html>\n" +
"");
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
