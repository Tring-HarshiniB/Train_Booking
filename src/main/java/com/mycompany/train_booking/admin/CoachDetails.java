package com.mycompany.train_booking.admin;

public class CoachDetails extends TrainDetails {

    static final int ROWS = 6;
    static final int SEATS_PER_ROW = 11;
    static final int CABINS = 6;
    static final int MAIN = 2;
    static final int SIDE = 1;
    static final int MIDDLE_PRICE = 1;
    static final int AC_MIDDLE_PRICE = 5;
    static final int OTHER_SEATS_PRICE = 2;
    static final int AC_OTHER_SEATS_PRICE = 6;
    static final int SLEEPER_PRICE = 1;
    static final int AC_SLEEPER_PRICE = 5;

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

    static int available = 0, booked = 0, totalAvailable, availableChair, availableAcChair, avilableSleeper, availableAcSleeper;
    static String getAvailableTrain;

    //show seat report for avilable seats v/s booked seats
    public static void seatReport() {
        System.out.print(" \n Train : ");
        for (int j = 0; j < train.size(); j++) {
            System.out.print(" \n " + (j + 1) + ". " + train.get(j).trainName);
        }
        System.out.print(" \n Enter Train name to check Seat Report : ");
        getAvailableTrain = sc.next();
        noOfBookedSeats = new int[train.size()];
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

    static String getTrainCost;

    //show cost report for total cost v/s revenue received
    public static void costReport() {
        System.out.print(" \n Train : ");
        for (int j = 0; j < train.size(); j++) {
            System.out.println(" \n " + (j + 1) + ". " + train.get(j).trainName);
        }
        System.out.print(" \n Enter Train name to check Cost Report : ");
        getTrainCost = sc.next();
        for (int j = 0; j < train.size(); j++) {
            if (getTrainCost.equalsIgnoreCase(train.get(j).trainName)) {
                totalCost(j);
            }
        }
        //System.out.println(" \n Revenue Received : " + index);
    }

    static int totalNoOfSeats, noOfSeats, choice = 1, index;
    static int seats[];
    static int noOfBookedSeats[];

    public static void coach(String getTrain, String getCoach){
        for (int k = 0; k < train.size(); k++) {
            if (getTrain.equalsIgnoreCase(train.get(k).trainName)) {
                if (getCoach.equalsIgnoreCase("CC")) {
                    totalNoOfSeats = (window + middle + asile) * coach.get(k).chair;
                } else if (getCoach.equalsIgnoreCase("ACC")) {
                    totalNoOfSeats = (window + middle + asile) * coach.get(k).acChair;
                }else if (getCoach.equalsIgnoreCase("SC")) {
                    totalNoOfSeats = (upper + mid + lower + upperSide + lowerSide) * coach.get(k).sleeper;
                } else if (getCoach.equalsIgnoreCase("ASC")) {
                    totalNoOfSeats = (upper + mid + lower + upperSide + lowerSide) * coach.get(k).acSleeper;
                }
                index = k;
                seats = new int[totalNoOfSeats];
                for (int j = 0; j < totalNoOfSeats; j++) {
                    seats[j] = 0;          //setting all seats equal to 0 (Empty)  
                }
                noOfBookedSeats = new int[train.size()];
                for (int i = 0; i < train.size(); i++) {
                    noOfBookedSeats[i] = 0;
                }
                if (getCoach.equalsIgnoreCase("CC") || getCoach.equalsIgnoreCase("ACC")) {
                    chairCar(k);
                }else if(getCoach.equalsIgnoreCase("SC") || getCoach.equalsIgnoreCase("ASC")){
                    sleeperClass(k);
                }
            }
        }
    }
    
    public static void chairCar(int index) {
        System.out.print(" \n Enter no.of seats : ");
        noOfSeats = sc.nextInt();
        int seatNumber = 0;
        for (int i = 0; i < noOfSeats; i++) {
            while (choice != 0) {
                System.out.println(" \n Seat Types : ");
                System.out.println(" \n 1. Window \n 2. Middle \n 3. Asile ");
                System.out.print(" \n Choose " + (i + 1) + " seat preference : ");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        seatNumber += bookSeats(window);
                        if (seatNumber == -1) {
                            System.out.println(" \n Sorry...! No Window seat avilable ");
                        } else {
                            System.out.println(" \n Window seat Booked !");
                            break;
                        }
                    case 2:
                        seatNumber += bookSeats(middle);
                        if (seatNumber == -1) {
                            System.out.println(" \n Sorry...! No Middle seat avilable ");
                        } else {
                            System.out.println(" \n Middle seat Booked !");
                            break;
                        }
                    case 3:
                        seatNumber += bookSeats(asile);
                        if (seatNumber == -1) {
                            System.out.println(" \n Sorry...! No Asile seat avilable ");
                        } else {
                            System.out.println(" \n Asile seat Booked !");
                            break;
                        }
                    default: {
                        System.out.println(" \n Invalid Choice ");
                        choice = 0;
                    }
                    noOfBookedSeats[index] = seatNumber;
                }
            }
        }
        FoodMenu.bookFoodMenu();
    }

    public static void sleeperClass(int index) {
        System.out.print(" \n Enter no.of seats : ");
        noOfSeats = sc.nextInt();
        int seatNumber = 0;
        for (int i = 0; i < noOfSeats; i++) {
            while (choice != 0) {
                System.out.println(" \n Seat Types : ");
                System.out.println(" \n 1. Upper \n 2. Middle \n 3. Lower \n 4. Side Upper \n 5. Side Lower ");
                System.out.print(" \n Choose " + (i + 1) + " seat preference : ");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        seatNumber += bookSeats(upper);
                        if (seatNumber == -1) {
                            System.out.println(" \n Sorry...! No Upper seat avilable ");
                        } else {
                            System.out.println(" \n Upper seat Booked !");
                            break;
                        }
                    case 2:
                        seatNumber += bookSeats(mid);
                        if (seatNumber == -1) {
                            System.out.println(" \n Sorry...! No Middle seat avilable ");
                        } else {
                            System.out.println(" \n Middle seat Booked !");
                            break;
                        }
                    case 3:
                        seatNumber += bookSeats(lower);
                        if (seatNumber == -1) {
                            System.out.println(" \n Sorry...! No Lower seat avilable ");
                        } else {
                            System.out.println(" \n Lower seat Booked !");
                            break;
                        }
                    case 4:
                        seatNumber += bookSeats(upperSide);
                        if (seatNumber == -1) {
                            System.out.println(" \n Sorry...! No Side Upper seat avilable ");
                        } else {
                            System.out.println(" \n Side Upper seat Booked !");
                            break;
                        }
                    case 5:
                        seatNumber += bookSeats(lowerSide);
                        if (seatNumber == -1) {
                            System.out.println(" \n Sorry...! No Side Lower seat avilable ");
                        } else {
                            System.out.println(" \n Side Lower seat Booked !");
                            break;
                        }
                    default: {
                        System.out.println(" \n Invalid Choice ");
                        choice = 0;
                    }
                    noOfBookedSeats[index] = seatNumber;
                }
            }
        }
        FoodMenu.bookFoodMenu();
    }

    public static int bookSeats(int seatType) {
        for (int i = 0; i < seatType; i++) {
            if (seats[i] == 0) {
                seats[i] = 1;
                return i + 1;
            }
        }
        return -1;
    }
}