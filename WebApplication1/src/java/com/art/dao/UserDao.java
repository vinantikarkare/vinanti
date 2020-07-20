/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.art.dao;

import com.art.dto.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;



import com.art.db.DBConnection;
import com.art.db.DBProperties;


/**
 *
 * @author hp
 */
public class UserDao {
    
public static boolean addUser(User user)
{
    String first_name =user.getFirstname();
    String last_name = user.getLastname();
    String email_id = user.getEmail();
    String password = user.getPassword();
    String mobile_number =user.getMobile();
    String dob =user.getDob();
    String state = user.getState();
    String gender =user.getGender();
    String otp =user.getOtp();
    boolean flag=true;
    try {
                
		Connection con = DBConnection.getConnection();
                String sql = "INSERT INTO registration (first_name, last_name, mobile_number, email_id, dob, password, gender, state, otp) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, first_name);
		ps.setString(2, last_name);
		ps.setString(3, mobile_number);
		ps.setString(4, email_id);
		ps.setString(5, dob);
		ps.setString(6, password);
		ps.setString(7, gender);
                ps.setString(8, state);
                ps.setString(9, otp);
		flag=ps.execute();
        
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return flag;
    }


    public static int login_check(String email_id, String password) {
      Connection conn = DBConnection.getConnection();
      System.out.println(password);
      System.out.println(email_id);
        int id=0;
        try {
            String sql = "select id from registration where email_id ='"+email_id+"' and password ='"+password+"'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            System.out.println(sql);
            while (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    

    public static int checkOtp(String otp, String email_id) {
     Connection conn = DBConnection.getConnection();
      String otp_db="";
      int id=0;
        try {
            String sql = "select otp,id from registration where email_id ='"+email_id+"'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            System.out.println(sql);
            while (rs.next()) {
                id = rs.getInt("id");
                otp_db = rs.getString("otp");
            }
            st.close();
            if(otp_db.equals(otp))
                    {
                    String sqll = "update registration set otp='"+0+"' where email_id='"+email_id+"'";
                    Statement stt = conn.createStatement();
                    int rss = stt.executeUpdate(sqll);
                    System.out.println(sqll);
                    }
        
            else{
                System.out.println("nhiiii huaaaa");
            }
        }
                catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("idd"+id);
        return id;
    }
    
     public static int clicklike(String id,String codee) throws SQLException {
         boolean flag = true;
         int a=0;
        Connection conn = DBConnection.getConnection();

        System.out.println("+++++++++++++++++++++="+id+"  "+codee);
                      String sql = "update likebutton set likee = concat(likee, '"+id+"') where code = '"+codee+"'";
                System.out.println(sql);
                PreparedStatement ps = conn.prepareStatement(sql);
                System.out.println("==========");
                flag = ps.execute();

                
                return a;
    
    }
    
     public static String checkid(String codee) {
          Connection conn = DBConnection.getConnection();
     String likee="";
        try {
            String sql = "select likee from likebutton where code ='"+codee+"'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            System.out.println(sql);
            while (rs.next()) {
               likee  = rs.getString("likee");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return likee;
    }
    
    
public static boolean unclickLike(String codee, String likebuttonid) {
        boolean flag = false; 
        try {
        Connection conn = DBConnection.getConnection();
        String sql = "update likebutton set likee ='"+likebuttonid+"' where code = '"+codee+"'";
                System.out.println(sql);
                PreparedStatement ps = conn.prepareStatement(sql);
                System.out.println("==========");
                flag = ps.execute();

         }catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
