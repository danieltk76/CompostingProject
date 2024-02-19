package JaymeAlgorithms;


// ALOT TO DO HERE. NOT EVEN CLOSE TO DONES
import java.util.Scanner;


public abstract class algorithm extends variableReferences
{
   
//  Scanner to read player input with regards to the calculator. Not linked to calculator program yet

    public static void Scanner()
    {
        mathOperations();
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter your carbon mass: ");
        massOfMaterialC = keyboard.nextDouble();


        System.out.println("Enter your nitrogen mass: ");
        massOfMaterialN = keyboard.nextDouble();

    
    }

    public static void loop()
    {
        
        while (massOfMaterialC == 0 && massOfMaterialN == 0)
        {
            run = true;
            Scanner();
            System.out.println(finalViableAmountComp);

        }
    }

    // where math operations occur, returns the final value we actually care about 

    public static double bagStorage()
    {
        mathOperations();
        

        return finalBagAmount;

    }



    // test main method 

    public static void main(String[] args) 
    {
        loop();
        
    }
}
