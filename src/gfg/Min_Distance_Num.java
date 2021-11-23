package gfg;

/* minimium distance between two numbers */

public class Min_Distance_Num {
    public static void main(String[] args) {

        int a[] = { 3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3};

        int x = 3, y = 6;

        int b[] = { 3, 5, 4, 2, 6, 3, 0, 0, 5, 6, 8, 3 };


        System.out.println(bruteForce(a, a.length, x, y));
        System.out.println(bestSolution(b, b.length, x, y));
    }


    /*
     *  o(n), where n is length of the array
     */
    private static int bestSolution(int[] a, int n, int x, int y) {

        int i = 0, prev = 0, min_dist = Integer.MAX_VALUE;

        for(; i<n; i++){

            if(a[i] == x || a[i] == y) {
                prev = i;
                break;
            }
        }

        for(; i<n; i++) {

            if(a[i] == x || a[i] == y) {

                if((a[i] != a[prev]) && (i-prev < min_dist)) {
                    min_dist = i - prev;
                    prev = i;
                } else {
                    prev = i;
                }
            }
        }

        return min_dist;
    }

    /*
    *   o(n2), where n is the length of the array
    */
    private static int bruteForce(int[] a, int n, int x, int y) {

        int minDist = -1;

        for(int i=0; i<n; i++) {
            for(int j = i+1; j<n; j++) {

                if( (a[i] == x && a[j] == y) || (a[j] == x && a[i] == y) && minDist > Math.abs(i-j)){
                    minDist = Math.abs(i-j);
                }
            }
        }

        return minDist;
    }
}
