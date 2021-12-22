package maths;

/*
    JosephusProblem

    N people standing in circle, person 1 kills person to its right side and passes the knife to the next available person to his/her right,
    find the last person standing

    observation - if N is power of 2, whoever starts will win

    N=11, nearest power of 2 is 8, it takes 3 kills to reach 8 alive persons playing.

    11-->8 , 3 kills , 1 + 2 * 3 = 7, after 3kills, the game starts with 7, since 8 members are alive now, which is power of 2,
    the winner is 7.

 */
public class JosephusProblem {

    public static void main(String[] args) {

        int n = 11;

        System.out.println(solution(n));
        System.out.println(solution(100)); // 73
        System.out.println(solution(31)); // 31
        System.out.println(solution(13)); // 11

    }

    private static long solution(int n) {

        long powerOf2 = 1;
        long prevPowerOf2 = 1;
        for(int i=1; powerOf2<=n; i++) {
            prevPowerOf2 = powerOf2;
            powerOf2 = powerOf2 * 2;
        }

        long kills = n - prevPowerOf2;

        return 1+ 2 * kills;
    }
}
