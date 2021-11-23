package gfg;

import java.util.ArrayList;

class Pair {

    int l,r;

    Pair(int l, int r) {
        this.l = l;
        this.r = r;
    }
}

public class Mountain_SubArray {

    public static void main(String[] args) {

        int a[] = {2,3,2,4,4,6,3,2};

        // Pair pairOne = new Pair(0,2);
        // Pair pairTwo = new Pair(1,3);

        int b[] = {20100, 18567, 28921, 1674, 15070, 22105, 30501, 27861, 26854, 23860, 16321, 15477, 11502, 10759, 4293, 3626};


        Pair pairOne = new Pair(13, 14);
        Pair pairTwo = new Pair(3,14);


        /*

        3 15
        7 11
        10 10
        9 9
        14 15
        11 11
        9 12
        7 10*/

       /* Its Correct output is:
        Yes
                Yes
        Yes
                Yes
        No
                No
        Yes
                Yes
        Yes
                Yes
        Yes
                Yes
        Yes
                Yes
        Yes
                Yes
*/
        ArrayList<Pair> queries = new ArrayList<>();
        queries.add(pairOne);
        queries.add(pairTwo);

        queries.add(new Pair(8,8));
        queries.add(new Pair(3,5));
        queries.add(new Pair(0,3));
        queries.add(new Pair(2,6));
        queries.add(new Pair(10,10));
        queries.add(new Pair(14,14));

        ArrayList<Boolean> result = bruteForce(b, b.length, queries, queries.size());

        for(boolean r: result) {
            System.out.println(r);
        }
    }

    private static ArrayList<Boolean> bruteForce(int[] a, int n, ArrayList<Pair> queries, int q) {

        ArrayList<Boolean> result = new ArrayList<Boolean>();


        for(int i=0; i<q; i++) {

            boolean isMountain = true;

            int l = queries.get(i).l;
            int r = queries.get(i).r;

            int middlePoint = 0;

            for(int k=l; k<r; k++) {

                if(a[k] < a[k+1]) {
                    continue;
                }
                else {
                    middlePoint = a[k];
                    break;
                }
            }

            if(middlePoint!=0) {
                for(int j=l; j<=r; j++) {

                    if(a[j] <= middlePoint) {
                        continue;
                    }
                    else {
                        isMountain = false;
                        break;
                    }
                }
            }

            result.add(isMountain);
        }

        return result;
    }
}
