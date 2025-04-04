// Major Operations for Bit Manipulation
// 1. Get bit
// 2. Set bit
// 3. clear bit
// 4. update bit 

public class BitManipulation {
    public static void main(String[] args) {
        // get bit (bitmask: 1<<i, operation: AND)
        int n = 5; // 0(1)01
        int i = 2;
        // bitmask means to manipulate the bit position of the number
        int bitmask = 1<<i; // 0001<<2 = 0100

        // perform AND operation between bitmask and number
        if((bitmask & n) == 0) { 
            System.out.println("Bit was 0 at position "+i); 
        } else {
            System.out.println("Bit was 1 at position "+i); // true
        }

        // ======================================================================

        // set bit (bitmask: 1<<i, operation: OR)
        i = 1; 
        bitmask = 1<<i; // 0001<<1 = 0010
        int newNumber = bitmask | n; // OR operation => 00(1)0 | 01(0)1 = 01(1)1
        System.out.println(newNumber); // 7 - 01(1)1

        // ======================================================================

        // clear bit (bitmask: 1<<i, operation: AND with NOT)
        i = 2;
        bitmask = 1<<i; // 0001<<2 = 0100
        int notBitmask = ~(bitmask); // first NOT op => 1011

        newNumber = notBitmask & n; // after AND op => 1(0)11 & 0(1)01 = 0(0)01
        System.out.println(newNumber); // 1

        // ======================================================================

        // update bit 
        // oper = 1 : set and oper = 0 : clear
        i = 1;
        bitmask = 1<<i; // 0001<<1 = 0010
        boolean oper = true; // user input
        
        if(oper) {
            // set 1 bit at pos 1 for n = 5 : [set operation]
            newNumber = (bitmask | n); // OR operation => 00(1)0 | 01(0)1 = 01(1)1
            System.out.println(newNumber); // 7
        }
        else {
            // set 0 bit at pos 1 for n = 5 : [clear operation]
            notBitmask = ~(bitmask); // 1011
            newNumber = notBitmask & n; // 11(0)1 & 01(0)1 = 01(0)1
            System.out.println(newNumber); // 5

        }

    }
}