package com.devxpress;

import java.util.stream.IntStream;

public class FizzBuzz {

    public static String[] play(int max) {
        return IntStream.rangeClosed(1, max).
                mapToObj(i -> (i % 3 == 0 && i % 5 == 0 ? "FIZZBUZZ" :
                                    (i % 3 == 0 ? "FIZZ" :
                                            (i % 5 == 0 ? "BUZZ" : String.valueOf(i))))
                ).
                toArray(String[]::new);
    }
}
