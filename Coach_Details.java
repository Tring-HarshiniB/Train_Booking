package com.mycompany.train_booking.admin;

import java.util.*;

public class Coach_Details extends Train_Details {

    Coach_Details() {
    }

    final static int ROWS = 6;
    final static int SEATS_PER_ROW = 11;
    final static int CABINS = 6;
    final static int MAIN = 2;
    final static int SIDE = 1;
    final static int MIDDLE_PRICE = 1;
    final static int AC_MIDDLE_PRICE = 5;
    final static int OTHER_SEATS_PRICE = 2;
    final static int AC_OTHER_SEATS_PRICE = 6;
    final static int SLEEPER_PRICE = 1;
    final static int AC_SLEEPER_PRICE = 5;

    /*HashMap<String, Integer> chairCar = new HashMap<>();
     HashMap<String, Integer> sleeperClass = new HashMap<>();*/
    static int window = (ROWS * SEATS_PER_ROW) / 3;
    static int middle = (ROWS * SEATS_PER_ROW) / 3;
    static int asile = (ROWS * SEATS_PER_ROW) / 3;
    static int upper = CABINS * MAIN;
    static int mid = CABINS * MAIN;
    static int lower = CABINS * MAIN;
    static int upperSide = CABINS * SIDE;
    static int lowerSide = CABINS * SIDE;
    static int windowPrice, middlePrice, asilePrice;
    static int acWindowPrice, acMiddlePrice, acAsilePrice;
    static int upperPrice, midPrice, lowerPrice, upperSidePrice, lowerSidePrice;
    static int acUpperPrice, acMidPrice, acLowerPrice, acUpperSidePrice, acLowerSidePrice;
    static int chairPrice, acChairPrice, sleeperPrice, acSleeperPrice;
    static int totalCost;

    public static void totalCost(int i) {

        windowPrice = OTHER_SEATS_PRICE * window * train.get(i).totalDistance * coach.get(i).chair;
        middlePrice = MIDDLE_PRICE * middle * train.get(i).totalDistance * coach.get(i).chair;
        asilePrice = OTHER_SEATS_PRICE * asile * train.get(i).totalDistance * coach.get(i).chair;
        chairPrice = windowPrice + middlePrice + asilePrice;

        acWindowPrice = AC_OTHER_SEATS_PRICE * window * train.get(i).totalDistance * coach.get(i).acChair;
        acMiddlePrice = AC_MIDDLE_PRICE * middle * train.get(i).totalDistance * coach.get(i).acChair;
        acAsilePrice = AC_OTHER_SEATS_PRICE * asile * train.get(i).totalDistance * coach.get(i).acChair;
        acChairPrice = acWindowPrice + acMiddlePrice + acAsilePrice;

        upperPrice = SLEEPER_PRICE * upper * train.get(i).totalDistance * coach.get(i).sleeper;
        midPrice = SLEEPER_PRICE * mid * train.get(i).totalDistance * coach.get(i).sleeper;
        lowerPrice = SLEEPER_PRICE * lower * train.get(i).totalDistance * coach.get(i).sleeper;
        upperSidePrice = SLEEPER_PRICE * upperSide * train.get(i).totalDistance * coach.get(i).sleeper;
        lowerSidePrice = SLEEPER_PRICE * lowerSide * train.get(i).totalDistance * coach.get(i).sleeper;
        sleeperPrice = upperPrice + midPrice + lowerPrice + upperSidePrice + lowerSidePrice;

        acUpperPrice = AC_SLEEPER_PRICE * upper * train.get(i).totalDistance * coach.get(i).acSleeper;
        acMidPrice = AC_SLEEPER_PRICE * mid * train.get(i).totalDistance * coach.get(i).acSleeper;
        acLowerPrice = AC_SLEEPER_PRICE * lower * train.get(i).totalDistance * coach.get(i).acSleeper;
        acUpperSidePrice = AC_SLEEPER_PRICE * upperSide * train.get(i).totalDistance * coach.get(i).acSleeper;
        acLowerSidePrice = AC_SLEEPER_PRICE * lowerSide * train.get(i).totalDistance * coach.get(i).acSleeper;
        acSleeperPrice = acUpperPrice + acMidPrice + acLowerPrice + acUpperSidePrice + acLowerSidePrice;

        totalCost = chairPrice + acChairPrice + sleeperPrice + acSleeperPrice;
        System.out.println(" \n Total cost of travel : " + totalCost);

    }

