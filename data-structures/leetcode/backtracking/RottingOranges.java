package backtracking;

import java.util.LinkedList;
import java.util.Queue;

//LC-994
public class RottingOranges {

    //Time Complexity: O(N), where  is the size of the grid.
    //Space Complexity: O(N), where  is the size of the grid.
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int row = grid.length;
        int column = grid[0].length;

        Queue<int[]> q = new LinkedList();
        int freshOranges = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});//Adding all the rotten oranges in the queue for bfs
                }
                if (grid[i][j] == 1) {
                    freshOranges++;//calculating the fresh oranges count to check them again at last
                }
            }
        }
        int days = 0;
        while (!q.isEmpty() && freshOranges > 0) {
            int queueSize = q.size();
            for (int i = 0; i < queueSize; i++) {
                int[] node = q.poll();
                int x = node[0];
                int y = node[1];
                if(isValid(grid, x+1, y))//searching down
                {
                    q.offer(new int[]{x+1,y});
                    grid[x+1][y] = 2;
                    freshOranges--;
                }
                if(isValid(grid, x-1, y))//searching up
                {
                    q.offer(new int[]{x-1,y});
                    grid[x-1][y] = 2;
                    freshOranges--;
                }
                if(isValid(grid, x, y+1))//searching right
                {
                    q.offer(new int[]{x,y+1});
                    grid[x][y+1] = 2;
                    freshOranges--;
                }
                if(isValid(grid, x, y-1))//searching left
                {
                    q.offer(new int[]{x,y-1});
                    grid[x][y-1] = 2;
                    freshOranges--;
                }
            }
            days++;
        }
        return freshOranges == 0 ? days : -1;
    }

    public boolean isValid(int[][] grid, int x, int y){
        if(x>=grid.length || x < 0 || y>=grid[0].length || y<0 || grid[x][y] == 0 || grid[x][y] == 2){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},
                        {1,1,0},
                        {0,1,1}};
        RottingOranges solution = new RottingOranges();
        System.out.println(solution.orangesRotting(grid));//4
    }
}
