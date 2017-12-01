package com.devxpress;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackTest {

    @Test
    public void stackJavaScriptPushPop() throws Exception {
        assertEquals("7", Stack.stackJavaScript("testStackPushPop"));
    }

    @Test
    public void stackJavaScriptPeek() throws Exception {
        assertEquals("2", Stack.stackJavaScript("testStackPeek"));
    }

    @Test
    public void stackJavaScriptWeave() throws Exception {
        assertEquals("1,2,Salt,3,Pepper,4", Stack.stackJavaScript("testWeave"));
    }

}