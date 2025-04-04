// n1: (3 4 6)_8
// n1: (7 7 7)_8
// addition...
//  -> 6 + 7 = 13 => 13: 8 + 5 => here 8~1, so 1 will consider as carry => એકમ: 5
//  -> 4 + 7 + 1(carry) = 12 => 12: 8 + 4 => here 8~1 (∵ દસેક = 8*એકમ), so 1 will consider as carry => દસેક: 4
//  -> 3 + 7 + 1(carry) = 11 => 11: 8 + 3 => here 8~1 (∵ સો = 8*દસેક), so 1 will consider as carry => સો: 3
//  -> 1(carry) => હજાર: 1

// ANSWER: 1345

// 67. Add Binary
// 989. Add to Array-Form of Integer

import java.util.Scanner;

public class AnyBase_Addition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int b = sc.nextInt();

        int ans = getAnyBaseAddition(n1, n2, b);
        System.out.println("Addition: "+ans);
    }

    public static int getAnyBaseAddition(int n1, int n2, int b) {
        int ans = 0;
        int p = 1;
        int carry = 0;

        while(n1 > 0 || n2 > 0 || carry != 0) {
            int dig1 = n1 % 10;
            int dig2 = n2 % 10;

            int add = dig1 + dig2 + carry;
            int val = add % b; // reminder ~ value
            carry = add / b; // quotient ~ carry

            ans += val * p;
            p *= 10;
            n1 /= 10;
            n2 /= 10;
        }

        return ans;
    } 
}
