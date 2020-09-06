class RotateArrayInPlace {
    
    // function to print the matrix
    void printMatrix(int[][] matrix) {
        for(int i=0; i<matrix.length;i++) {
            System.out.println();
            for(int j=0; j<matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
    }
    
    public void rotate(int[][] matrix) {
        
        // take the transpose of the matrix
        // matrix[i][j] = matrix[j][i]
        
        for(int i=0; i<matrix.length; i++) {
            for(int j=i; j<matrix.length;j++) {
                int temp=matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // reverse each row of the matrix
        // the resulting matrix is the rotated version of the array
        
        for(int i=0; i<matrix.length; i++) {
            // // read each row
            // int[] row = matrix[i];
            
            // // two pointers - start and end
            // int l=0, h=row.length-1;
            
            // // swap the corresponding elements from beginning and end
            // while(l<=h) {
            //     int temp = row[l];
            //     row[l] = row[h];
            //     row[h] = temp;
            //     l++;
            //     h--;
            // }

            // same as above
            // swap the beginning and end element of the row
            for(int j=0; j<matrix.length/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
        }
        
        printMatrix(matrix);
    }
}