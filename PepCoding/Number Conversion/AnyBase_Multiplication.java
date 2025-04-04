// This program performs multiplication of two numbers in any base.
// It takes three inputs: two numbers and the base.
// The program then multiplies the two numbers in the given base and prints the result.

// Example:
// Input: 12 3 8 (12 and 3 are the numbers, 8 is the base)
// Output: 34 (result of 12 * 3 in base 8)

import java.util.Scanner;

public class AnyBase_Multiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt(); // First number to multiply
        int n2 = sc.nextInt(); // Second number to multiply
        int b = sc.nextInt(); // Base of the numbers

        // Determine the larger and smaller numbers for easier processing
        int big1 = n1 > n2 ? n1 : n2; // Larger number
        int sm2 = n1 < n2 ? n1 : n2; // Smaller number

        // Call the method to perform multiplication in any base
        int ans = getAnyBaseMultiplication(big1, sm2, b);
        System.out.println("Multiplication: "+ans);
    }

    /**
     * This method multiplies two numbers in any base.
     * It works by multiplying the smaller number with each digit of the larger number
     * and then adding the results aligned properly.
     * 
     * @param n1 The larger number
     * @param n2 The smaller number
     * @param b The base of the numbers
     * @return The result of the multiplication in the given base
     */
    public static int getAnyBaseMultiplication(int n1, int n2, int b) {
        int ans = 0; // Initialize the answer
        int p = 1; // Placeholder to align digits

        // Loop through each digit of the smaller number
        while(n2 > 0) {
            int d2 = n2 % 10; // Current digit of the smaller number
            n2 = n2 / 10; // Move to the next digit

            // Multiply the larger number with the current digit of the smaller number
            int singleProd = getProductWithSingleDigit(n1, d2, b);
            // Add the result to the answer, aligning it properly
            ans = getAnyBaseAddition(ans, singleProd * p, b); 
            p *= 10; // Move to the next place value
        }

        return ans;
    }

    /**
     * This method multiplies a number with a single digit in any base.
     * It works by multiplying each digit of the number with the single digit
     * and then adding the results, considering the base and carry.
     * 
     * @param n1 The number to multiply
     * @param d2 The single digit to multiply with
     * @param b The base of the number
     * @return The result of the multiplication with the single digit in the given base
     */
    public static int getProductWithSingleDigit(int n1, int d2, int b) {
        int ans = 0; // Initialize the answer
        int c = 0; // Carry from previous multiplication
        int p = 1; // Placeholder to align digits

        // Loop through each digit of the number
        while(n1 > 0 || c > 0) {
            int d1 = n1 % 10; // Current digit of the number
            n1 = n1 / 10; // Move to the next digit

            // Multiply the current digits and add the carry
            int prod = d1 * d2 + c;
            // Calculate the value and carry for the current multiplication
            int val = prod % b; // Value in the current base
            c = prod / b; // Carry for the next multiplication

            // Add the value to the answer, aligned properly
            ans += val * p;
            p *= 10; // Move to the next place value
        }

        return ans;
    }

    /**
     * This method adds two numbers in any base.
     * It works by adding each digit of the numbers, considering the base and carry.
     * 
     * @param n1 The first number to add
     * @param n2 The second number to add
     * @param b The base of the numbers
     * @return The result of the addition in the given base
     */
    public static int getAnyBaseAddition(int n1, int n2, int b) {
        int ans = 0; // Initialize the answer
        int p = 1; // Placeholder to align digits
        int carry = 0; // Carry from previous addition

        // Loop through each digit of the numbers
        while(n1 > 0 || n2 > 0 || carry != 0) {
            int dig1 = n1 % 10; // Current digit of the first number
            int dig2 = n2 % 10; // Current digit of the second number

            // Add the current digits and the carry
            int add = dig1 + dig2 + carry;
            // Calculate the value and carry for the current addition
            int val = add % b; // Value in the current base
            carry = add / b; // Carry for the next addition

            // Add the value to the answer, aligned properly
            ans += val * p;
            p *= 10; // Move to the next place value
            n1 /= 10;
            n2 /= 10;
        }

        return ans;
    }
}
