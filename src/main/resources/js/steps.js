function stepsIterative(num) {

    var strArr = [];

    for (var i = 0; i < num; i++) {
        var chars = [];
        // In ES6 we'd use '#'.repeat(i + 1), but Nashorn is only 5.1
        for (var j = 0; j < num; j++) {
            chars.push(j <= i ? '#' : ' ');
        }
        strArr.push(chars.join(''));
    }

    return Java.to(strArr, 'java.lang.String[]');
}

function stepsRecursive(num) {

    return Java.to(stepHelper([], num), 'java.lang.String[]');
}

function stepHelper(strArr, num) {
    if (num === 0) {
        return strArr;
    } else {
        var chars = [];
        for (var j = 0; j < strArr.length + num; j++) {
            chars.push(j <= strArr.length  ? '#' : ' ');
        }
        strArr.push(chars.join(''));
        return stepHelper(strArr, num - 1);
    }
}