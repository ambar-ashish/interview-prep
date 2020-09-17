package array;

//LC-670
public class MaximumSwap {

    //The idea is straightforward, as we can simply scan the digits backward
    // and record the position of the largest digit when it first appears.
    //Next time we scan the digits from left to right and find the first digit
    // that is less than max to do the swap.
    public int maximumSwapAnotherSolution(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        final int n = digits.length;

        int[] maxIdx = new int[n];
        maxIdx[n-1] = n-1;

        //Traverse R->L
        for (int i = digits.length - 2; i >= 0; i--) {
            //Find the maximum number to the right of a number (from the right)
            //Note" If the digits are equal, then we want the righter index, righter=better
            maxIdx[i] = digits[i] > digits[maxIdx[i+1]] ? i : maxIdx[i+1];
        }

        //Traverse L->R
        for (int i = 0; i < digits.length; i++) {
            //If there is number higher than current number in the right, swap it
            if (digits[i] != digits[maxIdx[i]]) {
                char tmp = digits[i];
                digits[i] = digits[maxIdx[i]];
                digits[maxIdx[i]] = tmp;
                return Integer.parseInt(String.valueOf(digits));
            }
        }

        return num;
    }

    //Greedy Approach
    //Time Complexity - O(N)
    //Space Complexity - O(N)
    public int maximumSwap(int num) {
        char[] A = Integer.toString(num).toCharArray();
        int[] last = new int[10];
        for (int i = 0; i < A.length; i++) {
            last[A[i] - '0'] = i;
        }

        for (int i = 0; i < A.length; i++) {
            for (int d = 9; d > A[i] - '0'; d--) {
                if (last[d] > i) {
                    char tmp = A[i];
                    A[i] = A[last[d]];
                    A[last[d]] = tmp;
                    return Integer.valueOf(new String(A));
                }
            }
        }
        return num;
    }
}
