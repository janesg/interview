package com.devxpress;

// 1
// 1 1
// 1 2 1
// 1 3 3 1
// 1 4 6 4 1
// 1 5 10 10 5 1

public class PascalsTriangle {

    public static void main(String[] args) {
        printTriangle(triangle(20));
    }


    public static int[][] triangle(int n) {
        int[][] values = new int[n][];

        for (int i = 0; i < n; i++) {
            int[] row = new int[i + 1];
            values[i] = row;
            for (int j = 0; j < row.length; j++) {
                row[j] = (j == 0 || j == row.length - 1) ? 1 : values[i - 1][j - 1] + values[i - 1][j];
            }
        }

        return values;
    }

    private static void printTriangle(int[][] triangle) {
        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                System.out.print(triangle[i][j] + " ");
            }

            System.out.print("\n");
        }
    }
}
