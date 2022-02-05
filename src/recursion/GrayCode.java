package recursion;

import java.util.ArrayList;
import java.util.Collections;

/*
    The gray code is a binary numeral system where two successive values differ in only one bit.
    Given a non-negative integer A representing the total number of bits in the code, print the sequence of gray code.
    A gray code sequence must begin with 0.

    for A = 1, the gray code sequence is
    0
    1

    for A = 2,
    00 - 0
    10 - 2
    11 - 3
    01 - 1
    So, return [0,2,3,1]

    for A = 3,
    00 0
    10 0
    11 0
    01 0
    ----
    01 1
    11 1
    10 1
    00 1

    approach:
    1. divide into two parts, take the value and left shift by 1
    2. reverse the values and left shift by 1 + 1

    In general
    left shift operator --> multiply by 2
    right shift operator --> divide by 2

    0 --> left shift, 00
    1 --> left shift, 10 , decimal 2
 */
public class GrayCode {

    public static void main(String[] args) {

        ArrayList<Integer> arrayList = getGrayCodeSequence(2);

        for(Integer ele: arrayList) {
            System.out.print(ele+" ");
        }
    }

    private static ArrayList<Integer> getGrayCodeSequence(int n) {

        if(n == 1) {
            ArrayList<Integer> newArrayList = new ArrayList<>();
            newArrayList.add(0);
            newArrayList.add(1);
            return newArrayList;
        }

        ArrayList<Integer> prevSequence = getGrayCodeSequence(n-1);

        ArrayList<Integer> newArrayList = new ArrayList<>();
        for(Integer ele: prevSequence) {
            newArrayList.add(ele*2);
        }

        Collections.reverse(prevSequence);
        for(Integer ele: prevSequence) {
            newArrayList.add((ele*2)+1);
        }

        return newArrayList;
    }
}
