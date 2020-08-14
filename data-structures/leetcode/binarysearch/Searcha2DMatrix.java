package binarysearch;

//LC-74
public class Searcha2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;

        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m - 1, row = -1;
        while(l <= r){
            int mid = (l+r)/2;
            if(matrix[mid][0] < target){
                l = mid + 1;
            }else if(matrix[mid][0] > target){
                r = mid - 1;
            }else{
                return true;
            }
        }

        if(r >= 0 && r < m){
            row = r; l = 0; r = n - 1;
            while(l <= r){
                int mid = (l+r)/2;
                if(matrix[row][mid] < target){
                    l = mid + 1;
                }else if(matrix[row][mid] > target){
                    r = mid - 1;
                }else{
                    return true;
                }
            }
        }
        return false;
    }
}
