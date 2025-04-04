// Question Statement: 
// 1. You are required to display the prime factorization of a number.
// 2. Take as input a number n.
// 3. Print all its prime factors from smallest to largest.


public class PrimeFactorization {
    public static void main(String[] args) {
        int n = 1440;

        for(int i = 2; i*i <= n; i++) {
            while(n % i == 0) {
                System.out.println(i);
                n /= i;
            }
        }

        // in case of remaining n is prime itself
        // eg. 46 => 46/23: 2, 23/1: 23 => 2, 23
        // here, 23 will not gonna print in first loop so we have to check it externaly
        if(n != 1) {
            System.out.println(n);
        }
    }
}
