// Leetcode: https://leetcode.com/problems/permutations/ (problem 46)
// Problem: Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
// Approach: Backtracking
// Time Complexity: O(n*n!)
// Space Complexity: O(n*n!)
//
// Example: Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

import java.util.ArrayList;
import java.util.List;

class Permutations {
    
    public static void getPerms(int[] nums, int idx, List<List<Integer>> perms) {
        if (idx == nums.length) {
            // Convert int[] to List<Integer> before adding
            List<Integer> perm = new ArrayList<>();
            for (int num : nums) {
                perm.add(num);
            }
            perms.add(perm);
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            // swap current element with choosen element (i.e. nums[idx])
            // in-place replacement
            int temp = nums[i];
            nums[i] = nums[idx];
            nums[idx] = temp;

            getPerms(nums, idx + 1, perms);

            // swap again to rearrage elements as their previous state in backtracking
            temp = nums[i];
            nums[i] = nums[idx];
            nums[idx] = temp;
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> perms = new ArrayList<>();

        getPerms(nums, 0, perms);

        return perms;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = permute(nums);

        // Print the result
        for (List<Integer> perm : result) {
            System.out.println(perm);
        }
    }
}
