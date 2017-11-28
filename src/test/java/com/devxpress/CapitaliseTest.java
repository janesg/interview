package com.devxpress;

import org.junit.Test;
import static org.junit.Assert.*;

public class CapitaliseTest {
    @Test
    public void capitalise() throws Exception {

        assertEquals("This Is How We Roll", Capitalise.capitalise("This is how we roll"));
        assertEquals("A Short Sentence", Capitalise.capitalise("a short sentence"));
        assertEquals("A Lazy Fox", Capitalise.capitalise("a lazy fox"));
        assertEquals("Look, It's Working!", Capitalise.capitalise("look, it's working!"));
    }

    @Test
    public void capitaliseJavaScript() throws Exception {

        assertEquals("This Is How We Roll", Capitalise.capitaliseJavaScript("This is how we roll", "capitalise"));
        assertEquals("A Short Sentence", Capitalise.capitaliseJavaScript("a short sentence", "capitalise"));
        assertEquals("A Lazy Fox", Capitalise.capitaliseJavaScript("a lazy fox", "capitalise"));
        assertEquals("Look, It's Working!", Capitalise.capitaliseJavaScript("look, it's working!", "capitalise"));
    }

}