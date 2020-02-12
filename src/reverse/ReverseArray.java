package reverse;

/*
   array length divided by 2 gives number of swaps required
   swap start index with last index, continue until number of swaps.
*/
public class ReverseArray {

    public static void main(String [] args) {

        int arr[] = {1, 2, 3, 4, 5, 6};

        int number_of_swaps_required = (arr.length)/2;

        for(int start_index = 0; start_index< number_of_swaps_required; start_index++) {
            int last_index = arr.length -start_index -1;

            int temp = arr[start_index];
            arr[start_index] = arr[last_index];
            arr[last_index] = temp;
        }

        for(int i : arr) {
            System.out.println(i);
        }
    }
}
