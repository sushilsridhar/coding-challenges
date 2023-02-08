package arrays.numbers;

import java.util.*;
import java.util.stream.Collectors;

public class CountDuplicatesInArray {

    public static void main(String[] args) {

        //int a[] = {1, 10, 20, 1, 25, 1, 10, 30, 25, 1};

        int a[] = {1, 2, 3, 3};

        List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());

        System.out.println(solve(list));

        System.out.println(solveWithOutHashMap(list));
    }

    public static int solveWithOutHashMap(final List<Integer> A) {

        int ans = 0;

        for(int i=0; i<A.size(); i++) {
            for(int j=i+1; j<A.size(); j++) {
                if(A.get(i) == A.get(j)) {
                    ans++;
                    break;
                }
            }
        }

        return ans;
    }

    public static int solve(final List<Integer> A) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<A.size(); i++) {
            int ele = A.get(i);
            if(map.containsKey(ele)) {
                map.put(ele, map.get(ele)+1);
            } else {
                map.put(ele, 1);
            }
        }

        int r = 0;

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int eleCount = entry.getValue();
            if(eleCount > 1) {
                r = r + eleCount - 1;
            }
        }

        return r;
    }

}
