function fibonacciIterative(num) {

    if (num < 0) {
        throw "Entry in series cannot be less than 0";
    }

    var result = 0;

    if (num < 2) {
        result = num;
    } else {

        result = 1;
        var resultPrev = 0;
        var temp = 0;

        for (var i = 2; i <= num; i++) {
            temp = result;
            result = result + resultPrev;
            resultPrev = temp;
        }
    }

    return result;
}

function fibonacciRecursive(num) {

    if (num < 0) {
        throw "Entry in series cannot be less than 0";
    }

    return recursionHelper(num);
}

function recursionHelper(num) {

    if (num < 2) {
        return num;
    }

    return recursionHelper(num - 1) + recursionHelper(num - 2);
}

function fibonacciRecursiveMemo(num) {

    if (num < 0) {
        throw "Entry in series cannot be less than 0";
    }

    return fib(num);
}

var fib = memoize(recursionHelperMemo);

function recursionHelperMemo(num) {

    if (num < 2) {
        return num;
    }

    return fib(num - 1) + fib(num - 2);
}

// Generic memoize wrapper function that maintains
// an arguments v results map as a cache
function memoize(func) {
    var cache = {};

    return function() {
        var args = Array.prototype.slice.call(arguments);
        var key = JSON.stringify(args);

        if (!cache[key]) {
            cache[key] = func.apply(this, arguments);
        }

        return cache[key];
    }
}

// ES6 version of generic memoize wrapper function
// function memoize(fn) {
//     const cache = {};
//
//     return function(...args) {
//         if (!cache[args]) {
//             cache[args] = fn.apply(this, args);
//         }
//
//         return cache[args];
//     }
// }

