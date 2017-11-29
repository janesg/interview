function pyramidIterative(num) {

    var strArr = [];
    var stringSize = (2 * num) - 1;
    var midIdx = Math.floor(stringSize / 2);

    for (var i = 0; i < num; i++) {
        var chars = [];
        // In ES6 we'd use '#'.repeat(i + 1), but Nashorn is only 5.1
        for (var j = 0; j < stringSize; j++) {
            chars.push(j < midIdx - i ? ' ' : (j >= midIdx + 1 + i ? ' ' : '#'));
        }
        strArr.push(chars.join(''));
    }

    return Java.to(strArr, 'java.lang.String[]');
}

function pyramidRecursive(num) {

    return Java.to(pyramidHelper([], num), 'java.lang.String[]');
}

function pyramidHelper(strArr, num) {

    if (num <= 0) {
        return strArr;
    }

    var stringSize = (2 * (num + strArr.length)) - 1;
    var midIdx = Math.floor(stringSize / 2);

    var chars = [];
    for (var j = 0; j < stringSize; j++) {
        chars.push(j < midIdx - strArr.length ? ' ' : (j >= midIdx + 1 + strArr.length ? ' ' : '#'));
    }
    strArr.push(chars.join(''));

    return pyramidHelper(strArr, num - 1);
}