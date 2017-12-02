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

    @Test
    public void queueFromStackJavaScriptAddRemove() throws Exception {
        assertEquals("9", Stack.stackJavaScript("testQueueFromStackAddRemove"));
    }

    @Test
    public void queueFromStackJavaScriptPeek() throws Exception {
        assertEquals("3", Stack.stackJavaScript("testQueueFromStackPeek"));
    }

    @Test
    public void queueFromStackJavaScriptWeave() throws Exception {
        assertEquals("1,Salt,2,Pepper,3,4", Stack.stackJavaScript("testQueueFromStackWeave"));
    }

}