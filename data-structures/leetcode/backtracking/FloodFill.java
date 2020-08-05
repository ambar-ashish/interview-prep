package backtracking;

//LC-733
public class FloodFill {

    //Time Complexity - O(N) where N is the number of pixels in the image. We might process every pixel.
    //Space Complexity - O(N), the size of the implicit call stack when calling dfs.
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image.length == 0 || image[sr][sc] == newColor) {
            return image;
        }
        int sourceColor = image[sr][sc];
        dfs(image, sr, sc, newColor, sourceColor);
        return image;
    }

    public static void dfs(int[][] image, int i, int j, int newColor, int sourceColor){
        //check validity
        if(i<0 || i>=image.length || j<0 || j>=image[i].length || image[i][j] != sourceColor){
            return;
        }
        image[i][j] = newColor;
        dfs(image, i+1, j, newColor, sourceColor);
        dfs(image, i-1, j, newColor, sourceColor);
        dfs(image, i, j+1, newColor, sourceColor);
        dfs(image, i, j-1, newColor, sourceColor);
    }

    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int[][] output = floodFill(image, 1, 1, 2);
        for(int i=0; i<output.length; i++){
            for(int j=0; j<output[i].length; j++){
                System.out.print(output[i][j]+" ");
            }
            System.out.println();
        }
        // Output: [[2,2,2],[2,2,0],[2,0,1]]
    }
}
