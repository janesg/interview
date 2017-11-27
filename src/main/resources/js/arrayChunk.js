function arrayChunk(array, size) {

    var chunked = [];

    for (var i = 0; i < array.length; i++) {

        // Get last element of chunked array
        var lastChunk = chunked[chunked.length - 1];

        if (!lastChunk || lastChunk.length === size) {
            lastChunk = [];
            chunked.push(lastChunk);
        }

        lastChunk.push(array[i]);
    }

    // Have to convert to Java array otherwise Java client gets following exception:
    // java.lang.ClassCastException: jdk.scripting.nashorn/jdk.nashorn.api.scripting.ScriptObjectMirror
    //                               cannot be cast to [[I
    return Java.to(chunked, "int[][]");
}

function arrayChunkSlice(array, size) {

    // Calling slice on a Java array doesn't work so have to convert to JavaScript array
    var jsArray = Java.from(array);
    var chunked = [];

    for (var i = 0; i < jsArray.length; ) {
        chunked.push(jsArray.slice(i, i + size));
        i += size;
    }

    // Have to convert to Java array otherwise Java client gets following exception:
    // java.lang.ClassCastException: jdk.scripting.nashorn/jdk.nashorn.api.scripting.ScriptObjectMirror
    //                               cannot be cast to [[I
    return Java.to(chunked, "int[][]");
}