package arrays;

public class Sorted_Sub_Sequence {
    public static void main(String[] args) {

        int[] a = { 1, 2, 1, 4, 5,11, 10, 6};

        //int[] a = { 1, 1, 1, 3};

        boolean found = bruteForce(a, a.length);
        System.out.println(found);
    }

    private static boolean bruteForce(int[] a, int n) {

        boolean found = false;

        for(int i=0; i<n; i++) {

            int element = a[i];
            int sequenceCount = 1;

            for(int j=i+1; j<n; j++) {

                if(a[j] == element+1) {
                    sequenceCount++;
                    element = a[j];
                }
            }

            if(sequenceCount >= 3) {
                found = true;
                break;
            }
        }

        return found;

    }
}
