package gfg;

import java.util.HashSet;

/*
    Given an integer array nums, return true if any value appears at least twice in the array,
    and return false if every element is distinct.

    Input: nums = [1,2,3,1]
    Output: true
 */
public class Contains_Duplicate {

    public static void main(String[] args) {

        int[] a = { 1, 2, 3, 1};

        boolean result = containsDuplicateEfficient(a);
        System.out.println(result);
    }

    // time: O(n), space: O(n)
    public static boolean containsDuplicateEfficient(int[] nums) {

        HashSet<Integer> hashset = new HashSet<>();

        for(int i=0; i<nums.length; i++) {

            if(hashset.contains(nums[i]))
                return true;
            else
                hashset.add(nums[i]);
        }
        return false;

    }

    // Time: O(n2), space: none
    public boolean containsDuplicate(int[] nums) {

        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i] == nums[j])
                    return true;
                else
                    continue;
            }
        }
        return false;
    }
}
