// Question Statement: 
// 1. You are given n number of bulbs. They are all switched off. A weird fluctuation in voltage hits the circuit n times. In the 1st fluctuation all bulbs are toggled, in the 2nd fluctuation every 2nd bulb is toggled, in the 3rd fluctuation every 3rd bulb is toggled and so on. You've to find which bulbs will be switched on after n fluctuations.
// 2. Take as input a number n, representing the number of bulbs.
// 3. Print all the bulbs that will be on after the nth fluctuation in voltage.

// --------------------------------------------------------------------------------------------------------------------------------------------------------------


// Solution:

// -> Aa Question nu solution aena par Aadhar rakhe chhe ke tamara number na factors ketla chhe.
// -> Jo koi bulb na even factors hot to ae bulb even numbers of cycle ma participate (aetle even var repeat) thay 
//      - To ae bulb hamesha off j ret (kem ke first off hato pachhi on that vadi pachho off thai jat) (off: on -> off) 
// -> Jo koi bulb na odd factors hot to ae bulb odd numbers of cycle ma participate (aetle odd var repeat) thay
//      - To ae bulb hamesha on j ret (kem ke first off hato pachhi on that pachhi off thai jat and chhele on j ret) (off: on -> off -> on)

// => And the FACT is...
//      - All perfect squares have odd number of factors
//      - eg. 1, 4, 9, 16, 25

// --------------------------------------------------------------------------------------------------------------------------------------------------------------


public class BenjaminBulbs {
    public static void main(String[] args) {
        int n = 20;

        for(int i = 1; i * i <= n; i++) {
            System.out.println(i * i);
        }
    }
}
