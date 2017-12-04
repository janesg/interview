// Optional next node which will be set as this node's next reference
function Node(data, next) {
    this.data = data;
    this.next = next ? next : null;
}

function LinkedList() {
    this.head = null;
}

LinkedList.prototype.addFirst = function(data) {
    // Add new node before current head
    // Uses next-setting constructor to make current
    // head the next node for the new node
    this.head = new Node(data, this.head);
};

LinkedList.prototype.size = function() {
    var count = 0;
    var n = this.head;

    while (n !== null) {
        count++;
        n = n.next;
    }

    return count;
};

LinkedList.prototype.getFirst = function() {
    return (this.head !== null) ? this.head.data : null;
}

LinkedList.prototype.getLast = function() {
    if (!this.head) {
        return null;
    }

    var n = this.head;

    while (n.next) {
        n = n.next;
    }

    return n.data;
};

LinkedList.prototype.clear = function() {
    this.head = null;
}

LinkedList.prototype.removeFirst = function() {
    var result = null;

    if (this.head != null) {
        result = this.head.data;
        this.head = this.head.next;
    }

    return result;
}

LinkedList.prototype.removeLast = function() {
    var result = null;

    var n = this.head;

    while (n.next != null) {
        if (n.next.next == null) {
            result = n.next.data;
            n.next = null;
        } else {
            n = n.next;
        }
    }

    return result;
}

function testLinkedList() {
    var linked = new LinkedList();
    linked.addFirst("Three");
    linked.addFirst("Cheers");
    linked.addFirst("For");
    linked.addFirst("Bob");

    print("JS Linked List : " + JSON.stringify(linked));
    print("JS Linked List : size = " + linked.size());
    print("JS Linked List : first elem = " + linked.getFirst());
    print("JS Linked List : last elem = " + linked.getLast());
    print("JS Linked List : remove first = " + linked.removeFirst());
    print("JS Linked List : " + JSON.stringify(linked));
    print("JS Linked List : size = " + linked.size());
    print("JS Linked List : first elem = " + linked.getFirst());
    print("JS Linked List : remove last = " + linked.removeLast());
    print("JS Linked List : " + JSON.stringify(linked));
    print("JS Linked List : size = " + linked.size());
    print("JS Linked List : first elem = " + linked.getLast());
}