// Any other -> Decimal: 
//      - Divide by 10
//      - Multiply with powers of base

import java.util.Scanner;

public class AnyBase_to_Decimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int base = sc.nextInt();

        int res = getAnyBaseToDecimal(n, base);

        System.out.println("Given number: "+n);
        System.out.println("Decimal: "+res);
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
}
