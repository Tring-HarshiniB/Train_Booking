package com.mycompany.train_booking;

import java.util.*;

import com.mycompany.train_booking.admin.Admin;

public class TrainBooking {

    public static void main(String[] args) {
        int ch;
        Scanner sc = new Scanner(System.in);
        Admin a = new Admin();      //creating object for Admin class
        User u = new User();            //creating object for User class
         while (true) {
            System.out.print(" \n\n\t *** TRAIN BOOKING *** ");
            System.out.println(" \n 1. Admin \n 2. User \n 3. Quit");
            System.out.print("Enter your choice : ");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    a.admin();          //calling admin class
                    break;
                case 2:
                    u.user();        //calling user class
                    break;
                case 3:
                    System.exit(0);    //exiting the program
                default:
                    System.out.println(" \n Invalid Choice");
                    break;
            }
        }
    }
}