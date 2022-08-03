package backtracking;

import java.util.ArrayList;

/*
    Given a array of integers A of size N and an integer B.

    Return number of non-empty subsequences of A of size B having sum <= 1000.

    constraints:
    1 <= N <= 20
    1 <= A[i] <= 1000
    1 <= B <= N

    A = [1, 2, 8]
    B = 2

    output:
    3
    subsequence {1, 2}, {1, 8}, {2, 8}

    approach:
    build all the possible combination of subsequence, go over each element, you either include that element
    in the subsequence or not include that in subsequence

    tc: (n * 2^n)
    sc: (2n)

    optimization,
    tc: O(2^n)
    sc: O(h), where h is the height of the tree, which is n, if n = 2, there are two function calls active in stack at one point
 */
public class Sixlets {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(8);
        int B = 2;

        ArrayList<Integer> container = new ArrayList<>();
        System.out.println(backtracking(container, B, A, 0));
        System.out.println(optimizedBacktracking(A, B,0,0,0));
    }

    // tc: O(2^n)
    // sc: O(h), where h is the height of the tree, which is n, if n = 2, there are two function calls active
    private static int optimizedBacktracking(ArrayList<Integer> list, int n, int index, int size, int sum) {

        if(size > 1000)
            return 0;

        if(index == list.size()) {
            if(size == n && sum <= 1000) {
                return 1;
            }
            return 0;
        }

        int ans = 0;

        ans = ans + optimizedBacktracking(list, n, index+1, size, sum);

        sum = sum + list.get(index);
        size++;
        ans = ans + optimizedBacktracking(list, n, index+1, size, sum);
        sum = sum - list.get(index);
        size--;

        return ans;
    }

    // tc: O(n * 2^n)
    // sc: h of the tree function calls in stack, which is n, O(n + n) , another n for size of container
    private static int backtracking(ArrayList<Integer> container, int n, ArrayList<Integer> list, int index) {

        if (index == list.size()) {

            if (container.size() == n) {
                int sum = 0;
                for (int i : container) {
                    sum = sum + i;
                }

                if (sum != 0 && sum <= 1000)
                    return 1;
                else
                    return 0;
            }
            return 0;
        }

        int ans = 0;

        ans = ans + backtracking(container, n, list, index + 1);

        container.add(list.get(index));
        ans = ans + backtracking(container, n, list, index + 1);
        container.remove(container.size() - 1);

        return ans;
    }
}
