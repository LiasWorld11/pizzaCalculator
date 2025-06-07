package pizzaCalculator;

import java.util.Scanner;

class Pizza{
    private int code;       //Unique identifier for the pizza 
    private String name;    //Name of the pizza 
    private int slices;     //Number of slices in the pizza 
    private double prices;  //Price of the pizza 
    
    //overloaded constructor to initialize pizza attributes 
    public Pizza(int code,String name,int slices, double prices){
        this.code = code;       
        this.name = name;
        this.slices = slices;
        this.prices = prices;   
    }
    
    //Copy constructor to create a new Pizza object from an existing one  
    public Pizza(Pizza p){
        code = p.getCode();
        name = p.getName();
        slices = p.getSlices();
        prices = p.prices;  
    }
    
    //Getter methods to access private attributes  
    public int getCode(){return code;}
    public String getName(){return name;}
    public int getSlices(){return slices;}
    public double getPrices(){return prices;}
    
    //Setter methods to modify private attributes 
    public void setCode(int code){this.code = code;}
    public void setName(String name){this.name = name;}
    public void setSlices (int slices){this.slices = slices;}
    public void setPrices (double prices){this.prices = prices;}
    
    //Method to print Pizza details in a formated manner 
    public void printPizza(){
        System.out.printf("%-7d %-23s %-15d RM %-15.2f\n", code, name, slices, prices);
    }
}
        
public class pizzaCalculator {
    public static void main(String args[]){
        
        Scanner sc = new Scanner(System.in); //Read input from user 
        char toExit;                         //Variable to determine if the user wants to exit the loop 

        do{    
            int numPeople = 0;          //Number of people initialized to 0 
            String hungerLevel = "";    //Hunger level initialized to an empty string 

            //Loop until a valid number of people is entered
            while(numPeople <= 0) {
            System.out.print("Enter the number of people: ");
                //Check if the next input is an integer
                while(!sc.hasNextInt()) {
                    System.out.println("-------------Invalid Input-------------");
                    System.out.println("Please enter a valid integer.");
                    sc.next();          // Consume the invalid input to avoid an infinite loop 
                    System.out.print("Enter the number of people: ");
                }
            //Read the valid integer input for the number of people
            numPeople = sc.nextInt();
            //Check if the entered number of people is still invalid(less than or equal to 0)
            if (numPeople <= 0) {
                //Display error message indicating the number must be greater than 0
                System.out.println("-------------Invalid Input-------------");
                System.out.println("Number of people must be greater than 0.");
                System.out.println();  
            }
        }
        System.out.print("Enter the hunger level [Light / Medium / Ravenous] : ");
        sc.nextLine();              // Clear buffer
        hungerLevel = sc.next().toLowerCase(); //User input the hunger level
        
        //Validate the hunger level input 
        while (!hungerLevel.equals("light") && !hungerLevel.equals("medium") && !hungerLevel.equals("ravenous")){
            System.out.println("-------------Invalid Input-------------");
            System.out.print("Enter the hunger level [Light / Medium / Ravenous] : ");
            sc.nextLine();  
            hungerLevel = sc.next().toLowerCase(); 
        }
    
        System.out.println();
        
        //Display the pizza menu 
        pizzaMenu(); 
        
        //Get the total cost
        double totalCost = getPizzaSlice(numPeople, hungerLevel, sc);
        printDashes(60);
        //Print the total cost directly after pizza selection
        System.out.printf("Total cost   : RM %.2f\n", totalCost);
        printDashes(60);
        
        //Prompt user to exit looping 
        System.out.print("Enter [Y/N] to CONTINUE : ");
        toExit = sc.next().charAt(0);
        System.out.println();
        
        //validate the choice to exit input 
        while(toExit != 'Y' && toExit != 'y' && toExit !='N' && toExit !='n'){
            System.out.println("-------------Invalid Input-------------");
            System.out.print("Enter [Y/N] to CONTINUE : ");
            toExit = sc.next().charAt(0);
            System.out.println();
        }
        
        }while(toExit != 'N' && toExit != 'n');  
    }
    
