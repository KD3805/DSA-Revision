import java.util.*;

// dry run - ruffbook ma chhe
public class AdvanceRecursion {
    
    public static void main(String[] args) {
        //1
        printPerm("abc", "");

        //2
        int total = countPaths(0, 0, 3, 4);
        System.out.println(total);

        //3
        total = placeTiles(4, 2);
        System.out.println(total);

        //4
        System.out.println(callGuests(4));

        //5
        ArrayList<Integer> subset = new ArrayList<>();
        findSubsets(3, subset);
    }

    //==============================================================

    // Permutation: all the possible combinations of the letters
    public static void printPerm(String str, String permutation) {
        // time complexity - O(n*n!); where n-steps and n!-answes

        if (str.length() == 0) {
            System.out.println(permutation);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // substract current character in subStr
            String subStr = str.substring(0, i) + str.substring(i + 1);

            printPerm(subStr, permutation + ch);
        }
    }

    //==============================================================

    /* Count total paths in a maze(માર્ગ) to move from (0,0) to (n,m)
    Conditions - move either downwards or right */

    public static int countPaths(int i, int j, int n, int m) {
        if (i == n || j == m) {
            return 0;
        }
        if (i == n - 1 || j == m - 1) {
            return 1;
        }
        // move downwards
        int downPaths = countPaths(i + 1, j, n, m);

        // move right
        int rightPaths = countPaths(i, j + 1, n, m);

        return downPaths + rightPaths;
    }

    //==============================================================

    // Place tiles of size 1×m in a floor of size n×m.
    // How many ways can you arrange the tiles?

    public static int placeTiles(int n, int m) {
        if (n == m) {
            return 2;// only two possible ways
        }
        if (n < m) {
            return 1;// only one possible way
        }

        // vertically
        int vertPlacements = placeTiles(n - m, m); // n-m is remaining space

        // horizontaly
        int horPlacements = placeTiles(n - 1, m);

        return vertPlacements + horPlacements;
    }

    //==============================================================

    /* Find the number of ways in which you can invite n people to your party,
    single or in pairs. */

    public static int callGuests(int n) {
        if(n <= 1) {
            return 1;
        }
        // single
        int way1 = callGuests(n-1);

        // pairs
        int way2 = (n-1)*callGuests(n-2);

        return way1 + way2;
    }

    //==============================================================

    // Print all the subsets of a set of n natural numbers

    public static void printSubsets(ArrayList<Integer> subset) {
        for(int i=0; i<subset.size(); i++) {
            System.out.print(subset.get(i)+" ");
        }
        System.out.println();
    }

    public static void findSubsets(int n, ArrayList<Integer> subset) {
        // time complexity - O(2^n)

        if(n == 0) {
            printSubsets(subset);
            return;
        }

        //add thase
        subset.add(n);
        findSubsets(n-1, subset);

        //add nai thay
        subset.remove(subset.size()-1);
        findSubsets(n-1, subset);
    }

}
