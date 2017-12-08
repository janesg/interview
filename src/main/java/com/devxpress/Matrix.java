package com.devxpress;

public class Matrix {

    public static int[][] matrix(int num) {

        int[][] results = new int[num][num];

        int count = 1;
        int startRow = 0;
        int endRow = num - 1;
        int startCol = 0;
        int endCol = num - 1;

        while (startRow <= endRow && startCol <= endCol) {
            // Fill current start row
            for (int i = startCol; i <= endCol; i++) {
                results[startRow][i] = count++;
            }

            startRow++;

            // Fill current end column
            for (int i = startRow; i <= endRow; i++) {
                results[i][endCol] = count++;
            }

            endCol--;

            // Fill current end row
            for (int i = endCol; i >= startCol; i--) {
                results[endRow][i] = count++;
            }

            endRow--;

            // Fill current start column
            for (int i = endRow; i >= startRow; i--) {
                results[i][startCol] = count++;
            }

            startCol++;
        }

        return results;
    }

}
