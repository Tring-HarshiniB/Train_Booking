package com.mycompany.train_booking.admin;

import java.util.*;

public class Food_Menu extends Train_Details{

    int ch2;
    String name;
    int price;
    double from;
    double till;
    
    public Food_Menu(){}

    Food_Menu(String name, int price, double from, double till) {
        this.name = name;
        this.price = price;
        this.from = from;
        this.till = till;
    }              

    @Override
    public String toString() {
        return " \n\t Food Menu \n " + " \n Name : " + name + " \n Price :  " + price + " \n Available Time :  "
                + String.format("%.2f", from) + " - " + String.format("%.2f", till);
    } 
    
    static ArrayList<Food_Menu> breakFast = new ArrayList<>();
    static ArrayList<Food_Menu> lunch = new ArrayList<>();
    static ArrayList<Food_Menu> dinner = new ArrayList<>();

    public void createMenu() {
        while (true) {
            System.out.println(" \n Create Menu for.....");
            System.out.println(" 1. Breakfast \n 2. Lunch \n 3. Dinner \n 4. Exit");
            System.out.print(" Enter your choice : ");
            ch2 = sc.nextInt();
            switch (ch2) {
                case 1:
                    breakfast();
                    break;
                case 2:
                    lunch();
                    break;
                case 3:
                    dinner();
                    break;
                case 4:
                    return;
                default:
                    System.out.println(" \n Invalid Choice ");
                    break;
            }
        }
    }

    public void breakfast() {
        System.out.print(" \n Food Name : ");
        name = sc.next();
        System.out.print(" \n Price : ");
        price = sc.nextInt();
        System.out.println(" \n Breakfast Time (7.00 - 10.00) ");
        System.out.print(" \n Availabe From : ");
        from = sc.nextDouble();
        System.out.print(" \n Availabe Till : ");
        till = sc.nextDouble();
        breakFast.add(new Food_Menu(name, price, from, till));
    }

    public void lunch() {
        System.out.print(" \n Food Name : ");
        name = sc.next();
        System.out.print(" \n Price : ");
        price = sc.nextInt();
        System.out.println(" \n Lunch Time (12.00 - 15.00) ");
        System.out.print(" \n Availabe From : ");
        from = sc.nextDouble();
        System.out.print(" \n Availabe Till : ");
        till = sc.nextDouble();
        lunch.add(new Food_Menu(name, price, from, till));
    }

    public void dinner() {
        System.out.print(" \n Food Name : ");
        name = sc.next();
        System.out.print(" \n Price : ");
        price = sc.nextInt();
        System.out.print(" \n Dinner Time (19.00 - 22.00) ");
        System.out.print(" \n Availabe From : ");
        from = sc.nextDouble();
        System.out.print(" \n Availabe Till : ");
        till = sc.nextDouble();
        dinner.add(new Food_Menu(name, price, from, till));
    }

    static double getFrom,getTill,getTime;
    public static void bookFoodMenu() {
        for (int k = 0; k < train.size(); k++) {
            if (getTrain.equalsIgnoreCase(train.get(k).trainName)) {
                getFrom = train.get(k).startingTime;
                getTill = train.get(k).endingTime;
            }
        }
        if(getFrom < 22.00 && getTill > 7.00){
            System.out.println(" Sorry.....! No food available at mid night....");
            return;
        }
        System.out.println(" \n Enter a time(00.00 - 24.00) from " + String.format("%.2f",getFrom) + " to " + String.format("%.2f",getTill) + " : ");
        getTime = sc.nextDouble();
        for(int i = 0, j = 0, k = 0; i < breakFast.size() || j < lunch.size() || k < dinner.size(); i++, j++, k++){
            if(getTime >= 7.00 && getTime <= 10.00){
                if (getTime >= breakFast.get(i).from || getTime <= breakFast.get(i).till) {
                    System.out.println(breakFast.get(i));
                }
                if(getTime >= 12.00 && getTime <= 15.00){
                    if (getTime >= lunch.get(i).from || getTime <= lunch.get(i).till) {
                        System.out.println(lunch.get(j));
                    }
                    if(getTime >= 19.00 && getTime <= 22.00){
                        if (getTime >= dinner.get(i).from || getTime <= dinner.get(i).till) {
                           System.out.println(dinner.get(k));
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
    }
}