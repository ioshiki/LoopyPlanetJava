/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loopyplanetjava;

/**
 *
 * @author Joseph
 */
import java.util.Scanner; //used to read user input
import java.util.InputMismatchException;

public class LoopyPlanetJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner userinput = new Scanner(System.in);
        
        
        String name;
        
        /*instead of creating an entire switch statement containing all the strings and multipliers from my C# example 
        we will use arrays to hold their respective values and call them later, saving a lot of lines of code
        */
        String[] planet = {"Mercury", "Venus", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto"};
        double[] multiplier = {0.37, 0.88, 0.38, 2.64, 1.15, 1.15, 1.12, 0.04};
        
        //initializing values for variables//
        int menuchoice = 0;
        double weight = 0.00;
        double finalweight = 0.00;
       /* boolean restart = true; condition to add on later*/
        
        
       
        //Welcome Screen //        
        System.out.println("Welcome to Loopy Planet - The Java version");
        System.out.print("Please Enter Your Name: ");
        name = userinput.next();  
        System.out.println("Welcome " + name + "!"); //asks user input for their name and outputs it//
        
        //after asking the name the menu comes up
        
        System.out.println("Menu of Planets");
        System.out.println("==== == ========\n");
        System.out.println("1. Mercury   2. Venus    3. Mars  ");
        System.out.println("4. Jupiter   5. Saturn   6. Uranus");
        System.out.println("7. Neptune   8. Pluto    9. <Quit>");
        System.out.println("\n");
        
        
        
        //Conditions for the menu choice from the user input
        boolean inputError = true; //we create a boolean to test if the user input is valid
        
        while (inputError) //runs by default as inputError is true
        {
            
            try  //using a try and catch to catch any non-integers as the menus only contain whole numbers
                    {   
                        System.out.print("Please enter the # of the Planet of your choice: ");
                        menuchoice = Integer.parseInt(userinput.next());
                        while (menuchoice <= 0 || menuchoice > 9)   //creating a condition if the integer the user input is beyond the scope of the menu
                        {
                            System.out.println("Error - that number does not exist");
                            System.out.print("Please enter the # of the Planet of your choice: ");
                            menuchoice = Integer.parseInt(userinput.next());
                        }
                        
                        if (menuchoice == 9){   //a condition for #9. System.exit(0); terminates the program
                            System.out.println("Good Bye");
                            System.exit(0);
                        }
                        
                        else //if it passes all the above, it exits the loop
                        {
                            inputError = false;
                            break;
                        }
                    }
            catch (NumberFormatException errordesu)  //the catch statement catches all non-number Strings including symbols and returns an error message
                    {
                        System.out.println("Please enter numbers"); 
                    }
            
        }
        
        System.out.println("Your choice is " + menuchoice);  //confirms the user input
        
        
        //Conditions for user input for their weight values
        
        boolean weightError = true;  //similarly to the one above, this is to test user input for the weight portion
        
        while (weightError)  
        {
            try  //this try-catch will throw an exception if the user inputs any Strings or 0 or negative doubles as weight cannot be negative or 0.
            {
                System.out.print("Please enter your weight in pounds: ");
                weight = Double.parseDouble(userinput.next());
                while (weight <= 0)
                {
                    System.out.println("Error - your weight cannot be 0 or negative");
                    System.out.print("Please enter your weight in pounds: ");
                    weight = Double.parseDouble(userinput.next());
                }
                
                weightError = false;
                break;
            }
            catch (NumberFormatException errorweight) 
            {
                System.out.println("Please enter your weight in numbers");
            }
        }
        
        /*formula for the final weight is the user's weight multiplied by the planet's multiplier
        as we already created an integer array containing the gravitational multiplier for their respective planets,
        all we have to do is reference the inital user input from the menu and add 1 to it.
        Arrays start with an index of 0, that's why it's necessary to subtract 1 to it
        if the user picked Venus for example that would mean they choice 2 from the menuchoice, however Venus is referenced from the index of [1]
        Therefore venus' multiplier would need to be the menuchoice of 2-1, which is [1], 0.88
        */
        finalweight = (weight*multiplier[menuchoice-1]);   
        
        
        System.out.println("Thank you.");
        System.out.println(name + ", your weight of " + weight + "lbs on Earth will be " + finalweight + " lbs on " + planet[menuchoice-1]+"\n");
        
        
        
         
    }
    
}
