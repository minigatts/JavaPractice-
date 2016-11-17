package threadMerge;

// <editor-fold defaultstate="collapsed" desc="Imports">
import java.math.*;
// </editor-fold>

// The purpose of this code is to determine how many cores are available, and 
// then split a dataset (array) evenly across all cores.

public class arraySplit implements Runnable
{
       
    public static void main(String args[])          
    {       
       // Generate 2D array with rows = # cores on machine.
       int[][] array = genArrays();
       
       // Send each row to a seperate thread.        
       for(int i = 0 ; i < array.length ; i++ )
       { 
           int[] subarray = new int[array[0].length];
           
           for(int j = 0 ; i < array[0].length ; j++)
           {
               subarray[j]=array[i][j];
           }
                    
       }
       
       
    }
    
    public static int[][] genArrays()
    {
        int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 1, 2};
        System.out.println("Your input array contains " + array.length + " elements.");      
        for(int i = 0; i<array.length; i++) System.out.print(array[i] + " ");
        
        // Calculate number of cores available. 
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Your machine has " + cores + " cores.\n");
        
        
        // Calculate what an even split of the array across the number of cores.
        // would entail.  E.g. how many elements per core.
        double L = (double) array.length / cores;
        
        System.out.println("If your input array is split evenly across " 
                + cores + " cores, each will have " + L + " elements");
        
        
        
        // We dont want noninteger divisions of array, so in the event that 
        // array cannot be evenly divided across the cores, the 'odd' element
        // will be added to the last sub-array.
        if( (double) array.length % cores != 0)
        {
            System.out.println("This can't be divided evenly, so most arrays "
                    + "will have " + (int) Math.ceil(L) + " elements, but the last array "
                    + "will have " + (array.length - (int) Math.ceil(L) * ( cores -1 ) ) + " elements.\n");
        
            System.out.println("This will ocasionally result in the last array\n"
                    + "being underpopulated, possibly having only one element.\n"
                    + "In later versions I will code to optimize the division\n"
                    + "of elements better.\n");
        }
             
        
        // Reorganize the array into 2 dimensional array.
        // Array will have rows = cores, columns equal to division.
        // Final row may need to be populated with null elements.
        
        int[][] splitdata = new int [(int) Math.ceil(L)][cores];
        int elements = (int) Math.ceil(L);  // Max number of elements per row.
        int count = 0; 
        
        // Fill 2D Array to prepare for split.
        for(int j = 0; j < cores ; j++ ) // Iterate through rows.
        {
            // System.out.print("\nRow " + (j+1) + " : ");
            for(int i = 0; i < elements ; i++ )  // Iterate through columns.
            {                
                if( count < array.length) splitdata[i][j] = array[count];
                else{splitdata[i][j] = -999; }  // Flag null entries with -999.
               
                count++;
            }            
        }
        
        // Print each 'subset' seperately. 
        for( int j = 0 ; j < cores ; j++ )
        {
            System.out.print("Group " + (j+1) + " : ");
            for ( int i = 0 ; i < elements ; i++)
            {
                System.out.print(splitdata[i][j] + " ");
            }
            System.out.print("\n");
        }
        
        return splitdata;
        
    }
    
    public void run(int[] array) 
    {
         //new Thread(new arraySplit()).start();
        
        System.out.println("New Thread Started");        
    }     
}
