package com.devxpress;

public class Vowels {

    public static int vowels(String str) {
        return (int) str.toUpperCase().chars().
                mapToObj(c -> Character.valueOf((char) c).toString()).
                filter("AEIOU"::contains).
                count();
    }

}
