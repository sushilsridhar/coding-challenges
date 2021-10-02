package bitmanipulation;

public class BinaryAddition {

    public static void main(String[] args) {

        System.out.println(addBinary("1010110111001101101000","1000011011000000111100110"));

    }

    public static String addBinary(String A, String B) {

        int Alen = A.length();
        int Blen = B.length();
        int noOfZerosToAppend=0;

        if(Alen > Blen) {
            noOfZerosToAppend = Alen - Blen;

            while(noOfZerosToAppend > 0) {
                B = "0" + B;
                noOfZerosToAppend--;
            }
        } else if(Blen > Alen) {
            noOfZerosToAppend = Blen - Alen;
            while(noOfZerosToAppend > 0) {
                A = "0" + A;
                noOfZerosToAppend--;
            }
        }

        int carry = 0;
        String result = "";

        if(A.length() == B.length()) {

            for(int i=A.length()-1; i>=0; i--) {
                int sum = (Character.getNumericValue(A.charAt(i)) + Character.getNumericValue(B.charAt(i)) + carry)%2;
                carry = (Character.getNumericValue(A.charAt(i)) + Character.getNumericValue(B.charAt(i)) + carry)/2;
                result =  sum + "" + result;
            }
        }
        return result;
    }

}
