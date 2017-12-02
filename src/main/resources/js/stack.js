function Stack() {
    this.data = [];
}

Stack.prototype.push = function(x) {
    this.data.unshift(x);
};

Stack.prototype.pop = function() {
    return this.data.shift();
};

Stack.prototype.peek = function() {
    return this.data[0];
};

// ES6 using class
// class Stack {
//     constructor() {
//         this.data = [];
//     }
//
//     push(x) {
//         this.data.unshift(x);
//     }
//
//     pop() {
//         return this.data.shift();
//     }
//
//     peek() {
//         return this.data[0];
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

function QueueFromStack() {
    this.s1 = new Stack();
    this.s2 = new Stack();
}

QueueFromStack.prototype.add = function(x) {
    this.s1.push(x);
};

QueueFromStack.prototype.remove = function() {
    while (this.s1.peek()) {
        this.s2.push(this.s1.pop());
    }

    var result = this.s2.pop();

    while (this.s2.peek()) {
        this.s1.push(this.s2.pop());
    }

    return result;
};

QueueFromStack.prototype.peek = function() {
    while (this.s1.peek()) {
        this.s2.push(this.s1.pop());
    }

    var result = this.s2.peek();

    while (this.s2.peek()) {
        this.s1.push(this.s2.pop());
    }

    return result;
};

function testQueueFromStackAddRemove() {
    var q = new QueueFromStack();

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

function testQueueFromStackPeek() {
    var q = new QueueFromStack();

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

function testQueueFromStackWeave() {
    var q1 = new QueueFromStack();
    q1.add(1);
    q1.add(2);
    q1.add(3);
    q1.add(4);

    var q2 = new QueueFromStack();
    q2.add('Salt');
    q2.add('Pepper');

    return weaveQueueFromStack(q1, q2);
}

function weaveQueueFromStack(q1, q2) {
    var weavedQ = new QueueFromStack();

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
