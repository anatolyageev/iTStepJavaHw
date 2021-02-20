package com.ageev.itstep;

public class Tset1 {
    public static void main(String[] args) {
        int[][] mat = {{4, 6, 7},
                {2,9,4},
                {5,5,5}};
        System.out.println("Result: " + diagonalSum(mat));
        int[][] mat2 = {{1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}};
        System.out.println("Result: " + diagonalSum(mat2));

    }

    public static int diagonalSum(int[][] mat) {
        int result = 0;
        for (int indexRow = 0; indexRow < mat.length; indexRow++) {
            result = result + mat[indexRow][indexRow] + mat[indexRow][mat[indexRow].length - indexRow - 1];
            if (mat.length % 2 != 0 && indexRow==indexRow && indexRow == (mat[indexRow].length - indexRow - 1)) {
                result = result - mat[indexRow][indexRow];
            }
        }
        return result;
    }
}
