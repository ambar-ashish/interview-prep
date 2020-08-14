package binarysearch;

//LC-69
public class SquareRootOfX {

    public int mySqrt(int x) {
        if(x < 2){
            return x;
        }
        int low = 2;
        int high = x/2;
        long num;
        while(low <= high){
            int mid = low + (high - low)/2;
            num = (long)mid * mid;
            if(num == x){
                return mid;
            }else if(num < x){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return high;
    }
}
