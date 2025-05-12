// Leetcode: https://leetcode.com/problems/subsets/ (problem 78)
// Problem: Given an integer array nums of unique elements, return all possible subsets (the power set).
// The solution set must not contain duplicate subsets. Return the solution in any order.
// Approach: Backtracking
// Time Complexity: O(n * 2^n)
// Space Complexity: O(n * 2^n)

// Example: Input: nums = [1,2,3]
// Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//
// Example: Input: nums = [0]
// Output: [[],[0]]
  

import java.util.ArrayList;
import java.util.List;   

class Subsets {
    
    public static void getAllSubsets(int[] nums, List<Integer> subs, int i, List<List<Integer>> subset) {
        if(i == nums.length) {
            // store subsets
            subset.add(new ArrayList<>(subs));
            return;
        }

        // include current element
        subs.add(nums[i]);
        getAllSubsets(nums, subs, i+1, subset);

        // exclude last added element
        subs.remove(subs.size() - 1);
        getAllSubsets(nums, subs, i+1, subset);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subset = new ArrayList<>();
        List<Integer> subs = new ArrayList<>();

        getAllSubsets(nums, subs, 0, subset);

        return subset;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = subsets(nums);

        // Print the result
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}