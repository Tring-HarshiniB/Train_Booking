package com.mycompany.train_booking;

import java.util.*;
//import com.mycompany.train_booking.admin.Admin;
import com.mycompany.train_booking.admin.Train_Details;
import com.mycompany.train_booking.admin.Food_Menu;

public class User{

    int ch1, ch2;
    String name, pass, repass;
    String uname,upass;
    Scanner sc = new Scanner(System.in);
    Train_Details td2 = new Train_Details();    //creating object for Train_Details class
    Food_Menu fm2 = new Food_Menu();      //creating object for Food_Menu class
    
    public void user() {
        while (true) {
            System.out.println(" \n \t USER ");
            System.out.println(" \t ***** ");
            System.out.println(" \n 1. Sign Up \n 2. Sign In \n 3. Exit ");
            System.out.print(" Enter your choice : ");
            ch1 = sc.nextInt();
            switch (ch1) {
                case 1:
                    signUp();       //calling signUp method
                    break;
                case 2:
                    signIn();        //calling signIn method
                    break;
                case 3:
                    return;          //return to Train_Booking class
                default:
                    System.out.println(" \n Invalid Choice ");
                    break;
            }
        }
    }

    //Sign up to create new user account
    public void signUp() {
        System.out.println(" \n \t SIGN UP ");
        System.out.println(" \t ***** ** ");
        System.out.print(" \n Enter User Name : ");
        name = sc.next();
        System.out.print(" \n Enter Password(only characters) : ");
        pass = sc.next();
        System.out.print(" \n Re-Enter Password : ");
        repass = sc.next();
        if (pass.equals(repass)) {
            System.out.println(" \n Account Created ");
        } else {
            System.out.println(" \n Password Mismatch ");
        }
        return;
    }

    //Sign in for already registered user
    public void signIn() {
        System.out.println(" \n \t SIGN IN ");
        System.out.println(" \t ***** ** ");
        System.out.print(" \n User Name : ");
        uname = sc.next();
        System.out.print(" \n Password : ");
        upass = sc.next();
        if(uname.equals(name) && upass.equals(pass)){
            System.out.println(" \n Welcome " + uname);
        }
        else{
            System.out.println(" \n Not a Registered User");
            return;
        }
        while (true) {
            System.out.println(" \n Options for Train Booking ");
            System.out.println(" 1. Browse Trains \n 2. Choose Food Menu  \n 3. Log Out");
            System.out.print(" Enter your choice : ");
            ch2 = sc.nextInt();
            switch (ch2) {
                case 1:
                    td2.browseTrains();     //calling browseTrain method
                    break;
                case 2:
                    fm2.bookFoodMenu();     //calling foodMenu method
                    break;
                case 3:
                    return;
                default:
                    System.out.println(" \n Invalid Choice ");
                    break;
            }
        }
    }
    
    
}