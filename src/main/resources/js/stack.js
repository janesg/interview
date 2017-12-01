function Stack() {
    this.data = [];
}

Stack.prototype.push = function(x) {
    this.data.unshift(x);
}

Stack.prototype.pop = function() {
    return this.data.shift();
}

Stack.prototype.peek = function() {
    return this.data[0];
}

// ES6 using class
// class Queue {
//     constructor() {
//         this.data = [];
//     }
//
//     add(x) {
//         this.data.unshift(x);
//     }
//
//     remove() {
//         return this.data.pop();
//     }
// }

function testStackPushPop() {
    var s = new Stack();

    s.push(1);
    s.push(2);
    s.push(3);

    if (s.pop() !== 3) {
        throw 'Expected value of 3';
    }

    s.push(4);

    var remaining = [];

    for (var data = s.pop(); data; data = s.pop()) {
        remaining.push(data);
    }

    var whatIsLeft = remaining.reduce(function(total, num) {
        return total + num;
    });

    return String(whatIsLeft);
}

function testStackPeek() {
    var s = new Stack();

    s.push(1);
    s.push(2);
    s.push(3);

    if (s.pop() !== 3) {
        throw 'Expected value of 3';
    }

    s.push(4);

    if (s.pop() !== 4) {
        throw 'Expected value of 4';
    }

    return String(s.peek());
}

function testWeave() {
    var s1 = new Stack();
    s1.push(1);
    s1.push(2);
    s1.push(3);
    s1.push(4);

    var s2 = new Stack();
    s2.push('Salt');
    s2.push('Pepper');

    return weave(s1, s2);
}

function weave(s1, s2) {
    var weavedS = new Stack();

    while(s1.peek() || s2.peek()) {
        if (s1.peek()) {
            weavedS.push(s1.pop());
        }

        if (s2.peek()) {
            weavedS.push(s2.pop());
        }
    }

    var weaved = [];
    
    while (weavedS.peek()) {
        weaved.push(weavedS.pop());
    }

    return weaved.join(',');
}
