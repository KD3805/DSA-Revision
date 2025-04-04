// 1       _       _       _       _       _       1                                        1
// 1       2       _       _       _       2       1
// 1       2       3       _       3       2       1
// 1       2       3       4       3       2       1

package Patterns;

import java.util.Scanner;

public class Pt8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int sp = 2*n - 3;
        int st = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= st; j++) {
                System.out.print(j+"\t");
            }

            // spaces
            for(int k = 1; k <= sp; k++) {
                System.out.print("\t");
            }

            for(int j = st; j >= 1; j--) {
                if(j == n) {
                    j--;
                }
                System.out.print(j+"\t");
            }

            sp -= 2;
            st++;
            System.out.println();
        }
    }
}
