/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodapp;

import java.util.*;

/**
 *
 * @author TohZJ
 */
public class CheckFields {

    public static List<String> checkIsEmpty(String name, String price) {
        List<String> errorMsg = new ArrayList<>();
        name = name.trim();
        price = price.trim();
        if (name == null || name.isEmpty()) {
            errorMsg.add("Name must not be empty");
        }
        if (price == null || price.isEmpty()) {
            errorMsg.add("Price must not be empty");
        }
        try {
            Double.parseDouble(price);
        } catch (IllegalArgumentException e) {
            errorMsg.add("Please enter a valid price");
        }
        return errorMsg;
    }
    
    public static List<String> passwordChecker(String user, String pass) {
        List<String> errorMsg = new ArrayList<>();
        if (user == null || user.isEmpty()) {
            errorMsg.add("User empty");
        }
        if (pass == null || pass.isEmpty()) {
            errorMsg.add("Password empty");
        }
        
        return errorMsg;
    }

}
