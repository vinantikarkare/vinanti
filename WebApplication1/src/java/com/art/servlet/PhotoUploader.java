/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.art.servlet;
import com.art.dao.UserDao;
import com.art.db.*;
import com.art.dto.User;
import static com.art.servlet.OtpGeneration.uniqueCodeGen;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import static java.time.Instant.now;
import static java.time.LocalDate.now;
import java.time.LocalTime;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Dell
 */
public class PhotoUploader extends HttpServlet {

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
            throws ServletException, IOException {
        FileItem item = null;
        String itemName = "";
        String profile= "";
       response.setContentType("text/html;charset=UTF-8");
       try {
            PrintWriter out = response.getWriter();
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            if (isMultipart) {
                ServletContext context = getServletContext();
                String realPath = context.getRealPath("/");
                System.out.println("project path  = " + realPath);
                realPath = realPath.replace(File.separator+"build", "");
                realPath= realPath +"@";
                System.out.println("path without build " + realPath + "");
                
                realPath=realPath.replace("@", "\\");
                System.out.println("----------------------------------------"+ realPath);
                String finalPath = realPath + "upload";
                System.out.println("final path" + finalPath);

                FileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(factory);
                try {
                    List items = upload.parseRequest(request);
                    Iterator itr = items.iterator();
                    while (itr.hasNext()) {
                        item = (FileItem) itr.next();
                        if (!item.isFormField()) {
                            itemName = item.getName();
                            System.out.println("=================11=====" + itemName);
                            profile = itemName.toString();
                            int i = itemName.toString().lastIndexOf("\\");
                            profile = profile.substring(itemName.lastIndexOf("\\") + 1);
                            finalPath = finalPath + File.separator + profile;
                            System.out.println("imagepath =" + finalPath);
                            File savedFile = new File(finalPath);
                            item.write(savedFile);
                        }}
                       
                //     Generating time and date   
                    Date now = new Date();
                    String pattern = "yyyy-MM-dd";
                    SimpleDateFormat formatter = new SimpleDateFormat(pattern);
                    String mysqlDateString = formatter.format(now);
                    String unique_code= uniqueCodeGen();
                  
                
                  User user=new User();
                  user.setProfile(itemName);
                  user.setDate(mysqlDateString);
                  user.setUnique_code(unique_code);
                  String uploadPhoto = UserDao.uploadPhoto(user);
                  
                    response.sendRedirect("index.html");
        
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
       }catch (Exception e) {
                    e.printStackTrace();
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
        processRequest(request, response);
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
        processRequest(request, response);
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
