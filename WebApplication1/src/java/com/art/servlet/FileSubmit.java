/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.art.servlet;

import com.art.dao.UserDao;
import com.art.dto.User;
import static com.art.servlet.OtpGeneration.uniqueCodeGen;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dell
 */
public class FileSubmit extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        
        String idd = request.getParameter("idd");
        int id= Integer.parseInt(idd);
        System.out.println("vinantiiiiiiiiiiiiii"+id);
        String text = request.getParameter("textfile");
        String topic = request.getParameter("topic");
        String unique_code = uniqueCodeGen();
        ServletContext context = getServletContext();
           String realPath = context.getRealPath("/");
                System.out.println("project path  = " + realPath);
                realPath = realPath.replace(File.separator+"build", "");
                realPath= realPath +"@";
                System.out.println("path without build " + realPath + "");
                
                realPath=realPath.replace("@", "\\");
                System.out.println("----------------------------------------"+ realPath);
                String finalPath = realPath + "upload\\";
                System.out.println("final path" + finalPath);
               try {
                    FileWriter myWriter = new FileWriter(finalPath+topic);
                    myWriter.write(text);
                    myWriter.close();
                    System.out.println("Successfully wrote to the file.");
                  } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                  }
                 
                 User user=new User();
              user.setWriters_id(id);
              user.setTopic(topic);
              user.setUnique_code(unique_code);
                String addWritersText = UserDao.addWritersText(user);
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
