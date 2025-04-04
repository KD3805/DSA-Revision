// n1: (1 2 1 2)_8
// n1: (0 2 5 6)_8
// substraction...
//  -> 2 - 6 (2 < 6) => borrow 8 from દસેક place digit => here 8~1, so -1 will consider as carry for દસેક => real calc: (2 + 8) - 6 = 4 (એકમ)
//  -> (1 + (-1 carry)) - 5 = 0 - 5 (0 < 5) => borrow 8 from સો place digit => here 8~1 (∵ દસેક = 8*એકમ), so -1 will consider as carry for સો => calc: (0 + 8) - 5 = 3 (દસેક)
//  -> (2 + (-1 carry)) - 2 = 1 - 2 (1 < 2) => borrow 8 from સો place digit => here 8~1 (∵ સો = 8*દસેક), so -1 will consider as carry for હજાર => calc: (1 + 8) - 2 = 7 (સો)
//  -> (1 + (-1 carry)) - 0 = 0 (હજાર)

// ANSWER: 734

import java.util.Scanner;

public class AnyBase_Substraction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int b = sc.nextInt();

        int sm1 = n1 < n2 ? n1 : n2;
        int big2 = n1 > n2 ? n1 : n2;

        int ans = getAnyBaseSubstraction(sm1, big2, b);
        System.out.println("Substraction: "+ans);
    }

    public static int getAnyBaseSubstraction(int n1, int n2, int b) {
        int ans = 0;
        int carry = 0;
        int p = 1;

        while(n2 > 0) {
            int d1 = n1 % 10;
            int d2 = n2 % 10;
            n1 /= 10;
            n2 /= 10;

            int d = 0;
            // d2 += carry;

            if(d2 >= d1) {
                carry = 0;
                d = d2 + carry - d1;
            } else {
                carry = -1;
                d = d2 + carry + b - d1;
            }

            ans += d * p;
            p *= 10;
        }

        return ans;
    }
}
