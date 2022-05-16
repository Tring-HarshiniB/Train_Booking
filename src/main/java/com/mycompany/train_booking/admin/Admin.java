package com.mycompany.train_booking.admin;

import java.util.*;

public class Admin {
    private static final String name = "harshini";  //defined admin name 
    private static final String pass = "trainpass";   //defined admin password
    int ch1;
    String aName,aPass;
    Scanner sc = new Scanner(System.in);
    Train_Details td = new Train_Details();     //creating object for Train_Details class
    Food_Menu fm = new Food_Menu();       //creating object for Food_Menu class
    Coach_Details cd = new Coach_Details();
    
    //admin Sign in
    public void admin() {
        System.out.println(" \n \t ADMIN ");
        System.out.println(" \t ******* ");
        System.out.println(" \n SIGN IN ");
        System.out.print(" \n Admin Name : ");
        aName = sc.next();
        System.out.print(" \n Password : ");
        aPass = sc.next();
        if(aName.equals(name) && aPass.equals(pass)){
            System.out.println(" \n Welcome " + aName);     //if condition true continues
        }
        else{
            System.out.print(" \n Invalid Admin Name or Password ");
            return;     //if condition is false return to Train_Booking class
        }
        while (true) {
            System.out.println(" \n 1. Add Train \n 2. Create a menu \n 3. Show Seat Report \n 4. Show Cost Report \n 5. Log out");
            System.out.print(" Enter your choice : ");
            ch1 = sc.nextInt();
            switch (ch1) {
                case 1:
                    td.addTrain();      //calling addTrain method
                    break;
                case 2:
                    fm.createMenu();    //calling creaateMenu method
                    break;
                case 3:
                    cd.seatReport();    //calling seatReport method
                    break;
                case 4:
                    cd.costReport();   //calling costReport method
                    break;
                case 5:
                    return;     //return to Train_Booking class
                default:
                    System.out.println(" \n Invalid Choice ");
                    break;
            }
        }
    }
}