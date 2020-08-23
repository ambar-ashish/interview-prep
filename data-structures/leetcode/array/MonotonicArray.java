package array;

//LC-896
public class MonotonicArray {

    //One Pass Solution
    public boolean isMonotonic(int[] A) {
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 0; i < A.length - 1; ++i) {
            if (A[i] > A[i+1])
                increasing = false;
            if (A[i] < A[i+1])
                decreasing = false;
        }
        return increasing || decreasing;
    }

    public boolean isMonotonicTwoPassSolution(int[] A) {
        if(A.length == 0){
            return true;
        }
        return isDecreasing(A) || isIncreasing(A);
    }

    public boolean isDecreasing(int[] A){
        for(int i=0; i<A.length-1; i++){
            if(A[i+1] > A[i]){
                return false;
            }
        }
        return true;
    }

    public boolean isIncreasing(int[] A){
        for(int i=0; i<A.length-1; i++){
            if(A[i+1] < A[i]){
                return false;
            }
        }
        return true;
    }
}
