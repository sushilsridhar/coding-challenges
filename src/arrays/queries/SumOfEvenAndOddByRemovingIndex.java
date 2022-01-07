package arrays.queries;
/*
    Technique: Prefix Sum

    Ways to Make a Fair Array in leetcode

    Input: nums = [2,1,6,4]
    Output: 1
    Explanation:
    Remove index 0: [1,6,4] -> Even sum: 1 + 4 = 5. Odd sum: 6. Not fair.
    Remove index 1: [2,6,4] -> Even sum: 2 + 4 = 6. Odd sum: 6. Fair.
    Remove index 2: [2,1,4] -> Even sum: 2 + 4 = 6. Odd sum: 1. Not fair.
    Remove index 3: [2,1,6] -> Even sum: 2 + 6 = 8. Odd sum: 1. Not fair.
    There is 1 index that you can remove to make nums fair.

    steps:
    1. calculate prefix sum array for even and odd numbers
    2. In the example, 2 1 6 4, before removing 1, evensum = 8, oddsum = 5
    index - 0 1 2 3    0 1 2
            2 1 6 4    2 6 4

    after removing 1, the evensum and oddsum before 1 remains same, but the evensum and oddsum after 1, switch places
                     0 1 2 3
    evenPrefixSum = [2 2 8 8]
    oddPrefixSum =  [0 1 1 5]

    evenSum = sum of all even numbers before 1 + sum of all odd numbers after 1 - sum of all odd numbers upto 1
            = 2 + 5 - 1 = 6

    oddSum = sum of all odd numbers before 1 + sum of all even numbers after 1 - sum of all even numbers upto 1
           = 0 + 8 - 2 = 6

    evenSum = evenPrefixSum[i-1] + oddPrefixSum[n-1] - oddPrefixSum[i];
    oddSum = oddPrefixSum[i-1] + evenPrefixSum[n-1] - evenPrefixSum[i];

    TA's explanation:
    even[i]= 6+ even[i-2] = 8
    odd[i]= odd[i-1] = 1;
    odd[0]=0
    odd[1]=1
    odd[2]=1
    odd[3]=5
    oddsum before 1 = 0
    evensum before 1= 2

    oddsum after 1 = 5
    evensum after 1= 6

    after omitting 1:
    odd sum = oddsum before 1 + evensum after 1 = 6
    even sum = evensum before 1 + oddsum after 1 = 6
 */
public class SumOfEvenAndOddByRemovingIndex {
    public static void main(String[] args) {
                //  0  1  2  3  4  5  6
        int []A = { 1, 2, 3, 7, 1, 2, 3 }; // output 1

        System.out.println(waysToMakeFair(A));
    }

    public static int waysToMakeFair(int[] nums) {

        int n = nums.length;

        if(n == 1) {
            return 1;
        }

        if(n < 3) {
            return 0;
        }

        int evenSum = 0, oddSum = 0, c = 0;
        int[] evenPrefixSum = new int[n];
        int[] oddPrefixSum = new int[n];

        evenPrefixSum[0] = nums[0];
        oddPrefixSum[0] = 0;

        for(int i=1; i<n; i++) {

            if(i%2==0) {
                evenPrefixSum[i] = evenPrefixSum[i-1] + nums[i];
                oddPrefixSum[i] = oddPrefixSum[i-1];
            } else {
                evenPrefixSum[i] = evenPrefixSum[i-1];
                oddPrefixSum[i] = oddPrefixSum[i-1] + nums[i];
            }
        }

        evenSum = oddPrefixSum[n-1];
        oddSum = evenPrefixSum[n-1] - evenPrefixSum[0];

        if(evenSum == oddSum) {
            c++;
        }

        for(int i=1; i<n; i++) {

            evenSum = evenPrefixSum[i-1] + oddPrefixSum[n-1] - oddPrefixSum[i];
            oddSum = oddPrefixSum[i-1] + evenPrefixSum[n-1] - evenPrefixSum[i];

            if(evenSum == oddSum) {
                c++;
            }
        }

        return c;

    }
}

/*
 int main()
    {
        int n,i;
        cin>>n;
        int a[n];
        for(i=0;i<n;i++)
        {
            cin>>a[i];
        }
        int even[n];
        int odd[n];
        for(i=0;i<n;i++)
        {
            if(i==0)
            {
                even[i]=a[i];
                odd[i]=0;
            }
            else
            {
                if(i%2==0)
                {
                    even[i]=a[i]+even[i-2];
                    odd[i]=odd[i-1];
                }
                else
                {
                    odd[i]=a[i]+odd[i-2];
                    even[i]=even[i-1];
                }
            }
        }

        for(i=0;i<n;i++)
        {
            int oddsum,evensum;
            if(i==0)
            {
                oddsum= even[n-1]-even[0];
                evensum=odd[n-1]-odd[0];
            }
            else
            {
                oddsum= odd[i-1]+ even[n-1]-even[i];
                evensum= even[i-1] +odd[n-1]-odd[i];
            }
            if(evensum==oddsum)
            {
                cout<<i;
                return;
            }
        }
    }
 */

