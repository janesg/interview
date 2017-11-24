package com.devxpress;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseIntTest {

    @Test
    public void reverseInt() throws Exception {
        assertEquals(15, ReverseInt.reverseInt(51));
        assertEquals(-15, ReverseInt.reverseInt(-51));
        assertEquals(5, ReverseInt.reverseInt(500));
        assertEquals(-5, ReverseInt.reverseInt(-500));
        assertEquals(0, ReverseInt.reverseInt(0));
    }

    @Test
    public void reverseIntJavaScriptForLoop() throws Exception {
        assertEquals(15, ReverseInt.reverseIntJavaScript(51, "reverseIntForLoop"));
        assertEquals(-15, ReverseInt.reverseIntJavaScript(-51, "reverseIntForLoop"));
        assertEquals(5, ReverseInt.reverseIntJavaScript(500, "reverseIntForLoop"));
        assertEquals(-5, ReverseInt.reverseIntJavaScript(-500, "reverseIntForLoop"));
        assertEquals(0, ReverseInt.reverseIntJavaScript(0, "reverseIntForLoop"));
    }

    @Test
    public void reverseIntJavaScriptSplitJoin() throws Exception {
        assertEquals(15, ReverseInt.reverseIntJavaScript(51, "reverseIntSplitJoin"));
        assertEquals(-15, ReverseInt.reverseIntJavaScript(-51, "reverseIntSplitJoin"));
        assertEquals(5, ReverseInt.reverseIntJavaScript(500, "reverseIntSplitJoin"));
        assertEquals(-5, ReverseInt.reverseIntJavaScript(-500, "reverseIntSplitJoin"));
        assertEquals(0, ReverseInt.reverseIntJavaScript(0, "reverseIntSplitJoin"));
    }

}