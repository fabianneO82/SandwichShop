
package app;

import food.Apple;
import food.Sandwich;
import machine.Register;
import transactions.Payment;

public class Controller {

    public static void main(String[] args){


        Register register = new Register(15,20,10,20,50);
        register.cashInfo("Manager");


        register.cashInfo("Staff");

        Apple grannySmith = new Apple("Granny Smith", 1.51, 140);
        grannySmith.displayInfo();

        Payment applePayment1 = new Payment(10, 0,0,0,47);
        applePayment1.displayInfo();


        register.buyApple(grannySmith, applePayment1);


        Apple macintosh = new Apple("Macintosh", 1.70, 150);
        macintosh.displayInfo();

        Payment applePayment2 = new Payment(0, 2, 0, 0, 0);
        applePayment2.displayInfo();


        register.buyApple(macintosh, applePayment2);

        register.cashInfo("Manager");


        Sandwich sandwich = new Sandwich(true, true,true );
         sandwich.displayInfo();


        Payment sandwichPayment1 = new Payment(5,2,1,1,2);
        sandwichPayment1.displayInfo();

        register.buySandwich(sandwich, sandwichPayment1);

        register.cashInfo("Manager");

        boolean meat = true;
        boolean cheese = true;
        boolean veggies = true;
        System.out.println("");

        for(int i =1; i<=8; i++) {
            if (i <= 4) {
                meat = true;

            } else {
                meat = false;
            }
            if (i == 1 || i == 2 || i == 6) {
                cheese = true;
            } else {
                cheese = false;
            }
            if (i % 2 == 0) {
                veggies = false;
            } else {
                veggies = true;
            }
        }// end for loop

        Sandwich s = new Sandwich(meat,cheese, veggies);
        Payment sanwichCombos = new Payment(10,0,0,0,0);

        System.out.println("=========================================");
        System.out.println("=========================================");
        s.displayInfo();
        sanwichCombos.displayInfo();
        register.buySandwich(s, sanwichCombos);
        register.cashInfo("Manager");
        System.out.println("=========================================");
        System.out.println("=========================================");








    }// end Main




}// end Controller class
