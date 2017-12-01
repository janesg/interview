package com.devxpress;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {

    @Test
    public void queueJavaScriptAddRemove() throws Exception {
        assertEquals("9", Queue.queueJavaScript("testQueueAddRemove"));
    }

    @Test
    public void queueJavaScriptPeek() throws Exception {
        assertEquals("3", Queue.queueJavaScript("testQueuePeek"));
    }

    @Test
    public void queueJavaScriptWeave() throws Exception {
        assertEquals("1,Salt,2,Pepper,3,4", Queue.queueJavaScript("testWeave"));
    }

}