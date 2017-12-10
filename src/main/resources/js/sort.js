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
    if (arr.length === 1) {
        return arr;
    }

    var mid = Math.floor(arr.length / 2);

    // Slice doesn't work on Java arrays so use for loop copy instead
    // http://forum.imagej.net/t/the-js-array-slice-function-doesnt-work-anymore-with-java-8/764/7
    // var left = arr.slice(0, mid);
    // var right = arr.slice(mid);
    var left = [];
    var right = [];

    for (var i = 0; i < arr.length; i++) {
        (i < mid ? left : right).push(arr[i]);
    }

    var result = mergeHalves(this.mergeSort(left), this.mergeSort(right));
    print(JSON.stringify(result));
    return result;
    // return mergeHalves(this.mergeSort(left), this.mergeSort(right));
}

// Take 2 sorted arrays and merge to form 1 sorted array
function mergeHalves(left, right) {
    var result = [];

    // 'Move' lowest value first element into result array
    while (left.length && right.length) {
        // result.push((left[0] < right[0] ? left : right).shift());
        if (left[0] < right[0]) {
            result.push(left.shift());
        } else {
            result.push(right.shift());
        }
    }

    // In ES6 use the spread operator
    // return [...result, ...left, ...right];

    // Different ways of adding all remaining elements

    // (left.length ? right : left).forEach(function(e) { result.push(e) });
    // return result;

    // return result.concat(left).concat(right);

    return result.concat(left.length ? right : left);
}

function testBubbleSort(arr) {
    return new Sort().bubbleSort(arr);
}

function testSelectionSort(arr) {
    return new Sort().selectionSort(arr);
}

function testMergeSort(arr) {
    return new Sort().mergeSort(arr);
}