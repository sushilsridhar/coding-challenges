package matrix;

/*
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}

    rotate 90 degree,
    {7, 4, 1},
    {8, 5, 2},
    {9, 6, 3}

    steps:
    1) take transpose
    2) reverse every row
 */
public class RotateSquareMatrix90Degree {

    public static void main(String[] args) {

        int [][] a =  { {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}};

        int[][] r = solve(a);

        for(int i=0; i<r.length; i++) {
            for(int j=0; j<r[0].length; j++) {
                System.out.print(r[i][j]+" ");
            }
            System.out.println("");
        }
    }

    private static int[][] solve(int[][] a) {

        // transpose
        for(int i=0; i<a.length; i++) {
            for(int j=0; j<i; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }

        // reverse each row
        for(int i=0; i<a.length; i++) {
            int[] arr = a[i];
            int start=0, end = a[i].length-1;

            while(start<end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }

        return a;
    }
}
