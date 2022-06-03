/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package tigris;

import bean.Product;
import bean.Subscription;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet({"/editSubscriptionForm", "/updateSubscription", "/deleteSubscription", "/subs"})
public class subscriptionServlet extends HttpServlet {

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
        
        //check which path the page wants
        if(path.equals("/editSubscriptionForm"))
        {
            String driver = "com.mysql.jdbc.Driver";
            String dbName = "tigris2022";
            String url = "jdbc:mysql://localhost/" + dbName + "?";
            String userName = "root";
            String password = "";
            
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(subscriptionServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Connection con = DriverManager.getConnection(url, userName, password); //add throw
            PreparedStatement st = con.prepareStatement("select * from subscription where id=?");
            
            int sid = Integer.parseInt(request.getParameter("sid"));
            st.setInt(1, sid);
            
            ResultSet rs = st.executeQuery(); //execute query
            
            Subscription s = new Subscription();
            while(rs.next())
            {
                s.setId(rs.getInt(1));
                s.setUsername(rs.getString(2));
                s.setMedication(rs.getString(3));
                s.setTime(rs.getDate(4));
            }
            
            st.close(); //close connection
            
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(subscriptionServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String query2 = "select * from product";
            PreparedStatement st2 = con.prepareStatement(query2); 
            ResultSet rs2 = st2.executeQuery(query2); //execute query
            
            ArrayList<Product> productList = new ArrayList<Product>();  
            
            while(rs2.next())
            {
                Product p = new Product();
                p.setId(rs2.getInt(1));
                p.setName(rs2.getString(2));
                p.setStock(rs2.getInt(3));
                p.setCategory(rs2.getString(4));
                p.setPrice(rs2.getDouble(5));
                p.setDescription(rs2.getString(6));
                //p.setImage(rs2.getString(7));
                    
                productList.add(p);
            }
            
            
            st2.close(); //close connection            
            con.close();
            
            request.setAttribute("products", productList);
            request.setAttribute("sub", s);
            request.getRequestDispatcher("/editSubscription.jsp").forward(request, response); 
        } 
        if(path.equals("/updateSubscription"))
        {            
            String driver = "com.mysql.jdbc.Driver";
            String dbName = "tigris2022";
            String url = "jdbc:mysql://localhost/" + dbName + "?";
            String userName = "root";
            String password = "";
            
            String query =  "update subscription set username=?,medication=?,time=? where id=?";
            
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(subscriptionServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Connection con = DriverManager.getConnection(url, userName, password); //add throw
            PreparedStatement st = con.prepareStatement(query);
            
            int sid = Integer.parseInt(request.getParameter("sid"));
            String username = request.getParameter("username");
            String medication = request.getParameter("medication");
            Date time = Date.valueOf(request.getParameter("time"));
            
            st.setString(1, username);
            st.setString(2, medication);
            st.setDate(3, time);
            st.setInt(4, sid);
            
            st.executeUpdate();
            con.close();
            st.close(); //close connection

            response.sendRedirect("/Tigris_Pharmacy/adminViewSubscriptions"); 
        }
        if(path.equals("/deleteSubscription"))
        {
            String driver = "com.mysql.jdbc.Driver";
            String dbName = "tigris2022";
            String url = "jdbc:mysql://localhost/" + dbName + "?";
            String userName = "root";
            String password = "";
            
            String query = "delete from subscription where id=?";
            
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(subscriptionServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Connection con = DriverManager.getConnection(url, userName, password); //add throw
            PreparedStatement st = con.prepareStatement(query);
            
            int sid = Integer.parseInt(request.getParameter("sid"));
            st.setInt(1, sid);
            
            st.executeUpdate();
            con.close();
            st.close(); //close connection

            response.sendRedirect("/Tigris_Pharmacy/adminViewSubscriptions"); 
        }
       //customer view for subscription
        if(path.equals("subs")){
            response.sendRedirect("/Tigris_Pharmacy/subscription.jsp");
        }
        if(path.equals("addCustomerSubs")){
            String driver = "com.mysql.jdbc.Driver";
            String dbName = "tigris2022";
            String url = "jdbc:mysql://localhost/" + dbName + "?";
            String userName = "root";
            String password = "";
            
            String query =  "update subscription set username=?,medication=?,time=? where id=?";
            
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(subscriptionServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Connection con = DriverManager.getConnection(url, userName, password); //add throw
            PreparedStatement st = con.prepareStatement(query);
            
            int sid = Integer.parseInt(request.getParameter("sid"));
            String username = request.getParameter("username");
            String medication = request.getParameter("medication");
            Date time = Date.valueOf(request.getParameter("time"));
            
            st.setString(1, username);
            st.setString(2, medication);
            st.setDate(3, time);
            st.setInt(4, sid);
            
            st.executeUpdate();
            con.close();
            st.close(); //close connection

            response.sendRedirect("/Tigris_Pharmacy/viewSubscriptions"); 
        }
        
        if(path.equals("/deleteCustomerSubs"))
        {
            String driver = "com.mysql.jdbc.Driver";
            String dbName = "tigris2022";
            String url = "jdbc:mysql://localhost/" + dbName + "?";
            String userName = "root";
            String password = "";
            
            String query = "delete from subscription where id=?";
            
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(subscriptionServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Connection con = DriverManager.getConnection(url, userName, password); //add throw
            PreparedStatement st = con.prepareStatement(query);
            
            int sid = Integer.parseInt(request.getParameter("sid"));
            st.setInt(1, sid);
            
            st.executeUpdate();
            con.close();
            st.close(); //close connection

            response.sendRedirect("/Tigris_Pharmacy/viewSubscriptions"); 
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
            Logger.getLogger(subscriptionServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(subscriptionServlet.class.getName()).log(Level.SEVERE, null, ex);
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
