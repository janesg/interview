function capitalise(str) {
    return str.split(' ').map(upFirstLetter).join(' ');
}

function upFirstLetter(str) {
    // To get first letter of a String we can use charAt(0) or slice(0,1)
    // return str.charAt(0).toUpperCase() + str.slice(1);
    return str.slice(0,1).toUpperCase() + str.slice(1);
}