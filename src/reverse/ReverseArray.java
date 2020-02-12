package reverse;

/* array length divided by 2 gives number of swaps required
   swap start index with last index, continue until number of swaps.
*/
public class ReverseArray {

    public static void main(String [] args) {

        int arr[] = {1, 2, 3, 4, 5, 6};

        int number_of_swaps_required = (arr.length)/2;

        for(int index_one = 0; index_one< number_of_swaps_required; index_one++) {
            int index_two = arr.length -index_one -1;

            int temp = arr[index_one];
            arr[index_one] = arr[index_two];
            arr[index_two] = temp;
        }

        for(int i : arr) {
            System.out.println(i);
        }
    }
}
