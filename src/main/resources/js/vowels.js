function vowels(str) {
    var matches = str.toUpperCase().match(/[AEIOU]/g);
    return matches ? matches.length : 0;
}