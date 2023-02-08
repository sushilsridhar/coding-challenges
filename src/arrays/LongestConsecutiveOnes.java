package arrays.numbers;

/*
    Given a binary string A. It is allowed to do at most one swap between any 0 and 1.
    Find and return the length of the longest consecutive 1’s that can be achieved.

    Input 1:
    A = "111000"
    Output 1:
        3

    Input 2:
        A = "111011101"
    Output 2:
        7

    TODO add approach

    tc: O(n)
 */
public class LongestConsecutiveOnes {

    public static void main(String[] args) {

    }

    private static int solution(String A) {
        int n = A.length();
        int[] left = new int[n];
        int[] right = new int[n];

        int count = 0;
        int totalNumberOfOnes = 0;
        int ans = 0;

        for(int i=0; i<n; i++) {
            if(A.charAt(i) == '1') {
                count++;
                left[i] = count;
                totalNumberOfOnes++;
                ans = Math.max(ans, count);
            } else {
                count = 0;
                left[i] = count;
            }
        }

        count = 0;
        for(int i=n-1; i>=0; i--) {
            if(A.charAt(i) == '1') {
                count++;
                right[i] = count;
            } else {
                count = 0;
                right[i] = count;
            }
        }

        for(int i=1; i<n-1; i++) {
            if(A.charAt(i) == '0') {
                int numberOfConsecutiveOnesOnLeftAndRightOfI = left[i-1] + right[i+1];
                int totalOnesAfterOneSwapping = 0;

                if(numberOfConsecutiveOnesOnLeftAndRightOfI < totalNumberOfOnes) {
                    totalOnesAfterOneSwapping = numberOfConsecutiveOnesOnLeftAndRightOfI + 1;
                } else {
                    totalOnesAfterOneSwapping = numberOfConsecutiveOnesOnLeftAndRightOfI;
                }
                ans = Math.max(ans, totalOnesAfterOneSwapping);
            }
        }

        return ans;
    }

    // solution by TA
    public int solve(String A) {
        int n = A.length();
        int[] left = new int[n];
        int[] right = new int[n];

        int count = 0;
        int total=0;
        int ans=0;
        for(int i=0; i<n; i++) {
            if(A.charAt(i) == '1')
            {
                count++;
                left[i] = count;
                total++;
                ans=Math.max(ans,count);
            } else {
                count = 0;
                left[i] = count;
            }
        }

        count = 0;
        for(int i=n-1; i>=0; i--) {
            if(A.charAt(i) == '1') {
                count++;
                right[i] = count;
            } else {
                count = 0;
                right[i] = count;
            }
        }

        ans = Math.max(ans,Math.max(left[n-1],right[0]));

        for(int i=1; i<n-1; i++) {
            if(A.charAt(i) == '0') {
                int totalOnes = 0;
                if(total>left[i-1]+right[i+1])
                    totalOnes = left[i-1] + right[i+1] + 1;
                else
                {
                    totalOnes = left[i-1] + right[i+1];
                }

                ans = Math.max(ans, totalOnes);
            }
        }

        return ans;
    }
}
