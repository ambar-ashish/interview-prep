package array;

import java.util.Arrays;

//LC-977
public class SquaresofaSortedArray {

    //Time Complexity - O(NlogN)
    //Space Complexity - O(1)
    public int[] sortedSquares(int[] A) {
        if(A.length == 0){
            return A;
        }
        for(int i=0; i<A.length; i++){
            A[i] = A[i]*A[i];
        }
        Arrays.sort(A);
        return A;
    }
}
