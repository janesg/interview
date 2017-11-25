function fizzBuzz(num) {
    var strs = [];

    for (var i = 1; i <= num; i++) {
        if (i % 3 === 0 && i % 5 === 0) {
            strs[i - 1] = 'FIZZBUZZ';
        } else if (i % 3 === 0) {
            strs[i - 1] = 'FIZZ';
        } else if (i % 5 === 0) {
            strs[i - 1] = 'BUZZ';
        } else {
            strs[i - 1] = i.toString();
        }
    }

    // Have to convert to Java array otherwise Java client gets following exception:
    // java.lang.ClassCastException: jdk.scripting.nashorn/jdk.nashorn.api.scripting.ScriptObjectMirror
    //                               cannot be cast to java.base/[Ljava.lang.String;
    return Java.to(strs, "java.lang.String[]");
}