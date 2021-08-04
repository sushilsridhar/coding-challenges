package arrays;

/*
    Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
    Note that you must do this in-place without making a copy of the array.

    Input: nums = [0,1,0,3,12]
    Output: [1,3,12,0,0]
 */
public class Move_Zeros {

    public static void main(String[] args) {

        int[] nums = {0,1,0,3,12};

        moveZeroes(nums);

    }

    // brute force, time: O(n), space: O(n)
    public static void moveZeroes(int[] nums) {

        int[] newArray = new int[nums.length];
        int newArrayCurrentIndex = 0;
        int numberOfZeros = 0;

        for(int i=0; i<nums.length; i++) {

            if(nums[i] == 0) {
                numberOfZeros++;
            } else {
                newArray[newArrayCurrentIndex] = nums[i];
                newArrayCurrentIndex++;
            }
        }

        for(int i=newArrayCurrentIndex; i<nums.length; i++) {
            newArray[i] = 0;
        }

        for(int i=0; i<nums.length;i++) {
            System.out.println(newArray[i]);
        }
    }
}
