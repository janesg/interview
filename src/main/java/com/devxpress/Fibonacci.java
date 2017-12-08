package com.devxpress;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;

/**
 * Note: results should be as follows:
 *          - Fib(0) -> 0
 *          - Fib(1) -> 1
 *          - Fib(2) -> 1
 *          - Fib(3) -> 2
 *          etc...
 */
public class Fibonacci {

    public static long fibonacciIterative(int num) {

        if (num < 0) {
            throw new IllegalArgumentException("Entry in series cannot be less than 0");
        }

        if (num < 2) {
            return num;
        }

        long result = 1;
        long resultPrev = 0;
        long temp = 0;

        for (int i = 2; i <= num; i++) {
            temp = result;
            result = result + resultPrev;
            resultPrev = temp;
        }

        return result;
    }

    public static long fibonacciRecursive(int num) {

        if (num < 0) {
            throw new IllegalArgumentException("Entry in series cannot be less than 0");
        }

        return fibonacciHelper(num);
    }

    private static long fibonacciHelper(int num) {

        if (num < 2) {
            return num;
        }

        return fibonacciHelper(num - 1) + fibonacciHelper(num - 2);
    }

    public static long fibonacciRecursiveMemo(int num) {

        if (num < 0) {
            throw new IllegalArgumentException("Entry in series cannot be less than 0");
        }

        // Use of HashMap makes this non thread-safe but can't use ConcurrentHashMap
        // in recursive calls due to inner call clashing with outer call
        Map<Integer, Long> fibMap = new HashMap<>();

        return fibonacciHelperMemo(num, fibMap);
    }

    private static long fibonacciHelperMemo(int num, Map<Integer, Long> fibMap) {

        if (num < 2) {
            return num;
        }

        // Map.computeIfAbsent will throw ConcurrentModificationException if map is changed by the function
        // Since function is recursive, this will always happen
//        return fibMap.computeIfAbsent(num, n -> fibonacciHelperMemo(n - 1, fibMap) + fibonacciHelperMemo(n - 2, fibMap));

        // Note: access to the map is not synchronised and so is not thread-safe
        if (!fibMap.containsKey(num)) {
            fibMap.put(num, fibonacciHelperMemo(num - 1, fibMap) + fibonacciHelperMemo(num - 2, fibMap));
        }

        return fibMap.get(num);
    }

    // A generic Java 8 thread-safe memoize wrapper function
    // Note: whole map is effectively locked
    public static <I, O> Function<I, O> memoize(Function<I, O> f) {
        Map<I, O> lookup = new HashMap<>();
        ReentrantLock lock = new ReentrantLock();
        return input -> {
            lock.lock();
            try {
                // Again can't use computeIfAbsent when function f will change the map
//                return lookup.computeIfAbsent(input, f);
                if (!lookup.containsKey(input)) {
                    lookup.put(input, f.apply(input));
                }

                return lookup.get(input);
            } finally {
                lock.unlock();
            }
        };
    }

    public static long fibonacciRecursiveMemoGenericFunc(int num) {

        if (num < 0) {
            throw new IllegalArgumentException("Entry in series cannot be less than 0");
        }

        return fibFunc.apply(num);
    }

    private static long fibonacciHelperMemoFunc(int num) {

        if (num < 2) {
            return num;
        }

        return fibFunc.apply(num - 1) + fibFunc.apply(num - 2);
    }

    private static final Function<Integer, Long> fibFunc = Fibonacci.memoize(Fibonacci::fibonacciHelperMemoFunc);

}