    static int available = 0,booked = 0,totalAvailable,availableChair,availableAcChair,avilableSleeper,availableAcSleeper;
    static String getAvailableTrain;
    
    //show seat report for avilable seats v/s booked seats
    public static void seatReport() {
        System.out.print(" \n Train : ");
        for (int j = 0; j < train.size(); j++) {
            System.out.println(" \n " + (j+1) +". "+ train.get(j).trainName);
        }
        System.out.println(" \n Enter Train name to check Seat Report : ");
        getAvailableTrain = sc.next();
        for (int k = 0; k < train.size(); k++) {
            if (getAvailableTrain.equalsIgnoreCase(train.get(k).trainName)) {
                    availableChair = (window + middle + asile) * coach.get(k).chair;
                    availableAcChair = (window + middle + asile) * coach.get(k).acChair;
                    avilableSleeper = (upper + mid + lower + upperSide + lowerSide) * coach.get(k).sleeper;
                    availableAcSleeper = (upper + mid + lower + upperSide + lowerSide) * coach.get(k).acSleeper;
                    booked = noOfBookedSeats[k];
            }
        }
        totalAvailable = availableChair + availableAcChair + avilableSleeper + availableAcSleeper;
        available = totalAvailable - booked;
        System.out.println(" \n Available Seats : " + available);
        System.out.println(" \n Booked Seats : " + booked);
    }
    
    static String getCostTrain;
    
    //show cost report for total cost v/s revenue received
    public static void costReport(){
        System.out.print(" \n Train : ");
        for (int j = 0; j < train.size(); j++) {
            System.out.println(" \n " + (j+1) +". "+ train.get(j).trainName);
        }
        System.out.println(" \n Enter Train name to check Cost Report : ");
        getCostTrain = sc.next();
        for (int j = 0; j < train.size(); j++) {
            if (getCostTrain.equalsIgnoreCase(train.get(j).trainName)) {
                totalCost(j);
            }
        }
        System.out.println(" \n Revenue Received : " + index);
    }

    static int totalNoOfSeats, noOfSeats, choice = 1, index;
    static int seats[];
    static int noOfBookedSeats[];

    public static void ChairCar(String getTrain,String getCoach) {
        for (int k = 0; k < train.size(); k++) {
            if (getTrain.equalsIgnoreCase(train.get(k).trainName)) {
                if(getCoach.equalsIgnoreCase("CC")){
                    totalNoOfSeats = (window + middle + asile) * coach.get(k).chair;
                }
                else if(getCoach.equalsIgnoreCase("ACC")){
                    totalNoOfSeats = (window + middle + asile) * coach.get(k).acChair;
                }
                index = k;
                seats = new int[totalNoOfSeats];
                for (int j = 0; j < totalNoOfSeats; j++) {
                    seats[j] = 0;          //setting all seats equal to 0 (Empty)
                    noOfBookedSeats[j] = 0;
                }
            }
        }
        System.out.println(" \n Enter no.of seats : ");
        noOfSeats = sc.nextInt();
        int seatNumber = 0;
        for (int i = 0; i < noOfSeats; i++) {
            while (choice != 0) {
                System.out.println(" \n Seat Types : ");
                System.out.println(" \n 1. Window \n 2. Middle \n 3. Asile ");
                System.out.println(" \n Choose " + (i + 1) + " seat preference : ");
                choice = sc.nextInt();
                if (choice == 1) {
                    seatNumber += bookWindow();
                    if (seatNumber == -1) {
                        System.out.println(" \n Sorry...! No Window seat avilable ");
                    } else {
                        System.out.println(" \n Window seat Booked !");
                        break;
                    }
                } else if (choice == 2) {
                    seatNumber += bookMiddle();
                    if (seatNumber == -1) {
                        System.out.println(" \n Sorry...! No Middle seat avilable ");
                    } else {
                        System.out.println(" \n Middle seat Booked !");
                        break;
                    }
                } else if (choice == 3) {
                    seatNumber += bookAsile();
                    if (seatNumber == -1) {
                        System.out.println(" \n Sorry...! No Asile seat avilable ");
                    } else {
                        System.out.println(" \n Asile seat Booked !");
                        break;
                    }
                } else {
                    System.out.println(" \n Invalid Choice ");
                    choice = 0;
                }
                noOfBookedSeats[index] = seatNumber;          
            }
        }
        Food_Menu.bookFoodMenu();
    }
    
