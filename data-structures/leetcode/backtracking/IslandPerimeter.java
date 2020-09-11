package backtracking;

//LC-463
public class IslandPerimeter {

    int res=0;

    public int islandPerimeter(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        boolean[][] b=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    dfs(grid,i,j,n,m,b);
                    return res;
                }
            }
        }
        return 0;
    }

    void dfs(int[][] grid,int x,int y,int n,int m, boolean[][] b){
        //this condition checks that if we are not able to move forward then add +1 to the perimeter
        if(x<0 || x>=n || y<0|| y>=m || grid[x][y] == 0){
            res++;
            return;
        }
        if(b[x][y])
            return;
        b[x][y]=true;
        dfs(grid,x,y+1,n,m,b);
        dfs(grid,x,y-1,n,m,b);
        dfs(grid,x-1,y,n,m,b);
        dfs(grid,x+1,y,n,m,b);
    }
}
