package com.mycompany.train_booking.admin;

import java.util.*;

public class Admin {
    private static final String NAME = "harshini";  //defined admin name 
    private static final String PASS = "trainpass";   //defined admin password
    int ch1;
    String aName,aPass;
    Scanner sc = new Scanner(System.in);
    TrainDetails td = new TrainDetails();     //creating object for Train_Details class
    FoodMenu fm = new FoodMenu();       //creating object for Food_Menu class
    
    //admin Sign in
    public void admin() {
        System.out.println(" \n \t ADMIN ");
        System.out.println(" \n SIGN IN ");
        System.out.print(" \n Admin Name : ");
        aName = sc.next();
        System.out.print(" \n Password : ");
        aPass = sc.next();
        if(aName.equals(NAME) && aPass.equals(PASS)){
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
                    CoachDetails.seatReport();    //calling seatReport method
                    break;
                case 4:
                    CoachDetails.costReport();   //calling costReport method
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