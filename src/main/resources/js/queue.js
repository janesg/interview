function Queue() {
    this.data = [];
}

Queue.prototype.add = function(x) {
    this.data.unshift(x);
}

Queue.prototype.remove = function() {
    return this.data.pop();
}

Queue.prototype.peek = function() {
    return this.data[this.data.length - 1];
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

function testQueueAddRemove() {
    var q = new Queue();

    q.add(1);
    q.add(2);
    q.add(3);

    if (q.remove() !== 1) {
        throw 'Expected value of 1';
    }

    q.add(4);

    var remaining = [];

    for (var data = q.remove(); data; data = q.remove()) {
        remaining.push(data);
    }

    var whatIsLeft = remaining.reduce(function(total, num) {
        return total + num;
    });

    return String(whatIsLeft);
}

function testQueuePeek() {
    var q = new Queue();

    q.add(1);
    q.add(2);
    q.add(3);

    if (q.remove() !== 1) {
        throw 'Expected value of 1';
    }

    q.add(4);

    if (q.remove() !== 2) {
        throw 'Expected value of 2';
    }

    return String(q.peek());
}

function testWeave() {
    var q1 = new Queue();
    q1.add(1);
    q1.add(2);
    q1.add(3);
    q1.add(4);

    var q2 = new Queue();
    q2.add('Salt');
    q2.add('Pepper');

    return weave(q1, q2);
}

function weave(q1, q2) {
    var weavedQ = new Queue();

    while(q1.peek() || q2.peek()) {
        if (q1.peek()) {
            weavedQ.add(q1.remove());
        }

        if (q2.peek()) {
            weavedQ.add(q2.remove());
        }
    }

    var weaved = [];

    while (weavedQ.peek()) {
        weaved.push(weavedQ.remove());
    }

    return weaved.join(',');
}