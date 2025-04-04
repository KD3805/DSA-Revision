// Decimal -> Any other: 
//      - Divide by Base
//      - Multiply with powers of 10

import java.util.Scanner;

public class Decimal_to_AnyBase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int base = sc.nextInt();

        int res = getDecimalToAnyBase(n, base);

        System.out.println("Decimal: "+n);
        System.out.println("Answer: "+res);
    }    

    public static int getDecimalToAnyBase(int n, int b) {
        int res = 0;
        int p = 1; // 10^0

        while(n > 0) {
            int dig = n % b;
            n = n / b;

            res += dig * p;
            p *= 10;
        }

        return res;
    }
}
