/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package tigris;

import bean.Order;
import bean.Product;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
@WebServlet({"/approveOrderForm", "/updateOrder", "/addOrder"})
public class orderServlet extends HttpServlet {

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
        
        if(path.equals("/approveOrderForm"))
        {
            String driver = "com.mysql.jdbc.Driver";
            String dbName = "tigris2022";
            String url = "jdbc:mysql://localhost/" + dbName + "?";
            String userName = "root";
            String password = "";
            
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(orderServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Connection con = DriverManager.getConnection(url, userName, password); //add throw
            PreparedStatement st = con.prepareStatement("select * from orders where order_id=?");
            
            int oid = Integer.parseInt(request.getParameter("oid"));
            st.setInt(1, oid);
            
            ResultSet rs = st.executeQuery(); //execute query
            
            Order o = new Order();
            while(rs.next())
            {
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
            }
            
            st.close(); //close connection
            con.close();
            
            request.setAttribute("order", o);
            request.getRequestDispatcher("/approveOrder.jsp").forward(request, response);
        }
        else if(path.equals("/updateOrder"))
        {
            int oid = Integer.parseInt(request.getParameter("oid"));
            Boolean order_status = Boolean.parseBoolean(request.getParameter("os"));
            
            String driver = "com.mysql.jdbc.Driver";
            String dbName = "tigris2022";
            String url = "jdbc:mysql://localhost/" + dbName + "?";
            String userName = "root";
            String password = "";
            
            String query =  "update orders set order_status=? where order_id=?";
            
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(orderServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Connection con = DriverManager.getConnection(url, userName, password); //add throw
            PreparedStatement st = con.prepareStatement(query);
            
            st.setBoolean(1, order_status);
            st.setInt(2, oid);
            
            st.executeUpdate();
            con.close();
            st.close(); //close connection
            
            response.sendRedirect("/Tigris_Pharmacy/adminViewOrders"); 
        }
        
        else if(path.equals("/addOrder"))
        {
            int pid = Integer.parseInt(request.getParameter("pid"));
            int quantity = Integer.parseInt(request.getParameter("qty"));

            String driver = "com.mysql.jdbc.Driver";
            String dbName = "tigris2022";
            String url = "jdbc:mysql://localhost/" + dbName + "?";
            String userName = "root";
            String password = "";
            
            String query =  "INSERT INTO orders (product_id, quantity) VALUES(?,?)";
            
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(orderServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Connection con = DriverManager.getConnection(url, userName, password); //add throw
            PreparedStatement st = con.prepareStatement(query);
           
            st.setInt(1, pid);
            st.setInt(2, quantity);
            
            st.executeUpdate();
            st.close(); //close connection
            
           try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(subscriptionServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String query2 = "select * product where id=?";
            PreparedStatement st2 = con.prepareStatement(query2);
            ResultSet rs2 = st2.executeQuery(query2); //execute query

            ArrayList<Product> productList = new ArrayList<Product>();

            while (rs2.next()) {
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
            request.getRequestDispatcher("/cart.jsp").forward(request, response); ; 
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
            Logger.getLogger(orderServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(orderServlet.class.getName()).log(Level.SEVERE, null, ex);
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
