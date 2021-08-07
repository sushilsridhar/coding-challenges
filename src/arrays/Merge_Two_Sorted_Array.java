package arrays;

public class Merge_Two_Sorted_Array {

    public static void main(String[] args) {

        int[] arrayOne = {0, 3, 4, 31};
        int[] arrayTwo = {4, 6, 30};

        int[] mergedArray = mergeSortedArray(arrayOne, arrayTwo);

        for(int item: mergedArray) {
            System.out.print(item + " ");
        }
    }

    private static int[] mergeSortedArray(int[] arrayOne, int[] arrayTwo) {

        if(arrayOne.length == 0) {
            return arrayTwo;
        }

        if(arrayTwo.length == 0) {
            return arrayOne;
        }

        int[] mergedArray = new int[arrayOne.length + arrayTwo.length];
        int mergedArrayIndex = 0;
        int arrayOneIndex = 0;
        int arrayTwoIndex = 0;
        int arrayOneItem = arrayOne[arrayOneIndex];
        int arrayTwoItem = arrayTwo[arrayTwoIndex];

        while(arrayOneIndex < arrayOne.length && arrayTwoIndex < arrayTwo.length) {

            if(arrayOneItem < arrayTwoItem) {
                mergedArray[mergedArrayIndex] = arrayOneItem;
                mergedArrayIndex++;

                if(++arrayOneIndex < arrayOne.length)
                    arrayOneItem = arrayOne[arrayOneIndex];
            } else {
                mergedArray[mergedArrayIndex] = arrayTwoItem;
                mergedArrayIndex++;

                if(++arrayTwoIndex < arrayTwo.length)
                    arrayTwoItem = arrayTwo[arrayTwoIndex];
            }
        }

        if(arrayOneIndex == arrayOne.length) {
            for(int i = arrayTwoIndex; i<arrayTwo.length; i++) {
                mergedArray[mergedArrayIndex] = arrayTwo[i];
                mergedArrayIndex++;
            }
        }

        if(arrayTwoIndex == arrayTwo.length) {
            for(int i = arrayOneIndex; i<arrayOne.length; i++) {
                mergedArray[mergedArrayIndex] = arrayOne[i];
                mergedArrayIndex++;
            }
        }

        return mergedArray;
    }
}
