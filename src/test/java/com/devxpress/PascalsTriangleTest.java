package com.devxpress;

import org.junit.Test;

import static org.junit.Assert.*;

public class PascalsTriangleTest {

    @Test
    public void triangle() {
        assertArrayEquals(new int[]{1,1}, PascalsTriangle.triangle(6)[1]);
        assertArrayEquals(new int[]{1,4,6,4,1}, PascalsTriangle.triangle(6)[4]);
        assertArrayEquals(new int[]{1,5,10,10,5,1}, PascalsTriangle.triangle(6)[5]);
        assertArrayEquals(new int[]{1,17,136,680,2380,6188,12376,19448,24310,24310,19448,12376,6188,2380,680,136,17,1},
                          PascalsTriangle.triangle(20)[17]);
    }
}