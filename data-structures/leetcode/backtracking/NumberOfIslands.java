package backtracking;

import java.util.LinkedList;

//LC-200
public class NumberOfIslands {

    //In these kind of questions, we can modify the given grid to traverse back and forth and get the solution.
    //But the interviewer can put a condition that the given grid is immutable, then we can got with one of the approach
    //where we will create are boolean matrix with the same dimensions of given grid(Though this increases the space complexity).

    //DFS approach
    //Time complexity : O(M×N) where M is the number of rows and N is the number of columns.
    //Space complexity : worst case O(M×N) in case that the grid map is filled with lands where DFS goes by M×N deep.
    public int numIslandsUsingDFS(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for(int i=0; i<row; i++){
            for(int j=0 ; j<col ; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j){
        if(!isValid(grid, i, j)){
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i+1, j);//searching down
        dfs(grid, i-1, j);//searching up
        dfs(grid, i, j+1);//searching right
        dfs(grid, i, j-1);//searching left
    }

    public boolean isValid(char[][] grid, int i, int j){
        if(i>=grid.length || i < 0 || j>=grid[0].length || j<0 || grid[i][j] == '0'){
            return false;
        }
        return true;
    }

    //BFS approach
    //Time complexity : O(M×N) where M is the number of rows and N is the number of columns.
    //Space complexity : O(min(M,N)) because in worst case where the grid is filled with lands,
    // the size of queue can grow up to min(M,N).
    public int numIslandsUsingBFS(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    bfs(grid,i,j);
                    count++;
                }
            }
        return count;
    }

    private void bfs(char[][] grid,int x, int y){
        grid[x][y]='0';
        int n = grid.length;
        int m = grid[0].length;
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        while(!queue.isEmpty())
        {
            int[] temp = queue.poll();
            int i = temp[0];
            int j = temp[1];
            if(isValid(grid, i+1, j))//searching down
            {
                queue.offer(new int[]{i+1,j});
                grid[i+1][j]='0';
            }
            if(isValid(grid, i-1, j))//searching up
            {
                queue.offer(new int[]{i-1,j});
                grid[i-1][j]='0';
            }
            if(isValid(grid, i, j+1))//searching right
            {
                queue.offer(new int[]{i,j+1});
                grid[i][j+1]='0';
            }
            if(isValid(grid, i, j-1))//searching left
            {
                queue.offer(new int[]{i,j-1});
                grid[i][j-1]='0';
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},
                         {'1','1','0','1','0'},
                         {'1','1','0','0','0'},
                         {'0','0','0','0','0'}};

        NumberOfIslands numberOfIslands = new NumberOfIslands();
        System.out.println(numberOfIslands.numIslandsUsingDFS(grid));
        //Output - 1
    }
}
