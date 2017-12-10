package com.devxpress;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Sort {

    public static <T extends Comparable<T>> T[] bubbleSort(T[] array) {
        // Outer loop provides value with which to shorten inner loop
        for (int i = 0; i < array.length; i++) {
            // Compare each element in turn
            // At end of loop we know that the largest element is at end of array
            // For next iteration, shorten the range of compared elements by 1
            // Remember to also shorten by 1 as we access element at j + 1
            for (int j = 0; j < array.length - i - 1; j++) {
                // Swap pair of elements that are incorrectly ordered
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }

        return array;
    }

    public static <T extends Comparable<T>> T[] selectionSort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            // Assume minimum is at index of i
            int indexOfMin = i;

            // Look for the actual minimum in remainder of array
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(array[indexOfMin]) < 0) {
                    indexOfMin = j;
                }
            }

            // If the initially assumed minimum wasn't the actual
            // minimum then swap elements via temp variable
            if (i != indexOfMin) {
                T temp = array[indexOfMin];
                array[indexOfMin] = array[i];
                array[i] = temp;
            }
        }

        return array;
    }

    public static <T extends Comparable<T>> T[] mergeSort(T[] array) {
        if (array.length <= 1) {
            return array;
        }

        List<T> result = mergeSort(Arrays.asList(array));

        // Have to create new array of generic type through reflection
        return result.toArray((T[]) Array.newInstance(array[0].getClass(), 0));
    }

    public static <T extends Comparable<T>> List<T> mergeSort(List<T> list) {
        if (list.size() <= 1) {
            return list;
        }

        int mid = list.size() / 2;
        List<T> left = new LinkedList<>(list.subList(0, mid));
        List<T> right = new LinkedList<>(list.subList(mid, list.size()));

        return mergeHalves(mergeSort(left), mergeSort(right));
    }

    private static <T extends Comparable<T>> List<T> mergeHalves(List<T> left, List<T> right) {

        LinkedList<T> result = new LinkedList<>();

        // 'Move' lowest value first element into result array
        while (left.size() > 0 && right.size() > 0) {
            if (left.get(0).compareTo(right.get(0)) < 0) {
                result.add(left.remove(0));
            } else {
                result.add(right.remove(0));
            }
        }

        result.addAll(left.size() > 0 ? left : right);

        return result;
    }
}
