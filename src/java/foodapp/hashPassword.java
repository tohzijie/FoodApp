/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodapp;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 *
 * @author TohZJ
 */
public class hashPassword {
    public static String hashPass(String password){
        try {
           String toReturn = Base64.getEncoder().encodeToString(password.getBytes("utf-8"));
           return toReturn;
        } 
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }
}
