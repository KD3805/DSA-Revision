// Leetcode: https://leetcode.com/problems/subsets-ii/description/ (problem 90)
// Problem: Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
// The solution set must not contain duplicate subsets. Return the solution in any order.
// Approach: Backtracking
// Time Complexity: O(n * 2^n)
// Space Complexity: O(n * 2^n)

// Example: Input: nums = [1,2,2]
// Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
// Example: Input: nums = [0]
// Output: [[],[0]]
//
// Example: Input: nums = [1,2,3]
// Output: [[],[1],[1,2],[1,2,3],[1,3],[2],[2,3],[3]]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SubsetsII {
    public static void getAllSubsets(int[] nums, List<Integer> subs, int i, List<List<Integer>> subset) {
        if(i == nums.length) {
            // store new subset into power set
            subset.add(new ArrayList<>(subs));
            return;
        }

        // include current element
        subs.add(nums[i]);
        getAllSubsets(nums, subs, i+1, subset);

        // exclude last added element from stack
        subs.remove(subs.size() - 1);

        // skip duplicate values by increasing current index until new element occur
        int idx = i + 1;
        while(idx < nums.length && nums[idx] == nums[idx - 1])
            idx++;

        getAllSubsets(nums, subs, idx, subset);
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subset = new ArrayList<>();
        List<Integer> subs = new ArrayList<>();

        Arrays.sort(nums);
        getAllSubsets(nums, subs, 0, subset);

        return subset;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> result = subsetsWithDup(nums);

        // Print the result
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}