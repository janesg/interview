function anagramCharMap(string1, string2) {

    // Use RegExp to match only alphanumeric characters
    // \w matches alphanumeric
    // ^ negates that match
    // /g applies expression to all characters not just the first one
    // therefore we replace any non-alphanumeric character with '' thereby removing it
    var str1arr = string1.replace(/[^\w]/g, '').toUpperCase().split('');
    var str2arr = string2.replace(/[^\w]/g, '').toUpperCase().split('');

    if (str1arr.length !== str2arr.length) {
        return false;
    }

    var str1Map = {};
    var str2Map = {};

    // Char arrays are same length so combine into single loop
    for (var i = 0; i < str1arr.length; i++) {
        var charCount1 = str1Map[str1arr[i]];
        var charCount2 = str2Map[str2arr[i]];

        str1Map[str1arr[i]] = !charCount1 ? 1 : (charCount1 + 1);
        str2Map[str2arr[i]] = !charCount2 ? 1 : (charCount2 + 1);
    }

    // Compare values of matching attributes
    for (var char in str1Map) {
        if (str1Map[char] !== str2Map[char]) {
            return false;
        }
    }

    return true;
}

function anagramSort(string1, string2) {

    return cleanString(string1) === cleanString(string2);
}

// Helper function
function cleanString(str) {
    // Use RegExp to match only alphanumeric characters
    // \w matches alphanumeric
    // ^ negates that match
    // /g applies expression to all characters not just the first one
    // therefore we replace any non-alphanumeric character with '' thereby removing it
    return str.replace(/[^\w]/g, '').toUpperCase().split('').sort().join('')
}