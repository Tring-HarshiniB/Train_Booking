package com.mycompany.train_booking.admin;

import java.util.*;

class Train {

    String trainName, startLocation, endLocation;
    double startingTime, endingTime;
    int totalDistance;

    Train(String trainName, String startLocation, String endLocation, double startingTime, double endingTime, int totalDistance) {
        this.trainName = trainName;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.totalDistance = totalDistance;
    }

    @Override
    public String toString() {
        return " \n\t Train Details \n " + " \n Name : " + trainName + " \n Starting Location :  " + startLocation
                + " \n Ending Location :  " + endLocation + " \n Starting Time : " + String.format("%.2f", startingTime)
                + " \n Ending Time : " + String.format("%.2f", endingTime) + " \n Total Distance : " + totalDistance;
    }

}

class Coaches {

    int chair, acChair, sleeper, acSleeper;

    Coaches(int chair, int acChair, int sleeper, int acSleeper) {
        this.chair = chair;
        this.acChair = acChair;
        this.sleeper = sleeper;
        this.acSleeper = acSleeper;
    }

    @Override
    public String toString() {
        return " \n\t Coaches " + " \n Chair car : " + chair + " \n AC Chair car :  " + acChair
                + " \n Sleeper Class :  " + sleeper + " \n AC Sleeper Class : " + acSleeper;
    }

}

public class TrainDetails {

    String trainName, startLocation, endLocation;
    double startingTime, endingTime;
    int totalDistance;
    int chair, acChair, sleeper, acSleeper;
    int count = 0;

    static ArrayList<Train> train = new ArrayList<>();          //ArrayList for train details
    static ArrayList<Coaches> coach = new ArrayList<>();    //ArrayList for coach details
    static Scanner sc = new Scanner(System.in);

    public void addTrain() {
        System.out.println(" \n ADD TRAIN ");
        System.out.print(" \n Train Name : ");
        trainName = sc.next();
        System.out.print(" \n Source Location : ");
        startLocation = sc.next();
        System.out.print(" \n Destionation Location : ");
        endLocation = sc.next();
        System.out.print(" \n Start Time (0:00 - 24:00) : ");
        startingTime = sc.nextDouble();
        System.out.print(" \n End Time (0:00 - 24:00) : ");
        endingTime = sc.nextDouble();
        System.out.print(" \n Total Distance : ");
        totalDistance = sc.nextInt();
        System.out.print(" \n Enter no.of coaches according to coach name  ");
        System.out.print(" \n Chair car : ");
        chair = sc.nextInt();
        System.out.print(" \n Ac Chair car : ");
        acChair = sc.nextInt();
        System.out.print(" \n Sleeper Class : ");
        sleeper = sc.nextInt();
        System.out.print(" \n AC Sleeper Class : ");
        acSleeper = sc.nextInt();
        train.add(new Train(trainName, startLocation, endLocation, startingTime, endingTime, totalDistance));
        coach.add(new Coaches(chair, acChair, sleeper, acSleeper));
        CoachDetails.totalCost(count);
        count++;
    }

    String startLoc, endLoc;
    
    public void browseTrains() {
        System.out.println(" \n BROWSE TRAIN ");
        System.out.print(" \n Enter Start Location : ");
        startLoc = sc.next();
        System.out.print(" \n Enter End Location : ");
        endLoc = sc.next();

        for (int j = 0; j < train.size(); j++) {
            if (startLoc.equalsIgnoreCase(train.get(j).startLocation) && endLoc.equalsIgnoreCase(train.get(j).endLocation)) {
                System.out.println(train.get(j));
                System.out.println(coach.get(j));
            } else if (!startLoc.equalsIgnoreCase(train.get(j).startLocation) && !endLoc.equalsIgnoreCase(train.get(j).endLocation)) {
                System.out.println(" \n Sorry..... no train available for specified location ! ");
                return;
            } else {
                return;
            }
        }
        seatPreference();
    }

    static String ch, getTrain, getCoach;

    public void seatPreference() {
        do {
            System.out.print(" \n Do you want to book train (y/n) : ");
            ch = sc.next();
            if (ch.equals("y")) {
                System.out.print(" \n Enter Train name : ");
                getTrain = sc.next();
                for (int k = 0; k < train.size(); k++) {
                    if (getTrain.equalsIgnoreCase(train.get(k).trainName)) {
                        System.out.println(" \n Coaches : \n Chair car - CC \n Ac Chair car - ACC \n Sleeper Class - SC \n Ac Sleeper Class - ASC");
                        System.out.print(" \n Enter Coach(code) : ");
                        getCoach = sc.next();
                        if (getCoach.equalsIgnoreCase("CC")) {
                            CoachDetails.coach(getTrain,getCoach);
                        } else if (getCoach.equalsIgnoreCase("ACC")) {
                            CoachDetails.coach(getTrain,getCoach);
                        } else if (getCoach.equalsIgnoreCase("SC")) {
                            CoachDetails.coach(getTrain,getCoach);
                        } else if (getCoach.equalsIgnoreCase("ASC")) {
                            CoachDetails.coach(getTrain,getCoach);
                        } else {
                            return;
                        }
                    } else if (!getTrain.equalsIgnoreCase(train.get(k).trainName)) {
                        System.out.println(" \n There is no Train with this specified name.......");
                    } else {
                        return;
                    }
                }
            } else {
                return;
            }
        } while (ch.equalsIgnoreCase("y"));
    }
}