function maxChar(str) {
    var countMap = {};
    var arr = str.split('');

    // ES6
    // for (let char of str) {
    //     if (countMap[char]) {
    //         countMap[char]++;
    //     } else {
    //         countMap[char] = 1;
    //     }
    // }

    for (var i = 0; i < arr.length; i++) {
        var count = countMap[arr[i]];
        if (!count) {
            countMap[arr[i]] = 1;
        } else {
            countMap[arr[i]]++;
        }
    }

    var max = 0;
    var maxChar = '';

    for (var char in countMap) {
        if (countMap[char] > max) {
            max = countMap[char];
            maxChar = char;
        }
    }

    return maxChar;
}