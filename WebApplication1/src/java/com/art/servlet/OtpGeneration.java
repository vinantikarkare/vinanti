/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.art.servlet;

import java.util.Random;

/**
 *
 * @author Dell
 */
public class OtpGeneration {
     public static String otpGen(){ 
              String OTPCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
                StringBuilder otpp = new StringBuilder();
                Random rnd = new Random();
                while (otpp.length() < 6) { // length of the random string.
                    int index = (int) (rnd.nextFloat() * OTPCHARS.length());
                    otpp.append(OTPCHARS.charAt(index));
                }
                String otp = otpp.toString();
                return otp;
             }
}
