package practice;

public class Third_Largest {
    public static void main(String[] args) {

        int a[] = {5, 3, 4 ,1 ,2};

        System.out.println(naiveApproach(a, 5));

        System.out.println(averageApproach(a, 5));

        System.out.println(bestApproach(a, 5));
    }

    /* 0(n), where n is the lenght of the array */
    private static int bestApproach(int[] a, int l) {

        int largest = Integer.MIN_VALUE, second_largest = Integer.MIN_VALUE, third_largest = Integer.MIN_VALUE;

        for(int i=0; i<l; i++) {
            if(a[i] > largest) {
                third_largest = second_largest;
                second_largest = largest;
                largest = a[i];
            }
            else if(a[i] > second_largest) {
                second_largest = largest;
                largest = a[i];
            }
            else if(a[i] > third_largest) {
                third_largest = a[i];
            }
        }

        return third_largest;
    }


    /*  0(n) + 0(n) + 0(n) => 3n => time complexity o(n), where n is the length of the array */
    private static int averageApproach(int[] a, int l) {

        int largest = Integer.MIN_VALUE, second_largest = Integer.MIN_VALUE, third_largest = Integer.MIN_VALUE;

        for(int i=0; i<l; i++) {
            if(a[i] > largest) {
                largest = a[i];
            }
        }

        for(int j=0; j<l; j++) {
            if(a[j] > second_largest && a[j] < largest) {
                second_largest = a[j];
            }
        }

        for(int k=0; k<l; k++) {
            if(a[k] > third_largest && a[k] < second_largest) {
                third_largest = a[k];
            }
        }

        return third_largest;
    }


    /* o(n2), where n is length of array */
    private static int naiveApproach(int[] a, int l) {

        for(int i=0; i<l; i++) {
            for(int j = i+1; j<l; j++) {
                if(a[i] > a[j]) {
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }

        return a[l-3];
    }
}
