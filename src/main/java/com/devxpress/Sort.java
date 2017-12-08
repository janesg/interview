package com.devxpress;

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
        for (int i = 0; i < array.length; i++) {
            int indexOfMin = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(array[indexOfMin]) < 0) {
                    indexOfMin = j;
                }
            }

            // If the assumed minimum isn't actual minimum then swap elements
            if (i != indexOfMin) {
                T temp = array[indexOfMin];
                array[indexOfMin] = array[i];
                array[i] = temp;
            }
        }

        return array;
    }

}
