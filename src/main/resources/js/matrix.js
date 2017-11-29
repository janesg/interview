function matrix(num) {

    // In ES6 we could create square 2D array as follows:
    // var results = [...Array(num).keys()].map(i => Array(num));

    // Create the square 2D array
    var results = [];

    for (var i = 0; i < num; i++) {
        results.push([]);
    }

    // The next value to insert
    var count = 1;
    var startRow = 0;
    var endRow = num - 1;
    var startCol = 0;
    var endCol = num - 1;

    while (startRow <= endRow && startCol <= endCol) {
        for (var i = startCol; i <= endCol; i++) {
            results[startRow][i] = count++;
        }

        startRow++;

        for (var i = startRow; i <= endRow; i++) {
            results[i][endCol] = count++;
        }

        endCol--;

        for (var i = endCol; i >= startCol; i--) {
            results[endRow][i] = count++;
        }

        endRow--;

        for (var i = endRow; i >= startRow; i--) {
            results[i][startCol] = count++;
        }

        startCol++;
    }

    return Java.to(results, "int[][]");
}