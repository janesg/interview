function Sort() {
}

// Sort array in order of increasing element
Sort.prototype.bubbleSort = function(arr) {
    // Outer loop provides value with which to shorten inner loop
    for (var i = 0; i < arr.length; i++) {
        // Compare each element in turn
        // At end of loop we know that the largest element is at end of array
        // For next iteration, shorten the range of compared elements by 1
        for (var j = 0; j < arr.length - i - 1; j++) {
            // Swap pair of elements that are incorrectly ordered
            if (arr[j] > arr[j + 1]) {
                var temp = arr[j + 1];
                arr[j + 1] = arr[j];
                arr[j] = temp;
            }
        }
    }

    return arr;
};

Sort.prototype.selectionSort = function(arr) {
    for (var i = 0; i < arr.length; i++) {
        // Assume minimum is at index of i
        var indexOfMin = i;

        // Look for the actual minimum in remainder of array
        for (var j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[indexOfMin]) {
                indexOfMin = j;
            }
        }

        // If the initially assumed minimum wasn't the actual
        // minimum then swap elements via temp variable
        if (i !== indexOfMin) {
            var temp = arr[indexOfMin];
            arr[indexOfMin] = arr[i];
            arr[i] = temp;
        }
    }

    return arr;
};

Sort.prototype.mergeSort = function(arr) {
    for (var i = 0; i < arr.length; i++) {
        var indexOfMin = i;

        for (var j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[indexOfMin]) {
                indexOfMin = j;
            }
        }

        // If the assumed minimum isn't actual minimum then swap elements
        if (i != indexOfMin) {
            var temp = arr[indexOfMin];
            arr[indexOfMin] = arr[i];
            arr[i] = temp;
        }
    }

    return arr;
};

function testBubbleSort(arr) {
    return new Sort().bubbleSort(arr);
}

function testSelectionSort(arr) {
    return new Sort().selectionSort(arr);
}

function testMergeSort(arr) {
    return new Sort().mergeSort(arr);
}