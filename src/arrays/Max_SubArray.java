package arrays;

public class Max_SubArray {

    public static void main(String[] args) {

        int[] nums = {-2, -3, -1};

        System.out.println(maxSubArrayBruteForceWorst(nums));

        System.out.println(bruteForce(nums));

    }

    private static int bruteForce(int[] nums) {
        int maxSum = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++) {
            int sum=0;
            for(int j=i; j<nums.length; j++) {
                sum+= nums[j];
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }

    // Time: O(n3), space: O(n)
    public static int maxSubArrayBruteForceWorst(int[] nums) {

        if(nums.length == 1)
            return nums[0];

        if(nums.length == 2) {

            int sum = nums[0] + nums[1];

            if(sum > nums[0]) {
                if(sum> nums[1])
                    return sum;
                else
                    return nums[1];
            } else if(nums[0] > nums[1]) {
                return nums[0];
            } else {
                return nums[1];
            }
        }

        int startIndex = 0, endIndex;
        int maxSum =Integer.MIN_VALUE;

        while(startIndex < nums.length) {
            endIndex = startIndex;

            while(endIndex <nums.length) {
                int sum = 0;

                for(int i=startIndex;i<=endIndex; i++) {

                    sum = sum + nums[i];
                }

                if(sum > maxSum) {
                    maxSum = sum;
                }
                endIndex++;
            }
            startIndex++;
        }
        return maxSum;
    }
}
