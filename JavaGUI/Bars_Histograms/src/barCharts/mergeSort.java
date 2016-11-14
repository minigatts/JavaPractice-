package barCharts;

// This program implements the merge sort algorithm for
// arrays of integers.

import java.io.IOException;
import java.util.*;

public class mergeSort 
{
    public static void MS(int[] intArray) throws IOException 
    {
        
        System.out.println("before: " + Arrays.toString(intArray));
        mergeSort(intArray);
        
        System.out.println("after:  " + Arrays.toString(intArray));
    }

    // Places the elements of the given array into sorted order
    // using the merge sort algorithm.
    // post: array is in sorted (nondecreasing) order
    public static void mergeSort(int[] array) throws IOException 
    {
        
        int count=0;  // Number of times merge has run.
        
        if (array.length > 1) 
        {
            // split array into two halves
            int[] left = leftHalf(array);
            int[] right = rightHalf(array);
            
            // recursively sort the two halves
            mergeSort(left);
            mergeSort(right);
            
            // merge the sorted halves into a sorted whole
            merge(array, left, right);           
            
            
        }
    }
    
    // Returns the first half of the given array.
    public static int[] leftHalf(int[] array) {
        int size1 = array.length / 2;
        int[] left = new int[size1];
        for (int i = 0; i < size1; i++) {
            left[i] = array[i];
        }
        return left;
    }
    
    // Returns the second half of the given array.
    public static int[] rightHalf(int[] array) {
        int size1 = array.length / 2;
        int size2 = array.length - size1;
        int[] right = new int[size2];
        for (int i = 0; i < size2; i++) {
            right[i] = array[i + size1];
        }
        return right;
    }
    
    // Merges the given left and right arrays into the given 
    // result array.  Second, working version.
    // pre : result is empty; left/right are sorted
    // post: result contains result of merging sorted lists;
    public static void merge(int[] result, int[] left, int[] right) throws IOException 
    {
        int i1 = 0;   // index into left array
        int i2 = 0;   // index into right array
        int count = 0;
        
        for (int i = 0; i < result.length; i++) 
        {
            if (i2 >= right.length || (i1 < left.length && 
                    left[i1] <= right[i2])) {
                result[i] = left[i1];    // take from left
                i1++;
            } else {
                result[i] = right[i2];   // take from right
                i2++;
            }                     
        }       
        
           BarChart demo = new BarChart(result, count+10000, "Bar Chart Window", "Merge Sort");
           demo.pack();
           demo.setVisible(true);
            
    }
 }