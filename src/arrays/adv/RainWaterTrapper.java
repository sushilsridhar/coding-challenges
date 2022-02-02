package arrays.adv;

/*
    Given an array of size n, a[i] is the height of the object, width of every object is 1 (same),
    find the total amount of rain water trapped

          |
    |     |
    |_____|

    left is 2, right is 3, maximum height of water this tank can hold is 2, min(2,3)
    object a is placed at index 1

                |
     |______    |
     |__A__|____|
        0     1

    object A of height 1 is placed at index 0, maximum height of water index 0 can hold is
    min(left max height, right max height) --> min(2,3) --> 2
    since object A of height 1 is present at index 0 --> 2 - object height --> 1 , is the total amount of water that can be stored

    at index 1, no objects are there, min(2,3) --> 2 - 0 --> 2 is max amount of water that can stored

    leftmax - start from left to right  (0 to i)
    rightmax - start from right to left (i to n-1)
 */
public class RainWaterTrapper {

    public static void main(String[] args) {
                 //0  1  2  3  4  5  6  7
        int[] a = {1, 2, 4, 3, 0, 2, 1, 3};
        //leftmax: 1  2  4  4  4  4  4  4
        //rightmax 4  4  4  3  3  3  3  3

        System.out.println(solution(a));
    }

    // tc: O(n+n+n), sc: O(n+n)
    private static int solution(int[] a) {
        int n = a.length;
        int[] leftMaxArray = new int[n];
        int[] rightMaxArray = new int[n];
        int max = 0;

        for(int i=0; i<n; i++) {
            max = Math.max(max, a[i]);
            leftMaxArray[i] = max;
        }

        max = 0;
        for(int i=n-1; i>=0; i--) {
            max = Math.max(max, a[i]);
            rightMaxArray[i] = max;
        }
        int sum = 0;
        for(int i=0; i<n; i++) {
            sum = sum + Math.min(leftMaxArray[i], rightMaxArray[i]) - a[i];
        }

        return sum;
    }
}
