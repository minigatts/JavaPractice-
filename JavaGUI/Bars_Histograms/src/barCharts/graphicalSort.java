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
        
        /* 
        // Generate a bubble sorted array.
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
            
            // Generate image for each iteration.            
            if(i%1==0)  // Change the modulo to decrease number of images made.
            {
                BarChart demo = new BarChart(intArray, i, "Bar Chart Window", "Bubble Sort");
                demo.pack();
                demo.setVisible(true);
                
                System.out.println("End of  Bubble Sort");
            }
            
        }   
        */
        
        /*
        // Generate an insertion sorted array.
        intArray = graphicalSort.loadArray();  // Load original array again.
        int j;                  // the number of items sorted so far
        int key;                // the item to be inserted
        int i;  

        for (j = 1; j < intArray.length; j++)    // Start with 1 (not 0)
        {
            key = intArray[ j ];
            for(i = j - 1; (i >= 0) && (intArray[ i ] < key); i--)   // Smaller values are moving up
            {
                intArray [ i+1 ] = intArray[ i ];
            }
            
            intArray[ i+1 ] = key;    // Put the key in its proper location
        
            
            
            System.out.println(j+1000);
            BarChart demo = new BarChart(intArray, j+1000, "Bar Chart Window", "Decreasing Order Insertion Sort");
            demo.pack();
            demo.setVisible(true);
            
            System.out.println("End of Insertion Sort");
            
        }
        */
               
        
    }

public int[] mergeSort(int array[])
// pre : array is full, all elements are valid integers (not null)
// post : array is sorted in ascending order (lowest to highest)
{
	// if the array has more than 1 element, we need to split it and merge the sorted halves
	if(array.length > 1)
	{
		// number of elements in sub-array 1
		// if odd, sub-array 1 has the smaller half of the elements
		// e.g. if 7 elements total, sub-array 1 will have 3, and sub-array 2 will have 4
		int elementsInA1 = array.length/2;
                
		// since we want an even split, we initialize the length of sub-array 2 to
		// equal the length of sub-array 1
		
                int elementsInA2 = elementsInA1;
		// if the array has an odd number of elements, let the second half take the extra one
		// see note (1)
                if((array.length % 2) == 1)
			elementsInA2 += 1;
		
                // declare and initialize the two arrays once we've determined their sizes
		int arr1[] = new int[elementsInA1];
		int arr2[] = new int[elementsInA2];
		
                // copy the first part of 'array' into 'arr1', causing arr1 to become full
		for(int i = 0; i < elementsInA1; i++)
			arr1[i] = array[i];
		
                // copy the remaining elements of 'array' into 'arr2', causing arr2 to become full
		for(int i = elementsInA1; i < elementsInA1 + elementsInA2; i++)
			arr2[i - elementsInA1] = array[i];
		
                // recursively call mergeSort on each of the two sub-arrays that we've just created
		// note: when mergeSort returns, arr1 and arr2 will both be sorted!
		// it's not magic, the merging is done below, that's how mergesort works :)
		arr1 = mergeSort(arr1);
		arr2 = mergeSort(arr2);
		
		// the three variables below are indexes that we'll need for merging
		// [i] stores the index of the main array. it will be used to let us
		// know where to place the smallest element from the two sub-arrays.
		// [j] stores the index of which element from arr1 is currently being compared
		// [k] stores the index of which element from arr2 is currently being compared
		int i = 0, j = 0, k = 0;
		
                // the below loop will run until one of the sub-arrays becomes empty
		// in my implementation, it means until the index equals the length of the sub-array
		while(arr1.length != j && arr2.length != k)
		{
			// if the current element of arr1 is less than current element of arr2
			if(arr1[j] < arr2[k])
			{
				// copy the current element of arr1 into the final array
				array[i] = arr1[j];
				// increase the index of the final array to avoid replacing the element
				// which we've just added
				i++;
				// increase the index of arr1 to avoid comparing the element
				// which we've just added
				j++;
			}
			// if the current element of arr2 is less than current element of arr1
			else
			{
				// copy the current element of arr1 into the final array
				array[i] = arr2[k];
				// increase the index of the final array to avoid replacing the element
				// which we've just added
				i++;
				// increase the index of arr2 to avoid comparing the element
				// which we've just added
				k++;
			}
		}
		
                // at this point, one of the sub-arrays has been exhausted and there are no more
		// elements in it to compare. this means that all the elements in the remaining
		// array are the highest (and sorted), so it's safe to copy them all into the
		// final array.
		while(arr1.length != j)
		{
			array[i] = arr1[j];
			i++;
			j++;
		}
		while(arr2.length != k)
		{
			array[i] = arr2[k];
			i++;
			k++;
		}
	}
	
        // return the sorted array to the caller of the function
	return array;
}

}
    


