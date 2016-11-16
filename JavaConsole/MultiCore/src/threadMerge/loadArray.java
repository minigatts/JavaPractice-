package threadMerge;

// <editor-fold defaultstate="collapsed" desc="Imports">
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
// </editor-fold>

public class loadArray 
{
    // Custom method to load array from file.
    public static int[] loadArray(String filename)
    {
        // This section loads the array.txt file, and updates textArea.
				
        File f = new File("src/barCharts/" + filename);
        System.out.println("Path : " + f.getAbsolutePath());

        // Initialize inputFile
        Scanner inputFile = null;
        try 
        {
                inputFile = new Scanner(f);
        } 
        catch (FileNotFoundException e1) 
        {
                e1.printStackTrace();
        }

        // Preferable to use ArrayList, no need to define array size in advance.
        ArrayList<Integer> array = new ArrayList<Integer>();
        
        // While loop to read file to array list, and count elements.
        int Count = 0;  // Variable to track number of elements added to list.
        
        while (inputFile.hasNext()) 
        {
          // find next line
          int token = inputFile.nextInt();
          array.add(token);
         
          System.out.print(token + " ");  

          // Track how many numbers are in the list.
          Count++; 
          
          System.out.println("File has been read into memory.");
        }
                
        inputFile.close();
        
        // Copy list into array.
        int[] intArray = new int[Count]; // Declare integer array.
        
        for(int i=0;i<Count;i++)
        {
            intArray[i] = array.get(i);
             System.out.println(i + " is " + array.get(i));
        }
        
        return intArray;
    }
    
}
