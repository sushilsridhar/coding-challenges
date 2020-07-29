package matrix;

/*
   o(rc) => where r is rows and c is columns
 */
public class Matrix_Addition {

    static int[][] add2arrays(int[][] m1, int[][] m2) {

        int[][] m3 = new int[m1.length][m1[0].length];


        for(int i=0 ; i<m1.length; i++) {

            for(int j=0; j<m1[0].length; j++) {

                m3[i][j] = m1[i][j] + m2[i][j];
            }
        }

        return m3;

    }

    public static void main(String []args) {

        int[][] m1 =  {
                {1,2,3, 4},
                {4,5,6,4},
                {7,8,9,4}
        };

        int[][] m2 =  {
                {1,2,3,4},
                {4,5,6,4},
                {7,8,9,4}
        };

        //given 2 2d arrays give me a new 2d array which is the sum of 2

        int m4[][] = add2arrays(m1,m2);

        for(int i=0 ; i<m4.length; i++) {
            for(int j=0; j<m4[0].length; j++) {

                System.out.print(m4[i][j]+" ");
            }
            System.out.println();
        }
    }
}

/**
 * 2        4  6  8
 * 8        10 12 8
 * 14435345 16 18 8
 */

// [1 2 3
//  4 5 6
//  7 8 9]

// [1 2 3
//  4 5 6
//  7 8 9]

// [2 4 6
//  8 10 12
//  14 16 18]
