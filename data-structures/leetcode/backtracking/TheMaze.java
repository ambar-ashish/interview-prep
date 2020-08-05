package backtracking;

//LC-490
public class TheMaze {

    //DFS is not working for all the LC test cases. Need to fix this
    public boolean hasPathDFS(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0){
            return false;
        }
        if(dfs(maze, start[0], start[1], destination[0], destination[1])){
            return true;
        }else{
            return false;
        }
    }

    public boolean dfs(int[][] maze, int i, int j, int x, int y){
        if(!isValid(maze, i, j)){
            return false;
        }
        if(i==x && j==y){
            return true;
        }
        maze[i][j] = 1;
        boolean foundPath = dfs(maze, i+1, j, x, y) || dfs(maze, i-1, j, x, y) ||
                dfs(maze, i, j+1, x, y) || dfs(maze, i, j-1, x, y);
        maze[i][j] = 0;
        return foundPath;
    }

    public boolean isValid(int[][] maze, int i, int j){
        if(i<0 || i>=maze.length || j<0 || j>=maze[0].length || maze[i][j] == 1){
            return false;
        }
        return true;
    }
}
