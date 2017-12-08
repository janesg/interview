package com.devxpress;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Capitalise {

    public static String capitalise(String str) {

        return Arrays.stream(str.split("\\s")).
                map(s -> s.substring(0, 1).toUpperCase() + s.substring(1)).
                collect(Collectors.joining(" "));
    }

}
