/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.art.dao;

import com.art.db.DBConnection;
import com.art.db.DBProperties;
import com.art.dto.User;
import com.art.servlet.OtpGeneration;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;





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
    String profile=user.getProfile();
    boolean flag=true;
    try {
                
		Connection con = DBConnection.getConnection();
                String sql = "INSERT INTO registration (first_name, last_name, mobile_number, email_id, dob, password, gender, state, otp, profile) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
                ps.setString(10, profile);
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
    
     public static int clicklike(String id,String codee,int count) throws SQLException {
         boolean flag = true;
         int a=0;
        
        Connection conn = DBConnection.getConnection();

        System.out.println("+++++++++++++++++++++="+id+"  "+codee);
                      String sql = "update likebutton set likes = concat(likes, '"+id+"'),likes_count = '"+count+"' where code = '"+codee+"'";
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
            String sql = "select likes from likebutton where code ='"+codee+"'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            System.out.println(sql);
            while (rs.next()) {
               likee  = rs.getString("likes");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return likee;
    }
    
     public static int likeCount(String codee)
     {
         int count=0;
          Connection conn = DBConnection.getConnection();
            try {
                String sql = "select likes_count from likebutton where code ='"+codee+"'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            System.out.println(sql);
            while (rs.next()) {
               count  = rs.getInt("likes_count");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
     
     }
    
public static boolean unclickLike(String codee, String likebuttonid, int count) {
        boolean flag = false; 
        try {
        Connection conn = DBConnection.getConnection();
        String sql = "update likebutton set likes ='"+likebuttonid+"',likes_count = '"+count+"' where code = '"+codee+"'";
                System.out.println(sql);
                PreparedStatement ps = conn.prepareStatement(sql);
                System.out.println("==========");
                flag = ps.execute();

         }catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean addComment(User user) {
        int id=user.getId();
    String first_index =user.getFirst_index();
    String last_index = user.getLast_index();
    String comment = user.getComment();
    String unique_code = user.getUnique_code();
    String comment_reply= OtpGeneration.uniqueCodeGen();
    boolean flag=true;
    try {
                
		Connection con = DBConnection.getConnection();
                String sql = "INSERT INTO comment (id, first_index, last_index, comment, comment_reply, unique_code) values (?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, id);
		ps.setString(2, first_index);
		ps.setString(3, last_index);
		ps.setString(4, comment);
		ps.setString(5, comment_reply);
		ps.setString(6, unique_code);
		flag=ps.execute();
        
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return flag;
    }
    
      public static ArrayList<User> getComment() {
        Connection conn = DBConnection.getConnection();
        ArrayList<User> userList = new ArrayList<>();
        try {
            
           
            String sql = "select * from comment";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String unique_code = rs.getString("unique_code");
                String first_index = rs.getString("first_index");
                String last_index = rs.getString("last_index");
                String comment = rs.getString("comment");
                String comment_reply= rs.getString("comment_reply");
               
               
                System.out.println("  " + id);
                User user = new User();
                user.setId(id);
                user.setFirst_index(first_index);
                user.setLast_index(last_index);
                user.setComment(comment);
                user.setComment_reply(comment_reply);
                user.setUnique_code(unique_code);

                userList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }
    
       public static User getUser(int id) {
        User user = new User();
        System.out.println("============================================" + id);
        Connection conn = DBConnection.getConnection();
        try {
            String sql = "select * from registration where id=" + id;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String mobile_number = rs.getString("mobile_number");
                String email_id = rs.getString("email_id");
                String dob = rs.getString("dob");
                String password = rs.getString("password");
                String gender = rs.getString("gender");
                String state = rs.getString("state");
                String profile = rs.getString("profile");
                user.setFirstname(first_name);
                user.setLast_name(last_name);
                user.setMobile_number(mobile_number);
                user.setEmail_id(email_id);
                user.setDob(dob);
                user.setPassword(password);
                user.setGender(gender);
                user.setState(state);
                user.setProfile(profile);          
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public static String uploadPhoto(User user) {
        LocalTime now = LocalTime.now();
        Time time = Time.valueOf( now );
        String date = user.getDate();
        String unique_code = user.getUnique_code();
        String profile = user.getProfile();
        boolean flag=true;
        try {
        Connection conn = DBConnection.getConnection();
         String sql = "INSERT INTO likebutton (code, profile, date, time) values (?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, unique_code);
		ps.setString(2, profile);
		ps.setString(3, date);
		ps.setTime(4, time);
                flag=ps.execute();
        
         }catch (Exception e) {
            e.printStackTrace();
        }
        return unique_code;
    }
       
     public static boolean addContact(User user) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        String first_name =user.getFirstname();
        String last_name =user.getLastname();
        String email_id =user.getEmail();
        String subject =user.getSubject();
        String message =user.getMessage();
        boolean flag=true;
        try 
        {
                
	Connection con = DBConnection.getConnection();
        String sql = "INSERT INTO contactus (first_name, last_name, email_id, subject, message) values (?, ?, ?, ?, ?)";            
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, first_name);
        ps.setString(2, last_name);
	ps.setString(3, email_id);
        ps.setString(4, subject);
	ps.setString(5, message);
	flag=ps.execute();
        
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return flag;
    }
public static String checkloginOtp(String email_id) {
        Connection conn = DBConnection.getConnection();
        String otp="";
        int id=0;
        try
        {
            String sql = "select otp,id from registration where email_id ='"+email_id+"'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            System.out.println(sql);
            while (rs.next()) {
                id = rs.getInt("id");
                otp=rs.getString("otp");
                System.out.println(id+""+otp);
                
            }
        } 
          catch (Exception e) {
            e.printStackTrace();
        }
        return otp;
    }
    
}






