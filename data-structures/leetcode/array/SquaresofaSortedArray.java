package array;

import java.util.Arrays;

//LC-977
public class SquaresofaSortedArray {

    public int[] sortedSquaresMySolution(int[] A) {
        int n = A.length;
        int[] out = new int[n];
        int i = 0, j = n - 1, k = n - 1;
        while(i < j){
            if(A[i]*A[i] >= A[j]*A[j]){
                out[k--] = A[i] * A[i];
                i++;
            }else{
                out[k--] = A[j] * A[j];
                j--;
            }
        }
        if(i==j){
            out[0] = A[i] * A[i];
        }
        return out;
    }

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

    //Time Complexity - O(N)
    //Space Complexity - O(N)
    public int[] sortedSquaresOptimized(int[] A) {
        int N = A.length;
        int j = 0;
        while (j < N && A[j] < 0)
            j++;
        int i = j-1;

        int[] ans = new int[N];
        int t = 0;

        while (i >= 0 && j < N) {
            if (A[i] * A[i] < A[j] * A[j]) {
                ans[t++] = A[i] * A[i];
                i--;
            } else {
                ans[t++] = A[j] * A[j];
                j++;
            }
        }
        while (i >= 0) {
            ans[t++] = A[i] * A[i];
            i--;
        }
        while (j < N) {
            ans[t++] = A[j] * A[j];
            j++;
        }
        return ans;
    }
}
