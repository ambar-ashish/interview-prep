package array;

//LC-66
public class PlusOne {

    //Time Complexity - O(N)
    //Space Complexity - O(1) when digits contains at least one not-nine digit,
    // and O(N) otherwise.
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i=digits.length-1; i>=0; i--){
            int sum = digits[i] + carry;
            carry = sum / 10;
            sum = sum % 10;
            digits[i] = sum;
        }
        if(carry == 1){
            int[] updated = new int[digits.length + 1];
            updated[0] = 1;
            return updated;
        }else{
            return digits;
        }
    }
}
