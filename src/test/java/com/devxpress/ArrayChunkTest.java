package com.devxpress;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayChunkTest {
    @Test
    public void arrayChunk() throws Exception {

        int[][] results = ArrayChunk.arrayChunk(new int[]{ 1, 2, 3, 4 }, 2);

        int[] subArr0 = new int[]{1, 2};
        int[] subArr1 = new int[]{3, 4};
        assertEquals(2, results.length);
        assertArrayEquals(subArr0, results[0]);
        assertArrayEquals(subArr1, results[1]);

        results = ArrayChunk.arrayChunk(new int[]{ 1, 2, 3, 4, 5 }, 2);

        subArr0 = new int[]{1, 2};
        subArr1 = new int[]{3, 4};
        int[] subArr2 = new int[]{ 5 };
        assertEquals(3, results.length);
        assertArrayEquals(subArr0, results[0]);
        assertArrayEquals(subArr1, results[1]);
        assertArrayEquals(subArr2, results[2]);

        results = ArrayChunk.arrayChunk(new int[]{ 1, 2, 3, 4, 5, 6, 7, 8 }, 3);

        subArr0 = new int[]{1, 2, 3};
        subArr1 = new int[]{4, 5, 6};
        subArr2 = new int[]{ 7, 8 };
        assertEquals(3, results.length);
        assertArrayEquals(subArr0, results[0]);
        assertArrayEquals(subArr1, results[1]);
        assertArrayEquals(subArr2, results[2]);

        results = ArrayChunk.arrayChunk(new int[]{ 1, 2, 3, 4, 5 }, 4);

        subArr0 = new int[]{ 1, 2, 3, 4 };
        subArr1 = new int[]{ 5 };
        assertEquals(2, results.length);
        assertArrayEquals(subArr0, results[0]);
        assertArrayEquals(subArr1, results[1]);

        results = ArrayChunk.arrayChunk(new int[]{ 1, 2, 3, 4, 5 }, 10);

        subArr0 = new int[]{ 1, 2, 3, 4, 5 };
        assertEquals(1, results.length);
        assertArrayEquals(subArr0, results[0]);

    }

    @Test
    public void arrayChunkJavaScript() throws Exception {

        int[][] results = ArrayChunk.arrayChunkJavaScript(new int[]{ 1, 2, 3, 4 }, 2, "arrayChunk");

        int[] subArr0 = new int[]{1, 2};
        int[] subArr1 = new int[]{3, 4};
        assertEquals(2, results.length);
        assertArrayEquals(subArr0, results[0]);
        assertArrayEquals(subArr1, results[1]);

        results = ArrayChunk.arrayChunkJavaScript(new int[]{ 1, 2, 3, 4, 5 }, 2, "arrayChunk");

        subArr0 = new int[]{1, 2};
        subArr1 = new int[]{3, 4};
        int[] subArr2 = new int[]{ 5 };
        assertEquals(3, results.length);
        assertArrayEquals(subArr0, results[0]);
        assertArrayEquals(subArr1, results[1]);
        assertArrayEquals(subArr2, results[2]);

        results = ArrayChunk.arrayChunkJavaScript(new int[]{ 1, 2, 3, 4, 5, 6, 7, 8 }, 3, "arrayChunk");

        subArr0 = new int[]{1, 2, 3};
        subArr1 = new int[]{4, 5, 6};
        subArr2 = new int[]{ 7, 8 };
        assertEquals(3, results.length);
        assertArrayEquals(subArr0, results[0]);
        assertArrayEquals(subArr1, results[1]);
        assertArrayEquals(subArr2, results[2]);

        results = ArrayChunk.arrayChunkJavaScript(new int[]{ 1, 2, 3, 4, 5 }, 4, "arrayChunk");

        subArr0 = new int[]{ 1, 2, 3, 4 };
        subArr1 = new int[]{ 5 };
        assertEquals(2, results.length);
        assertArrayEquals(subArr0, results[0]);
        assertArrayEquals(subArr1, results[1]);

        results = ArrayChunk.arrayChunkJavaScript(new int[]{ 1, 2, 3, 4, 5 }, 10, "arrayChunk");

        subArr0 = new int[]{ 1, 2, 3, 4, 5 };
        assertEquals(1, results.length);
        assertArrayEquals(subArr0, results[0]);
    }

    @Test
    public void arrayChunkSliceJavaScript() throws Exception {

        int[][] results = ArrayChunk.arrayChunkJavaScript(new int[]{ 1, 2, 3, 4 }, 2, "arrayChunkSlice");

        int[] subArr0 = new int[]{1, 2};
        int[] subArr1 = new int[]{3, 4};
        assertEquals(2, results.length);
        assertArrayEquals(subArr0, results[0]);
        assertArrayEquals(subArr1, results[1]);

        results = ArrayChunk.arrayChunkJavaScript(new int[]{ 1, 2, 3, 4, 5 }, 2, "arrayChunkSlice");

        subArr0 = new int[]{1, 2};
        subArr1 = new int[]{3, 4};
        int[] subArr2 = new int[]{ 5 };
        assertEquals(3, results.length);
        assertArrayEquals(subArr0, results[0]);
        assertArrayEquals(subArr1, results[1]);
        assertArrayEquals(subArr2, results[2]);

        results = ArrayChunk.arrayChunkJavaScript(new int[]{ 1, 2, 3, 4, 5, 6, 7, 8 }, 3, "arrayChunkSlice");

        subArr0 = new int[]{1, 2, 3};
        subArr1 = new int[]{4, 5, 6};
        subArr2 = new int[]{ 7, 8 };
        assertEquals(3, results.length);
        assertArrayEquals(subArr0, results[0]);
        assertArrayEquals(subArr1, results[1]);
        assertArrayEquals(subArr2, results[2]);

        results = ArrayChunk.arrayChunkJavaScript(new int[]{ 1, 2, 3, 4, 5 }, 4, "arrayChunkSlice");

        subArr0 = new int[]{ 1, 2, 3, 4 };
        subArr1 = new int[]{ 5 };
        assertEquals(2, results.length);
        assertArrayEquals(subArr0, results[0]);
        assertArrayEquals(subArr1, results[1]);

        results = ArrayChunk.arrayChunkJavaScript(new int[]{ 1, 2, 3, 4, 5 }, 10, "arrayChunkSlice");

        subArr0 = new int[]{ 1, 2, 3, 4, 5 };
        assertEquals(1, results.length);
        assertArrayEquals(subArr0, results[0]);
    }

}