package JaymeAlgorithms;

import java.awt.Graphics;
import java.awt.Image;

public abstract class variableReferences
{
    protected static double nitrogenPercent;
    protected static double carbonPercent;
    protected static double massOfMaterialC;
    protected static double massOfMaterialN;
    protected static double finalBagAmount;
    protected static double finalViableAmountComp;
    protected static boolean run = true;
    
    public static void mathOperations()
    {

        double NitroMass = (nitrogenPercent / 100) * massOfMaterialN;  
        double CarbonMass = (carbonPercent / 100) * massOfMaterialC;
    
        finalViableAmountComp = 30 * (CarbonMass) + NitroMass;

    }

    public void makeFrameNotUgly(Graphics g) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'makeFrameNotUgly'");
    }


    
}
