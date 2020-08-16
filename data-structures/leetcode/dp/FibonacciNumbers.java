package dp;

public class FibonacciNumbers {

    //Top-down DP with Memoization
    //Time Complexity - O(n)
    //Space Complexity - O(n)
    public int fibonacci(int n){
        int[] dp = new int[n+1];
        return fibonacciRecursive(dp, n);
    }

    public int fibonacciRecursive(int[] dp, int n){
        if(n < 2){
            return n;
        }
        if(dp[n] == 0){
            dp[n] = fibonacciRecursive(dp, n-1) + fibonacciRecursive(dp, n-2);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        FibonacciNumbers fibonacciNumbers = new FibonacciNumbers();
        System.out.println("6th Fibonacci is ---> "+fibonacciNumbers.fibonacci(6));
    }
}

//public int CalculateFibonacci(int n) {
//    if(n < 2)
//      return n;
//    return CalculateFibonacci(n-1) + CalculateFibonacci(n-2);
//  }
// The time complexity of the commented original code without dp is O(2^n) as we are making two recursive calls in the same function.
// The space complexity O(n) which is used to store the recursion stack.
