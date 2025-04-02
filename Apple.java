package food;

public class Apple {

 private String type;
 private double weight;
 private double pricePerUnitWeight;

    public Apple(String type, double pricePerUnitWeight, double weightInGrams) {

        weight = 0.00220 * weightInGrams;
        this.type = type;
        this.pricePerUnitWeight = pricePerUnitWeight;
    }

    public String getType(){
        return type;
    }

    public double getWeight(){
        return weight;
    }

    public double getPricePerUnitWeight(){
        return pricePerUnitWeight;
    }


    public void setPricePerUnitWeight(double pricePerUnitWeight, String personal){
            this.pricePerUnitWeight= pricePerUnitWeight;




    }//


    public void displayInfo(){
        System.out.println("==========================================");
        System.out.println("Apple Info");
        System.out.println("==========================================");
        System.out.printf("Type:\t\t\t\t %-15s\n", type);
        System.out.printf("Weight:\t\t\t\t %-6.4f lbs\n", weight);
        System.out.printf("Price Per Unit:\t\t %-10.2f\n", pricePerUnitWeight);
        System.out.printf("Price:\t\t\t\t $%-6.2f \n", price());
        System.out.println();
    }
    public double price(){
        double price = weight * pricePerUnitWeight;
        return price;
    }
}// end Apple class
