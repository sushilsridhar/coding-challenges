package arrays.numbers;
/*

You are given an array of distinct integers A, you have to find and return all elements in array which have at-least two greater elements than themselves.

NOTE: The result should have the order in which they are present in the original array.

 */
public class AtleastTwoElementsGreater {
    public static void main(String[] args) {

        int[] a = {11, 17, 100, 5};

        int[] b = solve(a);

        for(int i: b) {
            System.out.print(i+" ");
        }

    }

    public static int[] solve(int[] A) {

        int maxValue = Integer.MIN_VALUE;
        int secondMaxValue = Integer.MIN_VALUE;
        int[] outputArray = new int[A.length-2];

        for (int k : A) {
            if(k > maxValue) {
                secondMaxValue = maxValue;
                maxValue = k;
            } else if(k > maxValue) {
                secondMaxValue = k;
            }
        }

        int j=0;
        for (int k : A) {
            if (k != maxValue && k != secondMaxValue) {
                outputArray[j] = k;
                j++;
            }
        }

        return outputArray;
    }
}
