package twopointers;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSumZero {

    public static void main(String[] args) {

        int[] a ={ 1, -4, 0, 0, 5, -5, 1, 0, -2, 4, -4, 1, -1, -4, 3, 4, -1, -1, -3 };

        ArrayList<Integer> list = new ArrayList<>();

        for(int i:a) {
            list.add(i);
        }

        threeSum(list);

    }

    public static ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {

        ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();

        for(int i=0; i<A.size(); i++) {
            for(int j=0; j<A.size(); j++) {
                for(int k=0; k<A.size(); k++) {

                    if(i!=j && i!=k && j!=k && (A.get(i)+A.get(j)+A.get(k) == 0)) {
                        ArrayList<Integer> list = new ArrayList<>();
                        fillIncreasingOrder(A.get(i), A.get(j), A.get(k), list);
                        ansList.add(list);
                    }
                }
            }
        }

        return ansList;
    }

    private static void fillIncreasingOrder(int a, int b, int c, ArrayList<Integer> list) {
        if(a < b && a < c) {
            list.add(a);
            if(b < c)
                list.add(b);
            else
                list.add(c);
        } else if(b < a && b < c) {
            list.add(b);
            if(a < c)
                list.add(a);
            else
                list.add(c);
        } else if(c < a && c < b) {
            list.add(c);
            if(a < b)
                list.add(a);
            else
                list.add(b);
        }
    }
}
