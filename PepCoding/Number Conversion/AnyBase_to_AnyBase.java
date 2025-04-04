// Any other -> Decimal: 
//      - Divide by 10
//      - Multiply with powers of base

// Decimal -> Any other: 
//      - Divide by Base
//      - Multiply with powers of 10

import java.util.Scanner;

public class AnyBase_to_AnyBase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b1 = sc.nextInt();
        int b2 = sc.nextInt();

        int res = getAnyBaseToAnyBase(n, b1, b2);

        System.out.println("Given number "+n+" in base: "+b1);
        System.out.println("Answer "+res+" in base: "+b2);
    }

    public static int getAnyBaseToAnyBase(int n, int b1, int b2) {
        int dec = getAnyBaseToDecimal(n, b1);
        int res = getDecimalToAnyBase(dec, b2);
        return res;
    }

    public static int getAnyBaseToDecimal(int n, int b) {
        int res = 0;
        int p = 1; // b^0

        while(n > 0) {
            int dig = n % 10;
            res += dig * p;
            p *= b;
            n /= 10;
        }
        return res;
    }

    public static int getDecimalToAnyBase(int n, int b) {
        int res = 0;
        int p = 1; // 10^0

        while(n > 0) {
           int dig = n % b;
           res += dig * p;
           p *= 10;
           n /= b;
        }
        return res;
    }
}
