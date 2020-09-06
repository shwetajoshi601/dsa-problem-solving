import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    static int searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;
        // given that the matrix is row wise and column wise sorted
        // start from the last element of the first row
        // elements below this element are greater, and elements to the left are smaller
        while(i < matrix.length && j >= 0) {
            // target found
            if(matrix[i][j] == target) return 1;
            // if element is greater than target, move left
            else if(matrix[i][j] > target) j--;
            // element smaller than target, move down
            else i++;
        }
        return 0;
    } 
    
	public static void main (String[] args)
	 {
	 //code
	 Scanner sc = new Scanner(System.in);
	 int t = sc.nextInt();
	 
	 while(t-- > 0) {
	     int n = sc.nextInt();
	     int m = sc.nextInt();
	     
	     int[][] nums = new int[n][m];
	     
	     for(int i=0; i<n;i++) {
	         for(int j=0; j<m; j++) {
	             nums[i][j] = sc.nextInt();
	         }
	      }
	      
	      int target = sc.nextInt();
         // function call here
         System.out.println(searchMatrix(nums, target));
	 	}
	 }
}