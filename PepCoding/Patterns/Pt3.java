// *       *       *               *       *       *
// *       *                               *       *
// *                                               *
// *       *                               *       *
// *       *       *               *       *       *        

package Patterns;

import java.util.Scanner;

public class Pt3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int star = (int) (n/2) + 1;
        int space = 1;

        for(int i = 1; i <= n; i++) {
            // System.out.println(star+", "+space+", "+star);

            // Print stars
            for(int k = 1; k <= star; k++) {
                System.out.print("*\t");
            }

            // Print spaces
            for(int j = 1; j <= space; j++) {
                System.out.print("\t");
            }

            // Print stars
            for(int k = 1; k <= star; k++) {
                System.out.print("*\t");
            }

            if(i <= (n/2)) {
                star--;
                space += 2;
            } else {
                star++;
                space -= 2;
            }
            System.out.println();
        }
    }
}

