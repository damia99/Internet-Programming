/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package tigris;

import bean.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
@WebServlet({"/viewProduct", "/insertProduct", "/updateProduct", "/deleteProduct", "/editProductForm", "/addProductForm", "/viewOrder"})
public class productServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException 
    {
        response.setContentType("text/html;charset=UTF-8");
        String path = request.getServletPath();
        HttpSession session = request.getSession();
        
        //check which path the page wants
        if(path.equals("/viewProduct"))
        {
            String driver = "com.mysql.jdbc.Driver";
            String dbName = "tigris2022";
            String url = "jdbc:mysql://localhost/" + dbName + "?";
            String userName = "root";
            String password = "";
            
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(productServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Connection con = DriverManager.getConnection(url, userName, password); //add throw
            PreparedStatement st = con.prepareStatement("select * from product where id=?");
            
            int pid = Integer.parseInt(request.getParameter("pid"));
            st.setInt(1, pid);
            
            ResultSet rs = st.executeQuery(); //execute query
            
            Product p = new Product();
            while(rs.next())
            {
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
            }
            
            st.close(); //close connection
            con.close();
            
            request.setAttribute("product", p);
            request.getRequestDispatcher("/viewProductPage.jsp").forward(request, response); 
            //response.sendRedirect("/Tigris_Pharmacy/viewProductPage.jsp"); 
        }
        else if(path.equals("/addProductForm"))
        {
            response.sendRedirect("/Tigris_Pharmacy/addProduct.jsp"); 
        }
        else if(path.equals("/insertProduct"))
        {
            String name = request.getParameter("name");
            int stock = Integer.parseInt(request.getParameter("stock"));
            String category = request.getParameter("category");
            double price = Double.parseDouble(request.getParameter("price"));
            String description = request.getParameter("description");
            String image = request.getParameter("image");

            String driver = "com.mysql.jdbc.Driver";
            String dbName = "tigris2022";
            String url = "jdbc:mysql://localhost/" + dbName + "?";
            String userName = "root";
            String password = "";

            String query = "INSERT INTO product(name,stock_qty,category,price,description,image) VALUES(?,?,?,?,?,?)";
            
            try {
                Class.forName(driver); //surround with try catch
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(productServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection con = DriverManager.getConnection(url, userName, password);
            PreparedStatement st = con.prepareStatement(query);
            
            st.setString(1, name);
            st.setInt(2, stock);
            st.setString(3, category);
            st.setDouble(4, price);
            st.setString(5, description);
            //this will insert a string not a blob for the image
            st.setString(6, image);
            
            st.executeUpdate();
            
            con.close();
            st.close(); //close connection
            
            response.sendRedirect("/Tigris_Pharmacy/adminViewProducts"); 
        }
        else if(path.equals("/editProductForm"))
        {
            String driver = "com.mysql.jdbc.Driver";
            String dbName = "tigris2022";
            String url = "jdbc:mysql://localhost/" + dbName + "?";
            String userName = "root";
            String password = "";
            
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(productServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection con = DriverManager.getConnection(url, userName, password); //add throw
            PreparedStatement st = con.prepareStatement("select * from product where id=?");
            
            int pid = Integer.parseInt(request.getParameter("pid"));
            st.setInt(1, pid);
   
            ResultSet rs = st.executeQuery(); //execute query
            
            Product p = new Product();
            while(rs.next())
            {
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
            }
            
            st.close(); //close connection
            con.close();
            
            request.setAttribute("product", p);
            request.getRequestDispatcher("/editProduct.jsp").forward(request, response); 
        }
        else if(path.equals("/updateProduct"))
        {
            int pid = Integer.parseInt(request.getParameter("pid"));
            String name = request.getParameter("name");
            int stock = Integer.parseInt(request.getParameter("stock"));
            String category = request.getParameter("category");
            double price = Double.parseDouble(request.getParameter("price"));
            String description = request.getParameter("description");
            String image = request.getParameter("image");

            String driver = "com.mysql.jdbc.Driver";
            String dbName = "tigris2022";
            String url = "jdbc:mysql://localhost/" + dbName + "?";
            String userName = "root";
            String password = "";

            String query =  "update product set name=?,stock_qty=?,category=?,price=?,description=?,image=? where id=?";
            
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(productServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection con = DriverManager.getConnection(url, userName, password); //add throw
            PreparedStatement st = con.prepareStatement(query);
            
            st.setString(1, name);
            st.setInt(2, stock);
            st.setString(3, category);
            st.setDouble(4, price);
            st.setString(5, description);
            st.setString(6, image);
            st.setInt(7, pid);
            
            st.executeUpdate();
            con.close();
            st.close(); //close connection

            response.sendRedirect("/Tigris_Pharmacy/adminViewProducts"); 
        }
        else if(path.equals("/deleteProduct"))
        {
            String driver = "com.mysql.jdbc.Driver";
            String dbName = "tigris2022";
            String url = "jdbc:mysql://localhost/" + dbName + "?";
            String userName = "root";
            String password = "";
            
            String query = "delete from product where id=?";
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(productServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection con = DriverManager.getConnection(url, userName, password); //add throw
            PreparedStatement st = con.prepareStatement(query);
            
            int pid = Integer.parseInt(request.getParameter("pid"));
            st.setInt(1, pid);
            
            st.executeUpdate();
            con.close();
            st.close(); //close connection

            response.sendRedirect("/Tigris_Pharmacy/adminViewProducts"); 
        }
      
        else if (path.equals("/viewOrder")) {
            String driver = "com.mysql.jdbc.Driver";
            String dbName = "tigris2022";
            String url = "jdbc:mysql://localhost/" + dbName + "?";
            String userName = "root";
            String password = "";

            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(productServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            Connection con = DriverManager.getConnection(url, userName, password); //add throw
            PreparedStatement st = con.prepareStatement("select * from product where id=?");

            int pid = Integer.parseInt(request.getParameter("pid"));
            st.setInt(1, pid);

            ResultSet rs = st.executeQuery(); //execute query

            ArrayList<Product> productList = new ArrayList<Product>();  
            
            while (rs.next()) {
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
            request.getRequestDispatcher("/cart.jsp").forward(request, response);
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {    
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(productServlet.class.getName()).log(Level.SEVERE, null, ex);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(productServlet.class.getName()).log(Level.SEVERE, null, ex);
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
