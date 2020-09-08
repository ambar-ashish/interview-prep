package array;

//LC-311
public class SparseMatrixMultiplication {

    public int[][] multiply(int[][] a, int[][] b) {
        if (a == null || b == null) {
            return new int[0][0];
        }//for a i*k matrix multiply by a k*j matrix, we will get a i*j matrix
        int[][] res = new int[a.length][b[0].length];//res[i][j] = a[i][0]*b[0][j] + a[i][1]*b[1][j] +...+ a[i][k]*b[k][j];
        for (int i = 0; i < a.length; i++) {
            for (int k = 0; k < a[0].length; k++) {
                if (a[i][k] != 0) {//cuz it's a sparse matrix, we can only calculate nonzero product to reduce operations
                    for (int j = 0; j < b[0].length; j++) {
                        if (b[k][j] != 0) {//we only add up all products that a[i][k] != 0 && b[k][j] != 0 to reduct time
                            res[i][j] += a[i][k] * b[k][j];// +=, not =; *, not + !!!
                        }
                    }
                }
            }
        }
        return res;
    }


    // Let's look at brute force solution:
    public int[][] multiply_bruteForce(int[][] A, int[][] B) {
        int m = A.length, n = A[0].length;
        int nB = B[0].length;
        int [][] C = new int[m][nB];
        for (int i = 0; i<m; i++) {
            for (int j = 0; j<nB; j++){
                C[i][j] = 0;
                for( int k = 0; k<n; k++)
                    C[i][j] += A[i][k]*B[k][j];
            }
        }
        return C;
    }
}

//For brute force solution, for each C[ i ] [ j ], it uses C[ i ] [ j ] += A[ i ] [ k ] * B[ k ] [ j ]
// where k = [ 0, n].
//Note: even A[ i ] [ k ] or B[ k ] [ j ] is 0, the multiplication is still executed.
//
//For the above smart solution, if A[ i ] [ k ] == 0 or B[ k ] [ j ] == 0, it just skip the multiplication.
//This is achieved by moving for-loop" for ( k = 0; k < n; k++ ) " from inner-most loop to middle loop,
//so that we can use if-statement to tell whether A[ i ] [ k ] == 0 or B[ k ] [ j ] == 0. This is really smart.