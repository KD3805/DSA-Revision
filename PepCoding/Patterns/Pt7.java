//                 1
//         2       3       2
// 3       4       5       4       3
//         2       3       2
//                 1

package Patterns;

import java.util.Scanner;;

public class Pt7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int sp = n / 2;
        int st = 1;
        for(int i = 1; i <= n; i++) {
            // Logic 1
            int count; 
            if(i <= n/2) {
                count = i;
            } else {
                count = n - i + 1;
            }
            // ------------

            for(int j = 1; j <= sp; j++) {
                System.out.print("\t");
            }

            for(int j = 1; j <= st; j++) {
                System.out.print(count+"\t");
                
                // Logic 2
                if(j <= st/2) {
                    count++;
                } else {
                    count--;
                }
                // ------------
            }

            if(i <= n/2) {
                sp--;
                st += 2;
            } else {
                sp++;
                st -= 2;
            }
            System.out.println();
        }
    }
}
