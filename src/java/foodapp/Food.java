package foodapp;
import java.util.*;

public class Food{
    private int fid;
    private String fname;
    private int status;
    private double price;
    public Food(int fid, String fname, int status, double price){
        this.fid = fid;
        this.fname = fname;
        this.status = status;
        this.price = price;
    }
    
    public int getFid(){
        return fid;
    }
    
    public String getFname(){
        return fname;
    }
    public int getStatus(){
        return status;
    }
    public String getStatusString(){
        if(status == 0){
            return "Available";
        }
        return "Out of Stock";
    }
    
    public double getPrice(){
        return price;
    }
    
    public void setFname(String fname){
        this.fname = fname;
    }
    
    public void setPrice(double price){
        this.price = price;
    }


}