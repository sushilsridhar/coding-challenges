package gfg;

import java.util.HashMap;

/*
    Given an array of integers nums and an integer target, return indices of the two numbers such that
    they add up to target.
    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 */
public class Two_Sum {

    public static void main(String[] args) {

        int[] a = { 2, 7, 11, 15};

        int[] efficientResults = twoSumEfficient(a, 17);
        System.out.println(efficientResults[0]);
        System.out.println(efficientResults[1]);
    }

    // time: O(n), space: O(n)
    public static int[] twoSumEfficient(int[] nums, int target) {

        HashMap<Integer,Integer> hashmap = new HashMap<>();

        for(int i=0; i<nums.length; i++) {

            int x = target - nums[i];

            if(hashmap.containsKey(x)) {
                return new int[] { i, hashmap.get(x) };
            }
            hashmap.put(nums[i], i);
        }
        return null;
    }

    // brute force - time: O(n2), space: O(1)
    public int[] twoSum(int[] nums, int target) {

        int[] results = new int[2];

        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i]+nums[j] == target) {
                    results[0] = i;
                    results[1] = j;
                    break;
                }
            }
        }

        return results;
    }
}
