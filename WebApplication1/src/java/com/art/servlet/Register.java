/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.art.servlet;

import com.art.db.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dell
 */
public class Register extends HttpServlet {

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
PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String email_id = request.getParameter("email_id");
		String password = request.getParameter("password");
		String mobile_number = request.getParameter("mobile_number");
		String dob = request.getParameter("dob");
		String state = request.getParameter("state");
		String gender = request.getParameter("gender");
                try {
		Connection con = DBConnection.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into registeration values(?,?,?,?,?,?,?,?)");
		ps.setString(1, first_name);
		ps.setString(2, last_name);
		ps.setString(3, mobile_number);
		ps.setString(4, email_id);
		ps.setString(5, dob);
		ps.setString(6, password);
		ps.setString(7, gender);
                ps.setString(8, state);
		int k = ps.executeUpdate();
		if(k==1)
		{
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
			pw.println("<h3 class='tab'>User Registered Successfully</h3>");
		}
		}
		catch(Exception e)
		{
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
