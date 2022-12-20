package Labs;

import java.util.Scanner;

class MatrixChainMultiplication {

    // Matrix Ai has dimension p[i-1] x p[i] for i = 1..n
    static int MatrixChainOrder(int p[], int n) {
        int m[][] = new int[n][n];

        // m[i,j] = Minimum number of scalar multiplications needed
        // to compute the matrix A[i]A[i+1]...A[j] = A[i..j] where
        // dimension of A[i] is p[i-1] x p[i]

        // cost is zero when multiplying one matrix.
        for (int i = 1; i < n; i++)
            m[i][i] = 0;

        // L is chain length.
        for (int L = 2; L < n; L++) {
            for (int i = 1; i < n - L + 1; i++) {
                int j = i + L - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    // q = cost/scalar multiplications
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j])
                        m[i][j] = q;
                }
            }
        }

        return m[1][n - 1];
    }

    // Driver program to test above function
    public static void main(String args[]) {
//        int arr[] = new int[] { 1, 2, 3, 4 };
//        int size = arr.length;

        Scanner in = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int size = in.nextInt();
        int arr[] = new int[size];

        System.out.println("Enter the matrix:");
        for (int i=0;i<size;i++){
            arr[i] = in.nextInt();
        }

        System.out.println("Enter array is :");
        for (int i=0;i<size;i++){
            System.out.println(arr[i]);
        }

        System.out.println("Minimum number of multiplications is " + MatrixChainOrder(arr, size));

    }
}

