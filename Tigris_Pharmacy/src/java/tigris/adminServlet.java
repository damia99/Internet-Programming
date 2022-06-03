/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package tigris;

import bean.Customer;
import bean.Forum;
import bean.Order;
import bean.Product;
import bean.Subscription;
import java.io.ByteArrayOutputStream;
import java.sql.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Base64;
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

@WebServlet({"/adminViewProducts", "/adminLoginForm", "/adminViewCustomers", "/adminViewForum", "/adminViewSubscriptions", "/adminViewOrders"})
public class adminServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        String path = request.getServletPath();
        HttpSession session = request.getSession();
        
        //check which path the page wants
        if(path.equals("/adminViewProducts"))
        {

            String driver = "com.mysql.jdbc.Driver";
            String dbName = "tigris2022";
            String url = "jdbc:mysql://localhost/" + dbName + "?";
            String userName = "root";
            String password = "";
            
            String query = "SELECT * FROM product";
            
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(adminServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Connection con = DriverManager.getConnection(url, userName, password);
            PreparedStatement st = con.prepareStatement(query); 
            ResultSet rs = st.executeQuery(query); //execute query
                
            ArrayList<Product> productList = new ArrayList<Product>();  
                
            while(rs.next())
            {
                Product p = new Product();
                p.setId(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setStock(rs.getInt(3));
                p.setCategory(rs.getString(4));
                p.setPrice(rs.getDouble(5));
                p.setDescription(rs.getString(6));
                
                Blob blob = rs.getBlob(7);
                
                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                byte[] imageBytes = outputStream.toByteArray();
                
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                
                inputStream.close();
                outputStream.close();
                
                p.setBase64Image(base64Image);
                    
                productList.add(p);
            }
                
            st.close(); //close connection
            con.close();
                
            request.setAttribute("products", productList);
            request.getRequestDispatcher("/adminViewProductList.jsp").forward(request, response);
        }
        else if(path.equals("/adminLoginForm"))
        {
            //change to request dispatcher when passing data to jsp
            response.sendRedirect("/Tigris_Pharmacy/adminLogin.jsp"); 
        }
        else if(path.equals("/adminViewCustomers"))
        {
            String driver = "com.mysql.jdbc.Driver";
            String dbName = "tigris2022";
            String url = "jdbc:mysql://localhost/" + dbName + "?";
            String userName = "root";
            String password = "";
            
            String query = "SELECT * FROM customer";
            
            Class.forName(driver);
            
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
            request.getRequestDispatcher("adminViewCustomerList.jsp").forward(request, response);
        }
        else if(path.equals("/adminViewForum"))
        {
            String driver = "com.mysql.jdbc.Driver";
            String dbName = "tigris2022";
            String url = "jdbc:mysql://localhost/" + dbName + "?";
            String userName = "root";
            String password = "";
            
            String query = "SELECT * FROM forum";
            
            Class.forName(driver);
            
            Connection con = DriverManager.getConnection(url, userName, password);
            PreparedStatement st = con.prepareStatement(query);  
            ResultSet rs = st.executeQuery(query); //execute query
            
            ArrayList<Forum> forumList = new ArrayList<Forum>();
            
            while(rs.next())
            {
                Forum f = new Forum();
                f.setId(rs.getInt(1));
                f.setTopic(rs.getString(2));
                f.setMessage(rs.getString(3));
                f.setReply(rs.getString(4));
                
                forumList.add(f);
            }
            
            st.close(); //close connection
            con.close();
            
            request.setAttribute("forum", forumList);
            request.getRequestDispatcher("adminViewForum.jsp").forward(request, response);
        }
        else if(path.equals("/adminViewSubscriptions"))
        {
            String driver = "com.mysql.jdbc.Driver";
            String dbName = "tigris2022";
            String url = "jdbc:mysql://localhost/" + dbName + "?";
            String userName = "root";
            String password = "";
            
            String query = "SELECT * FROM subscription";
            
            Class.forName(driver);
            
            Connection con = DriverManager.getConnection(url, userName, password);
            PreparedStatement st = con.prepareStatement(query);  
            ResultSet rs = st.executeQuery(query); //execute query
            
            ArrayList<Subscription> subList = new ArrayList<Subscription>();
            
            while(rs.next())
            {
                Subscription s = new Subscription();
                s.setId(rs.getInt(1));
                s.setUsername(rs.getString(2));
                s.setMedication(rs.getString(3));
                s.setTime(rs.getDate(4));
                
                subList.add(s);
            }
            
            st.close(); //close connection
            con.close();
            
            request.setAttribute("subs", subList);
            request.getRequestDispatcher("adminViewSubList.jsp").forward(request, response);
        }
        else if(path.equals("/adminViewOrders"))
        {
            String driver = "com.mysql.jdbc.Driver";
            String dbName = "tigris2022";
            String url = "jdbc:mysql://localhost/" + dbName + "?";
            String userName = "root";
            String password = "";
            
            String query = "SELECT * FROM orders";
            
            Class.forName(driver);
            
            Connection con = DriverManager.getConnection(url, userName, password);
            PreparedStatement st = con.prepareStatement(query);  
            ResultSet rs = st.executeQuery(query); //execute query
            
            ArrayList<Order> orderList = new ArrayList<Order>();
            
            while(rs.next())
            {
                Order o = new Order();
                o.setOrder_id(rs.getInt(1));
                o.setCustomer_id(rs.getInt(2));
                o.setProduct_id(rs.getInt(3));
                o.setQuantity(rs.getInt(4));
                o.setOrder_status(rs.getBoolean(6));
                
                Blob blob = rs.getBlob(5);
                
                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                byte[] imageBytes = outputStream.toByteArray();
                
                String prescription = Base64.getEncoder().encodeToString(imageBytes);
                
                inputStream.close();
                outputStream.close();
                
                o.setPrescription(prescription);
                
                orderList.add(o);
            }
            
            st.close(); //close connection
            con.close();

            request.setAttribute("orders", orderList);
            request.getRequestDispatcher("adminViewOrderList.jsp").forward(request, response);
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(adminServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(adminServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(adminServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(adminServlet.class.getName()).log(Level.SEVERE, null, ex);
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
