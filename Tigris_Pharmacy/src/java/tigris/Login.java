/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tigris;

import bean.Customer;
import java.io.*;
import java.sql.*;
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
 * @author nasrin
 */

@WebServlet({"/login", "/resetpassword", "/signUp","/insertCustomer","/viewProfile"})
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String path = request.getServletPath();
            HttpSession session = request.getSession();
            
            
             //check which path the page wants
        if(path.equals("/login"))
        {

            String driver = "com.mysql.jdbc.Driver";
            String dbName = "tigris2022";
            String url = "jdbc:mysql://localhost/" + dbName + "?";
            String userName = "root";
            String password = "";
            
            String query = "SELECT * FROM customer";
            
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(adminServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Connection con = DriverManager.getConnection(url, userName, password);
            PreparedStatement st = con.prepareStatement(query); 
            ResultSet rs = st.executeQuery(query); //execute query
                
            ArrayList<Customer> customerList = new ArrayList<Customer>();  
                
            while(rs.next())
            {
                Customer c = new Customer();
                c.setId(rs.getInt(1));
                c.setFirstname(rs.getString(2));
                c.setLastname(rs.getString(3));
                c.setEmail(rs.getString(4));
                c.setPhone(rs.getString(4));
                c.setAddress(rs.getString(6));
                
                    
                customerList.add(c);
            }
                
            st.close(); //close connection
            con.close();
                
            request.setAttribute("customers", customerList);
            request.getRequestDispatcher("/loginCustomer").forward(request, response);
        }
        else if(path.equals("/resetpassword"))
        {
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String email = request.getParameter("email");
            String phonenumber = request.getParameter("phonenumber");
            String passwordU = request.getParameter("password");
            String address = request.getParameter("address");

            String driver = "com.mysql.jdbc.Driver";
            String dbName = "tigris2022";
            String url = "jdbc:mysql://localhost/" + dbName + "?";
            String userName = "root";
            String password = "";
            String query =  "update customer set password=? where id=?";
            
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(productServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection con = DriverManager.getConnection(url, userName, password); //add throw
            PreparedStatement st = con.prepareStatement(query);
            
            st.setString(1, password);
            
            st.executeUpdate();
            con.close();
            st.close(); //close connection

            response.sendRedirect("/Tigris_Pharmacy/login");  
        }
        
        else if(path.equals("/signUp"))
        {
            //change to request dispatcher when passing data to jsp
            response.sendRedirect("/Tigris_Pharmacy/register.jsp"); 
        }
        
         else if(path.equals("/insertCustomer"))
        {
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String email = request.getParameter("email");
            String phonenumber = request.getParameter("phonenumber");
            String passwordU = request.getParameter("password");
            String address = request.getParameter("address");

            String driver = "com.mysql.jdbc.Driver";
            String dbName = "tigris2022";
            String url = "jdbc:mysql://localhost/" + dbName + "?";
            String userName = "root";
            String password = "";

            String query = "INSERT INTO customer(firstname,lastname,email,phonenumber,password,adress) VALUES(?,?,?,?,?,?)";
            
            try {
                Class.forName(driver); //surround with try catch
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(productServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection con = DriverManager.getConnection(url, userName, password);
            PreparedStatement st = con.prepareStatement(query);
            
            st.setString(1, firstname);
            st.setString(2, lastname);
            st.setString(3, email);
            st.setString(4, phonenumber);
            st.setString(5, password);
            st.setString(6, address);
            
            
            st.executeUpdate();
            
            con.close();
            st.close(); //close connection
            
            response.sendRedirect("/Tigris_Pharmacy/viewProfile"); 
        }
        else if(path.equals("/viewProfile"))
        {
            String driver = "com.mysql.jdbc.Driver";
            String dbName = "tigris2022";
            String url = "jdbc:mysql://localhost/" + dbName + "?";
            String userName = "root";
            String password = "";
            
            String query = "SELECT * FROM customer";
            
                try {
                    Class.forName(driver);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            Connection con = DriverManager.getConnection(url, userName, password);
            PreparedStatement st = con.prepareStatement(query);  
            ResultSet rs = st.executeQuery(query); //execute query
            
            ArrayList<Customer> customerList = new ArrayList<Customer>();
            
            while(rs.next())
            {
                Customer c = new Customer();
                c.setId(rs.getInt(1));
                c.setFirstname(rs.getString(2));
                c.setLastname(rs.getString(3));
                c.setEmail(rs.getString(4));
                c.setPhone(rs.getString(5));
                c.setAddress(rs.getString(7));
                
                customerList.add(c);
            }
            
            st.close(); //close connection
            con.close();
            
            request.setAttribute("customers", customerList);
            request.getRequestDispatcher("viewProfile.jsp").forward(request, response);
        }
        
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
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
