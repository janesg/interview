package com.devxpress;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseAStringTest {
    @Test
    public void reverseForLoop() throws Exception {
        assertEquals("xoBrettO", ReverseAString.reverseForLoop("OtterBox"));
    }

    @Test
    public void reverseStack() throws Exception {
        assertEquals("xoBrettO", ReverseAString.reverseStack("OtterBox"));
    }

    @Test
    public void reverseCharSwap() throws Exception {
        assertEquals("xoBrettO", ReverseAString.reverseCharSwap("OtterBox"));
        assertEquals("119xoBrettO", ReverseAString.reverseCharSwap("OtterBox911"));
    }

    @Test
    public void reverseCollection8() throws Exception {
        assertEquals("xoBrettO", ReverseAString.reverseCollection8("OtterBox"));
    }

    @Test
    public void reverseJavaScriptSplitJoin() throws Exception {
        assertEquals("xoBrettO", ReverseAString.reverseJavaScript("OtterBox", "reverseStringSplitJoin"));
    }

    @Test
    public void reverseJavaScriptForLoop() throws Exception {
        assertEquals("xoBrettO", ReverseAString.reverseJavaScript("OtterBox", "reverseStringForLoop"));
    }

    @Test
    public void reverseJavaScriptReduce() throws Exception {
        assertEquals("xoBrettO", ReverseAString.reverseJavaScript("OtterBox", "reverseStringReduce"));
    }

}