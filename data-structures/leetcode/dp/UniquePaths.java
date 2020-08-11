package dp;

//LC-62
public class UniquePaths {

    //Time Complexity = O(m*n)
    //Space Complexity = O(m*n)
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for(int i=0; i<dp.length; i++){
            dp[i][0] = 1;;
        }
        for(int i=0; i<dp[0].length; i++){
            dp[0][i] = 1;;
        }

        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[i].length; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    int count = 0;

    //This solution is correct but it will take a alot of time due to backtracking
    public int uniquePathsUsingBacktracking(int m, int n) {
        boolean[][] grid = new boolean[n][m];
        dfs(grid, 0, 0);
        return count;
    }

    public void dfs(boolean[][] grid, int i, int j){
        if(i==grid.length - 1 && j==grid[i].length - 1){
            count++;
            return;
        }
        if(!isValid(grid, i, j)){
            return;
        }
        grid[i][j] = true;
        dfs(grid, i, j+1);
        dfs(grid, i+1, j);
        grid[i][j] = false;
    }

    public boolean isValid(boolean[][] grid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j]){
            return false;
        }
        return true;
    }
}
