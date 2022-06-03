/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tigris;

import bean.Product;
import bean.Subscription;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
 * @author Damia Nizam
 */
@WebServlet(name = "viewServlet", urlPatterns = {"/medicine", "/wellness", "/personalCare", "/healthFood", "/healthDevice", "/index", "/" , "/viewSubscriptions"})
public class viewServlet extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
response.setContentType("text/html;charset=UTF-8");
        
        String path = request.getServletPath();
        HttpSession session = request.getSession();
        
        if (path.equals("/medicine") )
                {
                    String driver = "com.mysql.jdbc.Driver";
                    String dbName = "tigris2022";
                    String url = "jdbc:mysql://localhost/" + dbName + "?";
                    String userName = "root";
                    String password = "";
                    String query = "Select * FROM product WHERE category='Medicine';";
                    Class.forName(driver);
                    Connection con = DriverManager.getConnection (url, userName, password);
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(query);
                    ArrayList<Product> productList = new ArrayList<Product>();                  
                    
                    while(rs.next())
                    {   
                        Blob blob = rs.getBlob("image");
                        InputStream inputStream = blob.getBinaryStream();
                        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                        byte[] buffer = new byte[4096];
                        int bytesRead = -1;

                        while ((bytesRead = inputStream.read(buffer)) != -1) {
                            outputStream.write(buffer, 0, bytesRead);                  
                        }
                        byte[] imageBytes = outputStream.toByteArray();
                        String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                        
                        Product p = new Product();
                        p.setId(rs.getInt(1));
                        p.setName(rs.getString(2));
                        p.setStock(rs.getInt(3));
                        p.setCategory(rs.getString(4));
                        p.setPrice(rs.getDouble(5));
                        p.setDescription(rs.getString(6));
                        p.setBase64Image(base64Image);
                        
                        productList.add(p);
                    }  
                    
                    st.close(); //7- close connection
                    con.close();
                    
                    request.setAttribute("products", productList);
                    request.getRequestDispatcher("Medicine.jsp").forward(request, response);
                    
                }
        if (path.equals("/wellness"))
                {
                    String driver = "com.mysql.jdbc.Driver";
                    String dbName = "tigris2022";
                    String url = "jdbc:mysql://localhost/" + dbName + "?";
                    String userName = "root";
                    String password = "";
                    String query = "Select * FROM product WHERE category='wellness';";
                    Class.forName(driver);
                    ArrayList<Product> productList;
                    
                    Connection con = DriverManager.getConnection (url, userName, password);
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(query);
                    productList = new ArrayList<Product>();
                    
                    while(rs.next())
                    {   
                        Blob blob = rs.getBlob("image");
                        InputStream inputStream = blob.getBinaryStream();
                        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                        byte[] buffer = new byte[4096];
                        int bytesRead = -1;

                        while ((bytesRead = inputStream.read(buffer)) != -1) {
                            outputStream.write(buffer, 0, bytesRead);                  
                        }
                        byte[] imageBytes = outputStream.toByteArray();
                        String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                        
                        Product p = new Product();
                        p.setId(rs.getInt(1));
                        p.setName(rs.getString(2));
                        p.setStock(rs.getInt(3));
                        p.setCategory(rs.getString(4));
                        p.setPrice(rs.getDouble(5));
                        p.setDescription(rs.getString(6));
                        p.setBase64Image(base64Image);
                        
                        productList.add(p);
                    }
                    st.close(); //7- close connection
                    con.close();
                        
                    request.setAttribute("products", productList);
                    request.getRequestDispatcher("Wellness.jsp").forward(request, response);
                   
                }
        if (path.equals("/personalCare"))
                {
                    String driver = "com.mysql.jdbc.Driver";
                    String dbName = "tigris2022";
                    String url = "jdbc:mysql://localhost/" + dbName + "?";
                    String userName = "root";
                    String password = "";
                    String query = "SELECT * FROM product WHILE category='Personal Care';";
                    Class.forName(driver);
                    Connection con = DriverManager.getConnection(url, userName, password);
                    PreparedStatement st = con.prepareStatement(query);
                    ResultSet rs = st.executeQuery(query); //execute query
                    ArrayList<Product> productList = new ArrayList<Product>();
                    
                    while(rs.next())
                    {   
                        Blob blob = rs.getBlob("image");
                        InputStream inputStream = blob.getBinaryStream();
                        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                        byte[] buffer = new byte[4096];
                        int bytesRead = -1;

                        while ((bytesRead = inputStream.read(buffer)) != -1) {
                            outputStream.write(buffer, 0, bytesRead);                  
                        }
                        byte[] imageBytes = outputStream.toByteArray();
                        String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                        
                        Product p = new Product();
                        p.setId(rs.getInt(1));
                        p.setName(rs.getString(2));
                        p.setStock(rs.getInt(3));
                        p.setCategory(rs.getString(4));
                        p.setPrice(rs.getDouble(5));
                        p.setDescription(rs.getString(6));
                        p.setBase64Image(base64Image);
                        
                        productList.add(p);
                    }
                    
                    st.close(); //close connection
                    con.close();
                    request.setAttribute("products", productList);
                    request.getRequestDispatcher("personalCare.jsp").forward(request, response);
                  
                }
        if (path.equals("/healthFood"))
                {
                    String driver = "com.mysql.jdbc.Driver";
                    String dbName = "tigris2022";
                    String url = "jdbc:mysql://localhost/" + dbName + "?";
                    String userName = "root";
                    String password = "";
                    String query = "SELECT * FROM product WHILE category='Health Food';";
                    Class.forName(driver);
                    Connection con = DriverManager.getConnection(url, userName, password);
                    PreparedStatement st = con.prepareStatement(query);
                    ResultSet rs = st.executeQuery(query); //execute query
                    ArrayList<Product> productList = new ArrayList<Product>();
                    
                    while(rs.next())
                    {   
                        Blob blob = rs.getBlob("image");
                        InputStream inputStream = blob.getBinaryStream();
                        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                        byte[] buffer = new byte[4096];
                        int bytesRead = -1;

                        while ((bytesRead = inputStream.read(buffer)) != -1) {
                            outputStream.write(buffer, 0, bytesRead);                  
                        }
                        byte[] imageBytes = outputStream.toByteArray();
                        String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                        
                        Product p = new Product();
                        p.setId(rs.getInt(1));
                        p.setName(rs.getString(2));
                        p.setStock(rs.getInt(3));
                        p.setCategory(rs.getString(4));
                        p.setPrice(rs.getDouble(5));
                        p.setDescription(rs.getString(6));
                        p.setBase64Image(base64Image);
                        
                        productList.add(p);
                    }
                    
                    st.close(); //close connection
                    con.close();
                    request.setAttribute("products", productList);
                    request.getRequestDispatcher("healthFood.jsp").forward(request, response);
                  
                }
        if (path.equals("/healthDevice")) 
                {
                    String driver = "com.mysql.jdbc.Driver";
                    String dbName = "tigris2022";
                    String url = "jdbc:mysql://localhost/" + dbName + "?";
                    String userName = "root";
                    String password = "";
                    String query = "SELECT * FROM product WHILE category='Healthcare Device';";
                    Class.forName(driver);
                    Connection con = DriverManager.getConnection(url, userName, password);
                    PreparedStatement st = con.prepareStatement(query);
                    ResultSet rs = st.executeQuery(query); //execute query
                    ArrayList<Product> productList = new ArrayList<Product>();
                    
                    while(rs.next())
                    {   
                        Blob blob = rs.getBlob("image");
                        InputStream inputStream = blob.getBinaryStream();
                        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                        byte[] buffer = new byte[4096];
                        int bytesRead = -1;

                        while ((bytesRead = inputStream.read(buffer)) != -1) {
                            outputStream.write(buffer, 0, bytesRead);                  
                        }
                        byte[] imageBytes = outputStream.toByteArray();
                        String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                        
                        Product p = new Product();
                        p.setId(rs.getInt(1));
                        p.setName(rs.getString(2));
                        p.setStock(rs.getInt(3));
                        p.setCategory(rs.getString(4));
                        p.setPrice(rs.getDouble(5));
                        p.setDescription(rs.getString(6));
                        p.setBase64Image(base64Image);
                        
                        productList.add(p);
                    }
                    
                    st.close(); //close connection
                    con.close();
                    request.setAttribute("products", productList);
                    request.getRequestDispatcher("healthcareDevice.jsp").forward(request, response);
                    
                }
        if (path.equals("/testKit"))
                {
                    String driver = "com.mysql.jdbc.Driver";
                    String dbName = "tigris2022";
                    String url = "jdbc:mysql://localhost/" + dbName + "?";
                    String userName = "root";
                    String password = "";
                    String query = "SELECT * FROM product WHILE category='Test Kit';";
                    Class.forName(driver);
                    Connection con = DriverManager.getConnection(url, userName, password);
                    PreparedStatement st = con.prepareStatement(query);
                    ResultSet rs = st.executeQuery(query); //execute query
                    ArrayList<Product> productList = new ArrayList<Product>();
                    while(rs.next())
                    {   
                        Blob blob = rs.getBlob("image");
                        InputStream inputStream = blob.getBinaryStream();
                        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                        byte[] buffer = new byte[4096];
                        int bytesRead = -1;

                        while ((bytesRead = inputStream.read(buffer)) != -1) {
                            outputStream.write(buffer, 0, bytesRead);                  
                        }
                        byte[] imageBytes = outputStream.toByteArray();
                        String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                        
                        Product p = new Product();
                        p.setId(rs.getInt(1));
                        p.setName(rs.getString(2));
                        p.setStock(rs.getInt(3));
                        p.setCategory(rs.getString(4));
                        p.setPrice(rs.getDouble(5));
                        p.setDescription(rs.getString(6));
                        p.setBase64Image(base64Image);
                        
                        productList.add(p);
                    }
                    st.close(); //close connection
                    con.close();
                    request.setAttribute("products", productList);
                    request.getRequestDispatcher("testKit.jsp").forward(request, response);
                   
                }
        
        
        if (path.equals("/index") || path.equals("/"))
            {   String driver = "com.mysql.jdbc.Driver";
                    String dbName = "tigris2022";
                    String url = "jdbc:mysql://localhost/" + dbName + "?";
                    String userName = "root";
                    String password = "";
                    String query = "Select * FROM product ;";
                    Class.forName(driver);
                    Connection con = DriverManager.getConnection (url, userName, password);
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(query);
                    ArrayList<Product> productList = new ArrayList<Product>();                  
                    
                    while(rs.next())
                    {   
                        Blob blob = rs.getBlob("image");
                        InputStream inputStream = blob.getBinaryStream();
                        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                        byte[] buffer = new byte[4096];
                        int bytesRead = -1;

                        while ((bytesRead = inputStream.read(buffer)) != -1) {
                            outputStream.write(buffer, 0, bytesRead);                  
                        }
                        byte[] imageBytes = outputStream.toByteArray();
                        String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                        
                        Product p = new Product();
                        p.setId(rs.getInt(1));
                        p.setName(rs.getString(2));
                        p.setStock(rs.getInt(3));
                        p.setCategory(rs.getString(4));
                        p.setPrice(rs.getDouble(5));
                        p.setDescription(rs.getString(6));
                        p.setBase64Image(base64Image);
                        
                        productList.add(p);
                    }  
                    
                    st.close(); //7- close connection
                    con.close();
                    
                    request.setAttribute("products", productList);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        
        if(path.equals("/viewSubscriptions"))
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
                request.getRequestDispatcher("viewSubs.jsp").forward(request, response);
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
            Logger.getLogger(viewServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(viewServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(viewServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(viewServlet.class.getName()).log(Level.SEVERE, null, ex);
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
