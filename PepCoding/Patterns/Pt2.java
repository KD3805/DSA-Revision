// *       *       *       *       *
//         *       *       *       *
//                 *       *       *
//                         *       *
//                                 *   

package Patterns;

import java.util.Scanner;

public class Pt2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int space = 0;
        int star = n;

        for(int i = 1; i <= n; i++) {
            // Print spaces
            for(int j = 1; j <= space; j++) {
                System.out.print("\t");
            }

            // Print stars
            for(int k = 1; k <= star; k++) {
                System.out.print("*\t");
            }

            space++;
            star--;
            System.out.println(); // Move to the next line after each row is printed
        }
    }
}