    public static int bookWindow(){
        for(int i = 0; i < window; i++){
            if(seats[i] == 0){
                seats[i] = 1;
                return i+1;
            }
        }
        return -1;
    }
    
    public static int bookMiddle(){
        for(int i = 0; i < middle; i++){
            if(seats[i] == 0){
                seats[i] = 1;
                return i+1;
            }
        }
        return -1;
    }
    
    public static int bookAsile(){
        for(int i = 0; i < asile; i++){
            if(seats[i] == 0){
                seats[i] = 1;
                return i+1;
            }
        }
        return -1;
    }

    public static void SleeperClass(String getTrain,String getCoach) {
        for (int k = 0; k < train.size(); k++) {
            if (getTrain.equalsIgnoreCase(train.get(k).trainName)) {
                if(getCoach.equalsIgnoreCase("SC")){
                    totalNoOfSeats = (upper + mid + lower + upperSide + lowerSide) * coach.get(k).sleeper;
                }
                else if(getCoach.equalsIgnoreCase("ASC")){
                    totalNoOfSeats = (upper + mid + lower + upperSide + lowerSide) * coach.get(k).acSleeper;
                }
                seats = new int[totalNoOfSeats];
                for (int j = 0; j < totalNoOfSeats; j++) {
                    seats[j] = 0;          //setting all seats equal to 0 (Empty)
                    noOfBookedSeats[j] = 0;
                }
            }
        }
        System.out.println(" \n Enter no.of seats : ");
        noOfSeats = sc.nextInt();
        int seatNumber = 0;
        for (int i = 0; i < noOfSeats; i++) {
            while (choice != 0) {
                System.out.println(" \n Enter seat preference : ");
                System.out.println(" \n 1. Upper \n 2. Middle \n 3. Lower \n 4. Side Upper \n 5. Side Lower ");
                choice = sc.nextInt();
                if (choice == 1) {
                    seatNumber += bookUpper();
                    if (seatNumber == -1) {
                        System.out.println(" \n Sorry...! No Upper seat avilable ");
                    } else {
                        System.out.println(" \n Upper seat Booked !");
                        break;
                    }
                } else if (choice == 2) {
                    seatNumber += bookMid();
                    if (seatNumber == -1) {
                        System.out.println(" \n Sorry...! No Middle seat avilable ");
                    } else {
                        System.out.println(" \n Middle seat Booked !");
                        break;
                    }
                } else if (choice == 3) {
                    seatNumber += bookLower();
                    if (seatNumber == -1) {
                        System.out.println(" \n Sorry...! No Lower seat avilable ");
                    } else {
                        System.out.println(" \n Lower seat Booked !");
                        break;
                    }
                } else if (choice == 4) {
                    seatNumber += bookUpperSide();
                    if (seatNumber == -1) {
                        System.out.println(" \n Sorry...! No Side Upper seat avilable ");
                    } else {
                        System.out.println(" \n Side Upper seat Booked !");
                        break;
                    }
                }else if (choice == 5) {
                    seatNumber += bookLowerSide();
                    if (seatNumber == -1) {
                        System.out.println(" \n Sorry...! No Side Lower seat avilable ");
                    } else {
                        System.out.println(" \n Side Lower seat Booked !");
                        break;
                    }
                }else {
                    System.out.println(" \n Invalid Choice ");
                    choice = 0;
                }
                noOfBookedSeats[index] = seatNumber;
            }
        }
        Food_Menu.bookFoodMenu();
    }
    
    public static int bookUpper(){
        for(int i = 0; i < upper; i++){
            if(seats[i] == 0){
                seats[i] = 1;
                return i+1;
            }
        }
        return -1;
    }
    
    public static int bookMid(){
        for(int i = 0; i < mid; i++){
            if(seats[i] == 0){
                seats[i] = 1;
                return i+1;
            }
        }
        return -1;
    }
    
    public static int bookLower(){
        for(int i = 0; i < lower; i++){
            if(seats[i] == 0){
                seats[i] = 1;
                return i+1;
            }
        }
        return -1;
    }
    
    public static int bookUpperSide(){
        for(int i = 0; i < upperSide; i++){
            if(seats[i] == 0){
                seats[i] = 1;
                return i+1;
            }
        }
        return -1;
    }
    
    public static int bookLowerSide(){
        for(int i = 0; i < lowerSide; i++){
            if(seats[i] == 0){
                seats[i] = 1;
                return i+1;
            }
        }
        return -1;
    }
}