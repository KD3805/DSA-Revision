public class GcdLcm {
    public static void main(String[] args) {
        int n1 = 36;
        int n2 = 24;

        int og1 = n1;
        int og2 = n2;

        while(n1 % n2 != 0) {
            int rem = n1 % n2;
            n1 = n2;
            n2 = rem;
        }

        int gcd = n2;
        int lcm = (og1 * og2) / gcd;

        System.out.println("GCD: "+gcd);
        System.out.println("LCM: "+lcm);
    }
}
