package jaymesAlgorithms;

import java.util.Scanner;

public abstract class algorithm extends variableReferences
{
   

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

    public static double bagStorage()
    {
        mathOperations();
        

        return finalBagAmount;

    }



    public static void main(String[] args) 
    {
        loop();
        
    }
}
