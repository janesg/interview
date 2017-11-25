package com.devxpress;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxCharTest {

    @Test
    public void maxChar() throws Exception {
        assertEquals("t", MaxChar.maxChar("jjewtryqtwqyrytfdt"));
    }

    @Test
    public void maxCharJavaScript() throws Exception {
        assertEquals("t", MaxChar.maxCharJavaScript("jjewtryqtwqyrytfdt", "maxChar"));
    }

}