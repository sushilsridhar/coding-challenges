package arrays;

public class Convert_To_Wave {
    public static void main(String[] args) {

        int[] a = {2, 4, 7, 8, 9, 10};

        convertToWave(a, a.length);

        for(int r: a) {
            System.out.print(r+" ");
        }
    }

    private static void convertToWave(int[] a,int n) {

        for(int i=0; i<n-1; i=i+2) {
            swap(a, i, i+1);
        }
    }

    private static void swap(int[] a, int x, int y) {

        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}

/*

since array is sorted array,

swap the even index element with the next index element to create the wave

 */
