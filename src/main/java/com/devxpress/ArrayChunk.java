package com.devxpress;

public class ArrayChunk {

    public static int[][] arrayChunk(int[] array, int size) {

        int remainder = array.length % size;
        int numSubArrays = remainder > 0 ? (array.length / size) + 1 : (array.length / size) ;

        int[][] result = new int[numSubArrays][];

        for (int i = 0; i < numSubArrays; i++) {
            for (int j = 0; j < size; j++) {
                // Allocate the correct size inner sub array
                if (j == 0) {
                    // Handle non-standard size of last inner array
                    if (i == (numSubArrays - 1)) {
                        result[i] = (remainder == 0) ? new int[size] : new int[remainder];
                    } else {
                        result[i] = new int[size];
                    }
                }

                // Derive index into the original array
                // Note: as I don't iterate through the original array, this
                //       solution will perform (size - remainder) unnecessary passes
                //       if the array length is not a multiple of the size.
                int idx = (i * size) + j;
                if (idx < array.length) {
                    result[i][j] = array[idx];
                }
            }
        }

        return result;
    }

    public static int[][] arrayChunkArrayCopy(int[] array, int size) {

        int remainder = array.length % size;
        int numSubArrays = remainder > 0 ? (array.length / size) + 1 : (array.length / size) ;

        int[][] result = new int[numSubArrays][];

        for (int idx = 0, i = 0; idx < array.length; ) {
            int copyLen = (array.length - idx) < size ? remainder : size;
            int[] chunk = new int[copyLen];
            System.arraycopy(array, idx, chunk, 0, copyLen);
            result[i] = chunk;
            idx += copyLen;
            i++;
        }

        return result;
    }

}
