/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.art.servlet;
import java.io.*;
import com.art.dao.UserDao;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ind
 */
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
            throws ServletException, IOException {
  
            /* TODO output your page here. You may use following sample code. */
                PrintWriter pw = response.getWriter();
           	String email_id = request.getParameter("email");
		String password = request.getParameter("password");
               
                
                System.out.println(email_id);
                System.out.println(password);
                
               
                 int id= UserDao.login_check(email_id,password);
                
                String checkotp = UserDao.checkloginOtp( email_id);
                            
                  String mobiles= "7974644419";
                  String firstname="Vaibhav";
                  String lastname= "Patidar";
        
       
        
                 System.out.println("================="+id);
                 System.out.println("=="+checkotp);
                 
                 HttpSession session = request.getSession(false);
                 
                 if((id!=0) && (checkotp.equals("0"))) 
                {
                    
                    session.setAttribute("id", id);
                     response.sendRedirect("comment.jsp");
                    
                }
                else if((id!=0) && !(checkotp.equals("0")))
                {
                    response.sendRedirect("otp.jsp");
                }
              
                else
                {
                    RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.include(request,response);
				pw.println("<div class=\"tab\">Incorrect email or Password</div>");
                }
        
    }

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
