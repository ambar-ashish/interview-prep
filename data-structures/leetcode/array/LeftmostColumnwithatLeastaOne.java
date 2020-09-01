package array;

import java.util.Collections;
import java.util.List;

//LC-1428
public class LeftmostColumnwithatLeastaOne {

    //Time Complexity - O(M+N) where M and N are row length and column length
    //Space Complexity - O(1)
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {

        int rows = binaryMatrix.dimensions().get(0);
        int cols = binaryMatrix.dimensions().get(1);

        // Set pointers to the top-right corner.
        int currentRow = 0;
        int currentCol = cols - 1;

        // Repeat the search until it goes off the grid.
        while (currentRow < rows && currentCol >= 0) {
            if (binaryMatrix.get(currentRow, currentCol) == 0) {
                currentRow++;
            } else {
                currentCol--;
            }
        }

        // If we never left the last column, this is because it was all 0's.
        return (currentCol == cols - 1) ? -1 : currentCol + 1;
    }

    //Sample Code : not a working code
    class BinaryMatrix{
        public int get(int row, int col) {
            return 1;
        }
        public List<Integer> dimensions() {
            return Collections.emptyList();
        }
    }
}
