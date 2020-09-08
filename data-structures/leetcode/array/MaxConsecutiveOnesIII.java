package array;

//LC-1004
public class MaxConsecutiveOnesIII {

    //Time Complexity - O(N)
    //Space Complexity - O(1)
    public int longestOnes(int[] A, int K) {
        int zeroCount = 0;// zero count in current window
        int start = 0;// slow pointer
        int res = 0;
        for(int end=0;end<A.length;end++){
            if(A[end] == 0){// move forward j, if current is 0, increase the zeroCount
                zeroCount++;
            }
            // when current window has more than K, the window is not valid any more
            // we need to loop the slow pointer until the current window is valid
            if(zeroCount > K){
                if(A[start] == 0){
                    zeroCount--;
                }
                start++;
            }
            // everytime we get here, the current window is valid
            res=Math.max(res,end-start+1);
        }
        return res;
    }
}
