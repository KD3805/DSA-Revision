// Write a program to find the Hamming Distance between two numbers. The Hamming Distance is the number of differing bits between their binary representations.

// Example
// Input: 10 and 18
// Output: 2
// Explanation:
// Binary of 10 = 1010
// Binary of 18 = 10010
// Differing bits = 2


// Steps to Solve
// 1. XOR the two numbers (a ^ b):
//      - XOR sets a bit to 1 if the bits of a and b differ.
// 2. Count the number of 1s in the XOR result (this gives the Hamming Distance).

public class HammingDistance {
    public static int hammingDistance(int a, int b) {
        // a =  1010   (Binary of 10)
        // b = 10010   (Binary of 18)
        // XOR = 11000 (Result of XOR operation)

        // XOR the two numbers
        int xor = a ^ b; // 24

        // Count the number of 1s in the XOR result
        int count = 0;
        while (xor != 0) {
            count += xor & 1;  // Check if the last bit is 1
            xor >>= 1;         // Right shift to check the next bit
            // right shift is as similar as extract last digit from a number
        }
        return count;
    }

    public static void main(String[] args) {
        // Example input
        int a = 10;
        int b = 18;
        int result = hammingDistance(a, b);
        System.out.println(result);  // Output: 2
    }
}

