import java.util.Scanner;

public class AnyBase_Subtraction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number (n1): ");
        int n1 = sc.nextInt();

        System.out.print("Enter second number (n2): ");
        int n2 = sc.nextInt();

        System.out.print("Enter base (b): ");
        int b = sc.nextInt();

        boolean isNegative = false;

        // Check if result will be negative
        if (n1 < n2) {
            // swap n1 and n2
            int temp = n1;
            n1 = n2;
            n2 = temp;
            isNegative = true;
        }

        int result = getAnyBaseSubtraction(n1, n2, b);
        if (isNegative) {
            System.out.println("Subtraction result: " + result*(-1));
        } else {
            System.out.println("Subtraction result: " + result);
        }
    }

    public static int getAnyBaseSubtraction(int n1, int n2, int b) {
        int ans = 0;
        int borrow = 0;
        int p = 1;

        while (n1 > 0 || n2 > 0) {
            int d1 = n1 % 10;
            int d2 = n2 % 10;

            n1 /= 10;
            n2 /= 10;

            d1 = d1 + borrow;

            int sub;
            if (d1 >= d2) {
                sub = d1 - d2;
                borrow = 0;
            } else {
                sub = (d1 + b) - d2;
                borrow = -1;
            }

            ans += sub * p;
            p *= 10;
        }

        return ans;
    }
}
