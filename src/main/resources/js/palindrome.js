function palindromeSplitJoin(str) {
    return str.split('').reverse().join('') === str;
}

function palindromeEvery(str) {

    var arr = str.split('');

    var everyHelper = function(char, i) {
        // As Nashorn is server-side JS it doesn't support console.log...use print instead
        // print("EveryHelper : " + i + " / char = " + char);
        // Attempt at optimising for elements in 2nd half of array
        return i > arr.length / 2 ? true : char === arr[arr.length - 1 - i];
    }

    // Not optimal...potentially does twice as many comparisons as required
    // but every function finishes first time helper returns false
    return arr.every(everyHelper);
}
