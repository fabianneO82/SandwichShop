package machine;

import food.Apple;
import food.Sandwich;
import transactions.Payment;

public class Register {

    private static int registerCounter = 0;
    private static final String REGISTERCODE = "US-FL-032020-";
    private static final double DOLLARVALUE = 1.00;
    private static final double QUARTERVALUE = 0.25;
    private static final double DIMEVALUE = 0.10;
    private static final double NICKELVALUE = 0.05;
    private static final double PENNYVALUE = 0.01;

    private String registerID;
    private int numberOfOneDollarBills;
    private int numberOfQuarters;
    private int numberOfDimes;
    private int numberOfNickels;
    private int numberOfPennies;
    private double currentTotal;

    public Register(int numberOfOneDollarBills, int numberOfQuarters, int numberOfDimes, int numberOfNickels, int numberOfPennies){

        registerCounter++;
        registerID = REGISTERCODE + registerCounter;
        this.numberOfOneDollarBills= numberOfOneDollarBills;
        this.numberOfQuarters= numberOfQuarters;
        this.numberOfDimes= numberOfDimes;
        this.numberOfNickels= numberOfNickels;
        this.numberOfPennies= numberOfPennies;

        currentTotal = 0.0;
    }// end of REGISTER

private double cashValue() {
    double total = numberOfOneDollarBills * DOLLARVALUE +
            numberOfQuarters * QUARTERVALUE +
            numberOfDimes * DIMEVALUE +
            numberOfNickels * NICKELVALUE +
            numberOfPennies * PENNYVALUE;

    return total;
}

    public void cashInfo(String personal){
        if(personal.equals("Manager")){
            System.out.println("==========================================");
            System.out.println("Register Cash Info");
            System.out.println("==========================================");
            System.out.println("Access Level:\t\t\t Valid");
            System.out.printf("Cash in the Register:\t $%-15.2f\n", cashValue());
            System.out.printf("Dollars:\t\t\t\t %-15d\n", numberOfOneDollarBills);
            System.out.printf("Quarters:\t\t\t\t %-15d\n", numberOfQuarters);
            System.out.printf("Dimes: \t\t\t\t\t %-15d\n", numberOfDimes);
            System.out.printf("Nickels: \t\t\t\t %-15d\n", numberOfNickels);
            System.out.printf("Pennies: \t\t\t\t %-15d\n", numberOfPennies);
            System.out.println();
        }
        else{
            System.out.println("==========================================");
            System.out.println("Register Cash Info");
            System.out.println("==========================================");
            System.out.println("Access Level:\t\t Not Valid by " + personal);
            System.out.println();

        }


    }// end cashInfo

    public void buyApple(Apple apple, Payment payment) {

        System.out.println("==========================================");
        System.out.println("Register Buy Apple");
        System.out.println("==========================================");
        System.out.printf("Apple Price:\t\t\t\t\t$%-15.2f\n" , apple.price() );
        System.out.printf("Payment:\t\t\t\t\t\t$%-15.2f\n" , payment.paymentValue() );


        if(payment.paymentValue() <apple.price()){
            double shortAmount = apple.price() - payment.paymentValue();

            System.out.printf("You need: \t\t\t\t\t\t$%-15.2f\n",shortAmount );
            System.out.println("");
            System.out.println("Sorry but you do not have enough money to buy the Apple");
            System.out.println("==========================================");
            System.out.println("\n");
        }
        else{
            giveChange(apple.price(), payment);


        }



    } // end buyApple

    public void buySandwich(Sandwich sandwich, Payment payment) {
        System.out.println("==========================================");
        System.out.println("Register Buy Sandwich");
        System.out.println("==========================================");
        System.out.printf("Sandwich Price: \t\t\t $%-15.2f \n", sandwich.getPrice());
        System.out.printf("Payment: \t\t\t\t\t $%-15.2f \n", payment.paymentValue());

        if (payment.paymentValue() < sandwich.getPrice()) {
            double shortAmount = sandwich.getPrice() - payment.paymentValue();
            System.out.printf("You need:\t\t\t\t\t $%-15.2f \n", shortAmount);
            System.out.println("");
            System.out.println("Sorry but you do not have enough money to buy the Sandwich");
            System.out.println("==========================================");
            System.out.println("\n");

        } else {
            giveChange(sandwich.getPrice(), payment);
        }


    }



    private void giveChange(double price, Payment payment){
        numberOfOneDollarBills += payment.getNumberOfOneDollarBills();
        numberOfQuarters += payment.getNumberOfQuarters();
        numberOfDimes += payment.getNumberOfDimes();
        numberOfNickels += payment.getNumberOfNickels();
        numberOfPennies += payment.getNumberOfPennies();

        double neededChange = payment.paymentValue() - price;
        int neededChangeWhole = (int)Math.round(neededChange * 100);
        System.out.printf("Change:\t\t\t\t\t\t\t$%-15.2f\n", neededChange);

        int changeDollars = neededChangeWhole/100;
        neededChangeWhole %= 100;

        int changeQuarter = neededChangeWhole/25;
        neededChangeWhole %= 25;

        int changeDimes = neededChangeWhole/10;
        neededChangeWhole %= 10;

        int changeNickels = neededChangeWhole/5;
        neededChangeWhole %= 5;

        int changePennies = neededChangeWhole;

        numberOfOneDollarBills -= changeDollars;
        numberOfQuarters -= changeQuarter;
        numberOfDimes -= changeDimes;
        numberOfNickels -= changeNickels;
        numberOfPennies -= changePennies;
       System.out.printf("Dollars:\t\t\t\t\t\t%-15d\n", changeDollars);
       System.out.printf("Quarters:\t\t\t\t\t\t%-15d\n", changeQuarter);
       System.out.printf("Dimes:\t\t\t\t\t\t\t%-15d \n", changeDimes);
       System.out.printf("Nickels: \t\t\t\t\t\t%-15d \n", changeNickels);
       System.out.printf("Pennies: \t\t\t\t\t\t%-15d\n", changePennies);
       System.out.println();

    }//end

}// end Register class
