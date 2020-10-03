package test;

import java.util.Arrays;

public class Knapsack {


    public int solveKnapsack(int[] profits, int[] weights, int capacity){
        int[][] dp = new int[profits.length][capacity+1];
        return solveKnapsackRecursive(profits, weights, capacity, 0, dp);
    }

    public int solveKnapsackRecursive(int[] profits, int[] weights, int capacity, int currentIndex, int[][] dp){
        if(capacity <=0 || currentIndex > profits.length - 1){
            return 0;
        }
        if(dp[currentIndex][capacity] == 0) {
            int profit1 = 0;
            if (weights[currentIndex] <= capacity) {
                profit1 = profits[currentIndex] + solveKnapsackRecursive(profits, weights, capacity - weights[currentIndex], currentIndex, dp);
            }
            int profit2 = solveKnapsackRecursive(profits, weights, capacity, currentIndex + 1, dp);
            dp[currentIndex][capacity] =  Math.max(profit2, profit1);
        }
        return dp[currentIndex][capacity];
    }

    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
        int[] profits = { 15, 50, 60, 90 };
        int[] weights = { 1, 3, 4, 5 };
        int maxProfit = ks.solveKnapsack(profits, weights, 8);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        /*maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);*/
    }
}
