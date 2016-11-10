/*
This is a program which sorts an array.

After each iteration, the BarChart class is called to display the array, as of
that iteration, graphically as a bar chart.
*/
package barCharts;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Chantz
 */
public class graphicalSort 
{

    // Custom method to load array from file.
    public static int[] loadArray()
    {
        // This section loads the array.txt file, and updates textArea.
				
        File f = new File("src/barCharts/array.txt");
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
    
    public static void main(String[] args) throws IOException
    {
        // Call method to load the array from file, into memory.
        int[] intArray = graphicalSort.loadArray();
        int temp;
        
        // Use bubble sort on the array.
        for(int i =0; i< intArray.length ; i++)  // Outside loop.
        {
            for (int j = 1; j < intArray.length -1 ; j++)  // Inside loop.
            {
                if (intArray[j - 1] > intArray[j]) 
                {
                    temp = intArray[j-1];
                    intArray[j-1] = intArray[j];
                    intArray[j] = temp;
                }
            }
            
            System.out.println(i + " is " + intArray[i]);
            
            if(i%1==0)  // Change the modulo to decrease number of images made.
            {
                BarChart demo = new BarChart(intArray, i, "Bar Chart Window", "Bar chart, bitches!");
                demo.pack();
                demo.setVisible(true);
                
                System.out.println("End of BarMain");
            }
            
        }      
        
    }
    

    
}
