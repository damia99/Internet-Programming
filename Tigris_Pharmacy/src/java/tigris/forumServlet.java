/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package tigris;

import bean.Forum;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mhdrfq
 */

@WebServlet({"/replyForumForm", "/updateForum", "/deleteEntry","/addEntry"})
public class forumServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
       
        String path = request.getServletPath();
        HttpSession session = request.getSession();
        
        if(path.equals("/replyForumForm"))
        {
            String driver = "com.mysql.jdbc.Driver";
            String dbName = "tigris2022";
            String url = "jdbc:mysql://localhost/" + dbName + "?";
            String userName = "root";
            String password = "";
            
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(forumServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Connection con = DriverManager.getConnection(url, userName, password); //add throw
            PreparedStatement st = con.prepareStatement("select * from forum where id=?");
            
            int eid = Integer.parseInt(request.getParameter("eid"));
            st.setInt(1, eid);
   
            ResultSet rs = st.executeQuery(); //execute query
            
            Forum f = new Forum();
            while(rs.next())
            {
                f.setId(rs.getInt(1));
                f.setTopic(rs.getString(2));
                f.setMessage(rs.getString(3));
                f.setReply(rs.getString(4));
            }
            
            st.close(); //close connection
            con.close();
            
            request.setAttribute("entry", f);
            request.getRequestDispatcher("/replyForum.jsp").forward(request, response); 
        }    
        if(path.equals("/updateForum"))
        {
            int eid = Integer.parseInt(request.getParameter("eid"));
            String reply = request.getParameter("reply");
            
            String driver = "com.mysql.jdbc.Driver";
            String dbName = "tigris2022";
            String url = "jdbc:mysql://localhost/" + dbName + "?";
            String userName = "root";
            String password = "";
            
            String query =  "update forum set reply=? where id=?";
            
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(forumServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Connection con = DriverManager.getConnection(url, userName, password); //add throw
            PreparedStatement st = con.prepareStatement(query);
            
            st.setString(1, reply);
            st.setInt(2, eid);
            
            st.executeUpdate();
            con.close();
            st.close(); //close connection
            
            response.sendRedirect("/Tigris_Pharmacy/adminViewForum"); 
        }
        else if(path.equals("/deleteEntry"))
        {
            String driver = "com.mysql.jdbc.Driver";
            String dbName = "tigris2022";
            String url = "jdbc:mysql://localhost/" + dbName + "?";
            String userName = "root";
            String password = "";
            
            String query = "delete from forum where id=?";
            
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(forumServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection con = DriverManager.getConnection(url, userName, password); //add throw
            PreparedStatement st = con.prepareStatement(query);
            
            int eid = Integer.parseInt(request.getParameter("eid"));
            st.setInt(1, eid);
            
            st.executeUpdate();
            con.close();
            st.close(); //close connection

            response.sendRedirect("/Tigris_Pharmacy/adminViewForum"); 
        }
        
        if(path.equals("/addEntry"))
        {
            int eid = Integer.parseInt(request.getParameter("eid"));
            String message = request.getParameter("message");
            String topic = request.getParameter("topic");
            
            String driver = "com.mysql.jdbc.Driver";
            String dbName = "tigris2022";
            String url = "jdbc:mysql://localhost/" + dbName + "?";
            String userName = "root";
            String password = "";
            
            String query =  "update forum set reply=? where id=?";
            
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(forumServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Connection con = DriverManager.getConnection(url, userName, password); //add throw
            PreparedStatement st = con.prepareStatement(query);
            
            st.setString(1, topic);
            st.setString(2, message);
            st.setInt(3, eid);
            
            st.executeUpdate();
            con.close();
            st.close(); //close connection
            
            response.sendRedirect("/Tigris_Pharmacy/forumCustomer"); 
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(forumServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(forumServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
