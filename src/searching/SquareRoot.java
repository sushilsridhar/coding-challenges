package searching;

public class SquareRoot {
    public static void main(String[] args) {

        long x = 5;

        //floorSqrt(x);

        long answer = solution(x);
        System.out.println(answer);

    }

    /* time complexity: o(log N), where N is the total number of elements <= x */
    private static long solution(long x) {

        if(x == 0 || x == 1) {
            return x;
        }

        long answer = 0, start = 1, end = x;

        while(start <= end) {

            long mid = (start + end)/2;

            if(mid*mid == x) {
                return mid;
            }

            if(mid*mid < x) {
                start = mid + 1;
                answer = mid;
            } else {
                end = mid - 1;
            }
        }

        return answer;
    }

    private static void floorSqrt(long x) {
        System.out.println(Math.round(Math.sqrt(x)));
    }
}

/*

The idea of binary search is to use the information that
the array is sorted
and reduce the time complexity to O(Log n)

*/

/*

1 2 3 4 5

start = 1 , end = 5

find mid, which is 3

3*3 is not 5 , so square root must be a value less than mid, hence end = mid - 1

start = 1 , end = 2

find mid, which is 1

1*1 is not 5, so increment start and save 1 as answer, hence start = mid +1 =2, ans =1

start = 2 , end = 2

2*2 is not 5, so increment start, start = 3, save answer as mid, answer = 2

so 2 is the floored square root of 5


*/