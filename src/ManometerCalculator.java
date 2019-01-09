import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A calculator that can process data acquired from a
 * differential manometer.
 * 
 * @author Zachary Zampa
 * 01/09/2019
 */
public class ManometerCalculator {

    public static void main(String[] args) {
        // Variables
        char haveFile = ' ', fileChoice = ' ', haveSG, haveStreamSG, saveQuestion;
        String importFileName, exportFileName;
        double sGravity, streamSGravity, gravity, slope, yint;
        double height, deltaPHeight, volumeFR, massFR, MolarFR;
        boolean looper;
        ArrayList <Double> manHeight = new ArrayList<>(); 
        ArrayList <Double> flowV = new ArrayList<>(); 
        
        // Scanner
        Scanner keyboard = new Scanner(System.in);
        
        // Does user have file (Y) or will they need to make one (N)
        looper = true;
        while (looper) {
            System.out.print("Do you have a .dat file containing the Manometer Readings (h(mm)) and the Flow Rate (V(mL/s))? y/n");
            haveFile = keyboard.nextLine().toUpperCase().charAt(0);
            if(haveFile == 'Y' | haveFile == 'N')
                looper = false;
        }
        
        if (haveFile == 'Y') {
            Scanner fileIn = null;
            try {
                System.out.print("What is the file name and location? ");
                importFileName = keyboard.nextLine();
                fileIn = new Scanner(new File(importFileName));
                while(fileIn.hasNextLine()) {
                    manHeight.add(fileIn.nextDouble()); // to be column 1 TODO Something is wrong. Gets error
                    flowV.add(fileIn.nextDouble()); // to be column 2
                }
                
            }
            catch (Exception ex) {
                System.out.println("Error 0: " + ex.getMessage());
            }
            finally {
                fileIn.close();
            }
        }
        else {
            looper = true;
            while (looper) {
                System.out.print("Would you like to make a file or manually input data? file/manually");
                fileChoice = keyboard.nextLine().toUpperCase().charAt(0);
                if(fileChoice == 'F' | fileChoice == 'M')
                    looper = false;
            }
            
            if (fileChoice == 'M') {
                
            }
            else { // if enter file, exit the program so user can make the file
                System.out.println("Please obtain the data and then return to the program");
                System.exit(0);
            }
            
        }
        
        
    } // end main method

}
