function reverseStringSplitJoin(str) {
    return str.split('').reverse().join('');
}

function reverseStringForLoop(str) {
    // By default, Nashorn doesn't support ES6 features like 'let' or 'for...of' loops
    // Have to add --language=es6 to the command line but no way of doing this in IntelliJ for JUnit tests
    // Therefore we have to resort to Nashorn default level which is ES 5.1

    // let rev = '';
    var rev = '';

    // Iterate through characters and build result by pre-pending each in turn

    // ES6 approach
    // for (let char of str) {
    //     rev = char + rev;
    // }

    var arr = str.split('');

    for (var i = 0; i < arr.length; i++) {
        rev = arr[i] + rev;
    }
    
    return rev;
}

function reverseStringReduce(str) {

    // I can't use Nashorn's ES6 support in JUnit tests so no fat arrow functions
    var reducer = function(reversed, character) {
        return character + reversed;
    }

    // Use the array helper, reduce
    return str.split('').reduce(reducer, '');
}
