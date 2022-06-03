/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package tigris;

import bean.Customer;
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
@WebServlet({"/editCustomerForm", "/updateCustomer", "/deleteCustomer","/editProfile","/updateProfile"})
public class customerServlet extends HttpServlet {

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
        
        if(path.equals("/editCustomerForm"))
        {
            String driver = "com.mysql.jdbc.Driver";
            String dbName = "tigris2022";
            String url = "jdbc:mysql://localhost/" + dbName + "?";
            String userName = "root";
            String password = "";
            
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(customerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Connection con = DriverManager.getConnection(url, userName, password); //add throw
            PreparedStatement st = con.prepareStatement("select * from customer where id=?");
            
            int cid = Integer.parseInt(request.getParameter("cid"));
            st.setInt(1, cid);
            
            ResultSet rs = st.executeQuery(); //execute query
            
            Customer c = new Customer();
            while(rs.next())
            {
                c.setId(rs.getInt(1));
                c.setFirstname(rs.getString(2));
                c.setLastname(rs.getString(3));
                c.setEmail(rs.getString(4));
                c.setPhone(rs.getString(5));
                c.setAddress(rs.getString(7));
            }
            
            st.close(); //close connection
            con.close();
            
            request.setAttribute("customer", c);
            request.getRequestDispatcher("/editCustomer.jsp").forward(request, response);
        }
        else if(path.equals("/updateCustomer"))
        {
            int cid = Integer.parseInt(request.getParameter("cid"));
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            
            String driver = "com.mysql.jdbc.Driver";
            String dbName = "tigris2022";
            String url = "jdbc:mysql://localhost/" + dbName + "?";
            String userName = "root";
            String password = "";
            
            String query =  "update customer set firstname=?,lastname=?,email=?,phonenumber=?,address=? where id=?";
            
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(customerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Connection con = DriverManager.getConnection(url, userName, password); //add throw
            PreparedStatement st = con.prepareStatement(query);
            
            st.setString(1, firstname);
            st.setString(2, lastname);
            st.setString(3, email);
            st.setString(4, phone);
            st.setString(5, address);
            st.setInt(6, cid);
            
            st.executeUpdate();
            con.close();
            st.close(); //close connection
            
            response.sendRedirect("/Tigris_Pharmacy/adminViewCustomers");
        }
        else if(path.equals("/deleteCustomer"))
        {
            String driver = "com.mysql.jdbc.Driver";
            String dbName = "tigris2022";
            String url = "jdbc:mysql://localhost/" + dbName + "?";
            String userName = "root";
            String password = "";
            
            String query = "delete from customer where id=?";
            
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(customerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Connection con = DriverManager.getConnection(url, userName, password); //add throw
            PreparedStatement st = con.prepareStatement(query);
            
            int cid = Integer.parseInt(request.getParameter("cid"));
            st.setInt(1, cid);
            
            st.executeUpdate();
            con.close();
            st.close(); //close connection

            response.sendRedirect("/Tigris_Pharmacy/adminViewCustomers"); 
        }
        
        else if(path.equals("/editProfile"))
        {
            String driver = "com.mysql.jdbc.Driver";
            String dbName = "tigris2022";
            String url = "jdbc:mysql://localhost/" + dbName + "?";
            String userName = "root";
            String password = "";
            
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(customerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Connection con = DriverManager.getConnection(url, userName, password); //add throw
            PreparedStatement st = con.prepareStatement("select * from customer where id=?");
            
            int cid = Integer.parseInt(request.getParameter("cid"));
            st.setInt(1, cid);
            
            ResultSet rs = st.executeQuery(); //execute query
            
            Customer c = new Customer();
            while(rs.next())
            {
                c.setId(rs.getInt(1));
                c.setFirstname(rs.getString(2));
                c.setLastname(rs.getString(3));
                c.setEmail(rs.getString(4));
                c.setPhone(rs.getString(5));
                c.setAddress(rs.getString(7));
            }
            
            st.close(); //close connection
            con.close();
            
            request.setAttribute("customer", c);
            request.getRequestDispatcher("/editCustomer.jsp").forward(request, response);
        }
        
        else if(path.equals("/updateProfile"))
        {
            int cid = Integer.parseInt(request.getParameter("cid"));
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            
            String driver = "com.mysql.jdbc.Driver";
            String dbName = "tigris2022";
            String url = "jdbc:mysql://localhost/" + dbName + "?";
            String userName = "root";
            String password = "";
            
            String query =  "update customer set firstname=?,lastname=?,email=?,phonenumber=?,address=? where id=?";
            
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(customerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Connection con = DriverManager.getConnection(url, userName, password); //add throw
            PreparedStatement st = con.prepareStatement(query);
            
            st.setString(1, firstname);
            st.setString(2, lastname);
            st.setString(3, email);
            st.setString(4, phone);
            st.setString(5, address);
            st.setInt(6, cid);
            
            st.executeUpdate();
            con.close();
            st.close(); //close connection
            
            response.sendRedirect("/Tigris_Pharmacy/adminViewCustomers");
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
            Logger.getLogger(customerServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(customerServlet.class.getName()).log(Level.SEVERE, null, ex);
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
