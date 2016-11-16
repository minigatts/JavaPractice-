package threadMerge;

import java.math.*;

// The purpose of this code is to determine how many cores are available, and 
// then split a dataset (array) evenly across all cores.

public class arraySplit implements Runnable
{
       
    public static void main(String args[])          
    {
        int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1};
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
            System.out.println("This can't be divided evenly, so most arrays "
                    + "will have " + (int) Math.round(L) + " elements, but the last array "
                    + "will have " + (array.length - (int) Math.round(L) * ( cores -1 ) ) + " elements.\n");
        
        // Reorganize the array into 2 dimensional array.
        // Array will have rows = cores, columns equal to division.
        // Final row may need to be populated with null elements.
        
        int[][] splitdata = new int [(int) Math.round(L)][cores];
        int elements = (int) Math.round(L);  // Max number of elements per row.
        int count = 0; 
        
        for(int j = 0; j < cores ; j++ ) // Iterate through rows.
        {
            System.out.print("\nRow " + (j+1) + " : ");
            for(int i = 0; i < elements ; i++ )  // Iterate through columns.
            {
                splitdata[i][j] = array[count];
                System.out.print(splitdata[i][j]+ " ");
                count++;
            }
            
        }
        
        // Print each 'subset' seperately. 
        for( int j = 0 ; j < cores ; j++ )
        {
            System.out.print("\nList " + (j+1) + " : ");
            for ( int i = 0 ; i < elements ; i++)
            {
                System.out.print(splitdata[i][j] + " ");
            }
        }
        
        
    }
    
    public void run() 
    {
         //new Thread(new arraySplit()).start();
        
        System.out.println("Hello from a thread!");        
    }
     
}
