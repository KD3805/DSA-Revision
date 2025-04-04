import java.util.*;

public class Recursion {
    public static void main(String[] args) {

        System.out.println("answer = "+ calcPower(2,(long) 5));
        towerOfHanoi(5, "S", "H", "D");
        findOccurence("abaacdaefaah", 0, 'a');
        moveAllxToEnd("axbcxxd", 0, 0, "");
        removeDuplicates("abbccda", 0, "");
        subsequences("abc", 0, "");
        uniqueSubsequences("aaa", 0, "", new HashSet<String>());
        printKeypadComb("23", 0, "");
    }   

    //==============================================================

    public static int calcPower(int x, long n) {
        // time complexity = O(logn)
        // [stack-height = logn]

        if(n == 0) return 1;
        if(x == 0) return 0;
        
        if(n % 2 == 0) return calcPower(x*x, n/2);
        return calcPower(x*x, (n-1)/2) * x;
    }

    //==============================================================

    public static void towerOfHanoi(int n, String src, String helper, String dest) {
        // time complexity = O(2^n)

        if(n == 1) {
            System.out.println("Move disk " + n + " from rod " + src + " to rod " + dest);
            return;
        }

        towerOfHanoi(n-1, src, dest, helper);
        System.out.println("Move disk " + n + " from rod " + src + " to rod " + dest);
        towerOfHanoi(n-1, helper, src, dest);
    }

    //==============================================================

    private static int first = -1; // for find first occurence of element  
    private static int last = -1; // for find last occurence of element

    public static void findOccurence(String str, int inx, char element) {
        // time complexity = O(n)

        if(inx == str.length()) {
            System.out.println(first);
            System.out.println(last);
            return;
        }

        char currChar = str.charAt(inx);
        if(currChar == element) {
            if(first == -1) {
                first = inx;
            } else {
                last = inx;
            }
        }
        findOccurence(str, inx+1, element);
    }

    //==============================================================

    public static void moveAllxToEnd(String str, int idx, int count, String newString) {
        // time complexity = O(n)

        if(idx == str.length()) {
            for(int i=0; i<count; i++) {
                newString += 'x';
            }
            System.out.println(newString);
            return;
        }
        char currChar = str.charAt(idx);
        if(currChar == 'x') {
            count++;
        }
        else {
            newString += currChar;
        }
        moveAllxToEnd(str, idx+1, count, newString);
    }

    //==============================================================

    private static boolean[] map = new boolean[26];

    public static void removeDuplicates(String str, int i, String newString) {
        // time complexity = O(n)

        if(i == str.length()) {
            System.out.println(newString);
            return;
        }

        char currChar = str.charAt(i);

        //(currChar - 'a') will give index of current character in map array.
        if(map[currChar - 'a']) {
            removeDuplicates(str, i+1, newString);
        } else {
            newString += currChar;
            map[currChar - 'a'] = true;
            removeDuplicates(str, i+1, newString);
        }
    }

    //==============================================================

    // In subsequences, all the characters has freedom to be or not to be in new string
    public static void subsequences(String str, int i, String newString) {
        // time complexity = O(2^n)

        if(i == str.length()) {
            System.out.println(newString);
            return;
        }

        char currChar = str.charAt(i);

        // to include current character (to be)
        subsequences(str, i+1, newString + currChar);

        // to not include current character (not to be)
        subsequences(str, i+1, newString);

    }

    // Here, HashSet has been used for print all the unique subsequences of a string    
    public static void uniqueSubsequences(String str, int i, String newString, HashSet<String> set) {
        // time complexity = O(2^n)

        if(i == str.length()) {
            if(set.contains(newString)) {
                return;
            } else {
                System.out.println(newString);
                set.add(newString);
                return;
            }
        }

        char currChar = str.charAt(i);
        // to be
        uniqueSubsequences(str, i+1, newString + currChar, set);
        // not to be
        uniqueSubsequences(str, i+1, newString, set);
    }

    //==============================================================

    private static String[] keypad = {".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    public static void printKeypadComb(String str, int i, String combination) {
        // time complexity - O(4^n)
        // Because max length of string in array is 4 - "pqrs"

        if(i == str.length()) {
            System.out.println(combination);
            return;
        }

        char currChar = str.charAt(i);
        String mapping = keypad[currChar - '0'];

        for(int k=0; k<mapping.length(); k++) {
            printKeypadComb(str, i+1, combination + mapping.charAt(k));
        }
        
    }
}