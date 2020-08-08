package backtracking;

import java.util.LinkedList;
import java.util.Queue;

//LC-490
public class TheMaze {

    //Blend of both BFS and DFS
    //Ball will not stop until hits the wall - DFS
    //After hitting the wall, the ball can go in any of the four direction - BFS
    //Time Complexity - O(m*n) where m and n are no rows and columns respectively where worst case we have to travel all the nodes
    //Space Complexity - O(m*n) where in worst case queue can grow up to m*n size
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] moves = new int[][] {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        queue.offer(start);

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == destination[0] && cur[1] == destination[1]) {
                return true;
            }
            if (visited[cur[0]][cur[1]])
                continue;
            visited[cur[0]][cur[1]] = true;
            for (int[] move : moves) {
                int x = cur[0], y = cur[1];
                while (isValid(maze, x, y)) {
                    x += move[0];
                    y += move[1];
                }
                // Back to validate point.
                x -= move[0];
                y -= move[1];
                // Adding the new start point.
                queue.offer(new int[] {x, y});
            }
        }
        return false;
    }

    private boolean isValid(int[][] maze, int x, int y) {
        return x >= 0 && y >= 0 && x<maze.length && y<maze[0].length && maze[x][y]==0;
    }

    public static void main(String[] args) {
        int[][] maze = {{0,0,1,0,0},
                        {0,0,1,0,0},
                        {0,0,1,0,0},
                        {0,0,1,0,0},
                        {0,0,1,0,0}};
        int[] start = {0,4};
        int[] destination = {3,2};
        TheMaze theMaze = new TheMaze();
        System.out.println(theMaze.hasPath(maze, start, destination));//false
    }
}
