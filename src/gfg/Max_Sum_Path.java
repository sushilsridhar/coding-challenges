package gfg;

/*
    Time complexity, o(m+n), where m is length of arr1 and n is length of arr2

    Elements of both arrays are processed at same time, while loop runs for m+n times
 */
public class Max_Sum_Path {
    public static void main(String[] args) {

        int arr1[] = { 2, 3, 7, 10, 12, 15, 30, 34};
        int arr2[] = { 1, 5, 7, 8, 10, 15, 16, 19};

        // max sum path --> 1,5,7,8,10,12,15,30,34 = 122

        int result = findMaxPathSum(arr1, arr2);
        System.out.println(result);

    }

    private static int findMaxPathSum(int arr1[], int arr2[])
    {
        int i=0,j=0,result=0,sum1=0,sum2=0;

        while(i<arr1.length && j<arr2.length) {

            if(arr1[i] < arr2[j]) {
                sum1+= arr1[i];
                i++;
            }
            else if(arr1[i] > arr2[j]) {
                sum2+= arr2[j];
                j++;
            }
            else if(arr1[i] == arr2[j]) {

                result+= Math.max(sum1,sum2);
                result+= arr1[i];

                i++;
                j++;

                sum1=0;
                sum2=0;
            }
        }

        while(i<arr1.length) {
            sum1+= arr1[i];
            i++;
        }

        while(j<arr2.length) {
            sum2+= arr2[j];
            j++;
        }

        result+= Math.max(sum1,sum2);


        return result;
    }
}

/*

int arr1[] = { 2, 3, 7, 10, 12, 15, 30, 34};
int arr2[] = { 1, 5, 7, 8, 10, 15, 16, 19};

// max sum path --> 1,5,7,8,10,12,15,30,34 = 122

1. arr1[i] < arr2[j], add to arr1[i] to sum1
   arr1[j] < arr2[i], add to arr2[j] to sum2

   arr1[i] == arr2[j] , find max of sum1 and sum2 , add to result,

2. loop again

3. add remaining elements to sum1 and sum2, find max, that's the result

 */
