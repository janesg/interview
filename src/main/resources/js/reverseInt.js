function reverseIntForLoop(num) {
    var neg = num < 0;
    var arr =  num.toString().split('');
    var revNumStr = '';

    for (var i = 0; i < arr.length; i++) {
        if (!isNaN(arr[i])) {
            revNumStr = arr[i] + revNumStr;
        }
    }

    var revNum = parseInt(revNumStr);

    return neg ? revNum * -1 : revNum;
}

function reverseIntSplitJoin(num) {
    // Since ES 5.1 doesn't have a Math.sign() function we make use of the Java Integer type
    var Integer = Java.type('java.lang.Integer');

    return Integer.signum(num) * parseInt(num.toString().split('').reverse().join(''));
}