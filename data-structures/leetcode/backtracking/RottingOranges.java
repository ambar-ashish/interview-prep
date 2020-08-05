package backtracking;

import java.util.LinkedList;
import java.util.Queue;

//LC-994
public class RottingOranges {

    //Time Complexity: O(N), where  is the size of the grid.
    //Space Complexity: O(N), where  is the size of the grid.
    public static int orangesRotting(int[][] grid) {
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
                    q.add(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        int days = 0;
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!q.isEmpty() && freshOranges > 0) {
            int queueSize = q.size();
            for (int i = 0; i < queueSize; i++) {
                int[] node = q.poll();
                for (int[] dir : directions) {
                    int x = node[0] + dir[0];
                    int y = node[1] + dir[1];
                    if (x < 0 || y < 0 || x >= row || y >= column || grid[x][y] == 0 || grid[x][y] == 2) {
                        continue;
                    }
                    grid[x][y] = 2;
                    q.offer(new int[]{x, y});
                    freshOranges--;
                }
            }
            days++;
        }
        return freshOranges == 0 ? days : -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},
                        {1,1,0},
                        {0,1,1}};

        System.out.println(orangesRotting(grid));
    }
}
