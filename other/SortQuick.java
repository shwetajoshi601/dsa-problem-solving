/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class SortQuick {
    
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    static int partition(int[] arr, int low, int high) {
        // choose last element as the pivot
       int pivot = arr[high];
       // partition index as low
       int pIndex = low;
        
       // check the elements from low to high-1 (not high since element at high is the pivot)       
       for(int i=low; i<=high-1; i++) {
           // if an element less than pivot is found
           if(arr[i] <= pivot) {
               // move it to the front and move pivot index ahead
               // basically putting smaller elements than pivot to the left of pivot index
               swap(arr, i, pIndex);
               pIndex++;
           }
       }
       
       // at the end, we have placed all values smaller than pivot
       // to the left of the pivotIndex
       // so element at pIndex should be pivot
       // hence swap them
       swap(arr, pIndex, high);
       
       // return the pivotIndex
       return pIndex;
    }
    
    static void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex-1);
            quickSort(arr, pivotIndex+1, high);
        }
    }
    
	public static void main (String[] args) throws IOException{
		int[] arr = {4, 1, 3, 9, 7};
		
		quickSort(arr, 0, arr.length-1);
		
		for(int i: arr)
		    System.out.print(i + " ");
	}
}