    public static void pizzaMenu(){
        
        printDashes(60);
        System.out.println("\t\t\tBobby Pizza Shop");
        printDashes(60);
        System.out.printf("%-7s %-23s %-15s %-15s\n", "Code", "Names", "No. of slices", "Price");
        printDashes(60);
        
        //Create pizza objects with their respective details 
        Pizza p1 = new Pizza(1, "World Pizza", 12, 55.80);
        Pizza p2 = new Pizza(2, "Chickensaurus", 12, 53.80);
        Pizza p3 = new Pizza(3, "Meatasaurus", 12, 53.80);
        Pizza p4 = new Pizza(4, "Prawn Sensation", 10, 43.80);
        Pizza p5 = new Pizza(5, "Signature Quattro", 10, 41.80);
        Pizza p6 = new Pizza(6, "Beef Peperoni", 10, 35.90);
        Pizza p7 = new Pizza(7, "Aloha Chicken", 8, 35.90);
        Pizza p8 = new Pizza(8, "Flaming Tuna", 8, 35.90);
        Pizza p9 = new Pizza(9, "Vegie Fiesta", 8, 35.90);
        Pizza p10 = new Pizza(10, "Vegie Galore", 8, 35.90);
        
        //Print each pizza's details 
        p1.printPizza();
        p2.printPizza();
        p3.printPizza();
        p4.printPizza();
        p5.printPizza();
        p6.printPizza();
        p7.printPizza();
        p8.printPizza();
        p9.printPizza();
        p10.printPizza();
        
        printDashes(60);
    }
    
    public static double getPizzaSlice(int numPeople, String hungerLevel, Scanner sc) {
        
        int sliceLevel = getHungerLevel(hungerLevel);    //Get slice level based on hunger 
        int numSlice = numPeople * sliceLevel;          //Calculate total slices needed
        
        int totalSlices = 0;    //Total slices collected 
        double totalCost = 0;   //Total cost of selected pizzas

        int i = 1;  //Counter for pizza selection 
        
        System.out.printf("Needed Slices are: %d slices\n", numSlice);
        System.out.println();
        
        do{
            System.out.print("Enter the pizza code [1-10] for pizza " + i + " : ");
            int code = sc.nextInt();    //User input pizza code 

            Pizza selectedPizza = getPizzaByCode(code);     //Get pizza by code 
            if(selectedPizza != null){
                
                int slices = selectedPizza.getSlices();     //Get number of slices 
                double cost = selectedPizza.getPrices();    //Get price of pizza
                totalSlices += slices;                      //Update total slices 
                totalCost += cost;                          //Update total cost 
                
                //Print details of the selected pizza 
                System.out.printf("Pizza %d: \n%s, %d slices, RM %.2f\n", i, selectedPizza.getName(), slices, cost);
                System.out.println("Total Slices: " + totalSlices);
                System.out.println();
                i++;    //Increment only for valid pizzas
                
            } else{
                System.out.println("Invalid pizza code. Please try again.");
            }
            
        }while (totalSlices < numSlice);   //Continue until enough slices are collected 
          
        return (double) totalCost;          //Return double total cost 
    }

    private static int getHungerLevel(String hungerLevel) {
        
        //Determine slice level based on hunger level 
        return switch (hungerLevel) {
            case "light" -> 1;
            case "medium" -> 2;
            case "ravenous" -> 4;
            default -> 0;   //If user input is invalid 
        };
    }
        
    private static Pizza getPizzaByCode(int code) {
        
        //Return pizza object based on the provided code 
        return switch (code) {
            case 1 -> new Pizza(1, "World Pizza", 12, 55.80);
            case 2 -> new Pizza(2, "Chickensaurus", 12, 53.80);
            case 3 -> new Pizza(3, "Meatasaurus", 12, 53.80);
            case 4 -> new Pizza(4, "Prawn Sensation", 10, 43.80);
            case 5 -> new Pizza(5, "Signature Quattro", 10, 41.80);
            case 6 -> new Pizza(6, "Beef Peperoni", 10, 45.90);
            case 7 -> new Pizza(7, "Aloha Chicken", 8, 35.90);
            case 8 -> new Pizza(8, "Flaming Tuna", 8, 35.90);
            case 9 -> new Pizza(9, "Vegie Fiesta", 8, 35.90);
            case 10 -> new Pizza(10, "Vegie Galore", 8, 35.90);
            default -> null; // Return NULL if code is invalid 
        };
    }
    
    private static void printDashes(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("-");
        }
        System.out.println(); 
    } 
}
