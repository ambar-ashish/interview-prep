package array;

//LC-7
public class ReverseInteger {

    //Time Complexity - O(N) where N is the no of digits in the number
    //Space Complexity - O(1)
    public int reverse(int x) {
        long result =0;
        while(x != 0)
        {
            result = (result*10) + (x%10);
            if(result > Integer.MAX_VALUE) return 0;
            if(result < Integer.MIN_VALUE) return 0;
            x = x/10;
        }
        return (int)result;
    }
}
