/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.art.servlet;


import com.art.dao.UserDao;
import com.art.dto.User;
//import java.io.*;
//import java.util.*;
//import javax.servlet.*;
//import javax.servlet.http.*;
//import javax.mail.*;

import java.io.IOException;
import java.io.PrintWriter;
//import java.util.Date;
//import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SACHIN JADHAV
 */
public class Contact extends HttpServlet {

    /*private Object textpart;
    private Object InternetAdress;
    private String email;*/

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
        
        
      // Recipient's email ID needs to be mentioned.
      /*String to = "1998sachinjadhav@gmail.com";
 
      // Sender's email ID needs to be mentioned
      String from = "06sachinjadhav@gmail.com";
 
      // Assuming you are sending email from localhost
      String host = "localhost";
 
      // Get system properties
      Properties properties = System.getProperties();
 
      // Setup mail server
      properties.setProperty("mail.smtp.host", host);
 
      // Get the default Session object.
      Session session = Session.getDefaultInstance(properties);*/
 
        
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            /*out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Contact</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Contact at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
            String first_name = request.getParameter("first_name");
            String last_name = request.getParameter("last_name");
            String email_id = request.getParameter("email_id");
            String subject = request.getParameter("subject");
            String message = request.getParameter("message");
            //out.println("First Name: "+first_name+"<br><br>"+"last_name: "+last_name+"<br><br>"+"Email: "+email_id+"<br><br>"+"Subject: "+subject+"<br><br>"+"Message: "+message);
            //int id = UserDao.checkid(name,email_id,subject,msg);
                
            User user=new User();
                    user.setFirst_name(first_name);
                    user.setLast_name(last_name);
                    user.setEmail_id(email_id);
                    user.setSubject(subject);
                    user.setMessage(message);
            
            boolean addContact = UserDao.addContact(user);
            response.sendRedirect("index.html");
           
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
    /*@Override
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
    /*@Override
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

            
