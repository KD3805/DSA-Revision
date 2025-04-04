//Print the spiral order matrix as output for a given matrix of numbers.

package Arrays;

import java.util.Scanner;

public class Array2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m ;

        System.out.println("Enter number of rows : ");
        n = sc.nextInt();

        System.out.println("Enter number of columns : ");
        m = sc.nextInt();

        int[][] arr = new int[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                System.out.println("Enter ("+i+","+j+") index element : ");
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println("Given matrix looks like...");

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }

        System.out.println();

        System.out.println("The traspose of matrix looks like...");
        printTranspose(n, m, arr);

        System.out.println();

        System.out.println("The Spiral Order Matrix is : ");
        printSpiral(n, m, arr);

        System.out.println();
    }

    public static void printSpiral(int n, int m, int[][] matrix) {
        int rowStart = 0;
        int colStart = 0;
        int rowEnd = n - 1;
        int colEnd = m - 1;

        while(rowStart <= rowEnd && colStart <= colEnd) {
            
            //1
            for(int col=colStart; col<=colEnd; col++) {
                System.out.print(matrix[rowStart][col]+" ");
            }
            rowStart++;

            //2
            for(int row=rowStart; row<=rowEnd; row++) {
                System.out.print(matrix[row][colEnd]+" ");
            }
            colEnd--;

            //3
            for(int col=colEnd; col>=colStart; col--) {
                System.out.print(matrix[rowEnd][col]+" ");
            }
            rowEnd--;

            //4
            for(int row=rowEnd; row>=rowStart; row--) {
                System.out.print(matrix[row][colStart]+" ");
            }
            colStart++;

        }
    }
    
    public static void printTranspose(int n, int m, int[][] matrix) {

        for(int j=0; j<m ;j++) {
            for(int i=0; i<n; i++) {
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
  
    }
}
