package hashing;

import java.util.ArrayList;
import java.util.HashMap;

/*
    Given two integer array A and B of size N and M respectively. Your task is to find all the common elements in both the array.

    NOTE:
    Each element in the result should appear as many times as it shows in both arrays.
    The result can be in any order.

    To convert from ArrayList to int[], primitive array
    list.stream().mapToInt(ele->ele).toArray();

    Time complexity: O(n+m), where n and m are length of array A and B
    Space complexity: case 1. O(n) + O(1), both arrays are different
                      case 2. O(n) + O(m), both arrays are same
                      max(n,m) is space complexity
 */
public class CommonElements {

    public static void main(String[] args) {

        int[] a = {2, 1, 4, 10};
        int[] b = {3, 6, 2, 10, 10};

        int[] r = solve(a, b);
        for(int c: r) {
            System.out.print(c+" ");
        }
    }

    public static int[] solve(int[] A, int[] B) {

        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int k : A) {
            if (map.containsKey(k)) {
                map.put(k, map.get(k) + 1);
            } else {
                map.put(k, 1);
            }
        }

        for (int j : B) {
            if (map.containsKey(j) && map.get(j) != 0) {
                map.put(j, map.get(j) - 1);
                list.add(j);
            }
        }

        return list.stream().mapToInt(ele->ele).toArray();
    }
}
