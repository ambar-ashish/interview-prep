package backtracking;

import java.util.LinkedList;
import java.util.Queue;

//LC-490
public class TheMaze {

    public static boolean hasPathBFS(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        int[] dx = new int[]{0, -1, 0, 1};
        int[] dy = new int[]{1, 0, -1, 0};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] curPos = queue.poll();
            if (curPos[0] == destination[0] && curPos[1] == destination[1]) {
                return true;
            }
            // try four direction until it hits the wall
            for (int direction = 0; direction < 4; direction++) {
                int nx = curPos[0], ny = curPos[1];
                while (nx >= 0 && nx < m && ny >= 0 && ny < n && maze[nx][ny] == 0) {
                    nx += dx[direction];
                    ny += dy[direction];
                }

                //back one step
                nx -= dx[direction];
                ny -= dy[direction];

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        return false;
    }

    //DFS is not working for all the LC test cases. Need to fix this
    public static boolean hasPathDFS(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0){
            return false;
        }
        if(dfs(maze, start[0], start[1], destination[0], destination[1])){
            return true;
        }else{
            return false;
        }
    }

    public static boolean dfs(int[][] maze, int i, int j, int x, int y){
        if(i==x && j==y){
            return true;
        }
        if(!isValid(maze, i, j)){
            return false;
        }
        maze[i][j] = 1;
        boolean foundPath = dfs(maze, i+1, j, x, y) || dfs(maze, i-1, j, x, y) ||
                dfs(maze, i, j+1, x, y) || dfs(maze, i, j-1, x, y);
        maze[i][j] = 0;
        return foundPath;
    }

    public static boolean isValid(int[][] maze, int i, int j){
        if(i<0 || i>=maze.length || j<0 || j>=maze[0].length || maze[i][j] == 1){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] maze = {{0,0,1,0,0},
                        {0,0,1,0,0},
                        {0,0,1,0,0},
                        {0,0,1,0,0},
                        {0,0,1,0,0}};
        int[] start = {0,4};
        int[] destination = {3,2};
        System.out.println(hasPathBFS(maze, start, destination));
    }
}
