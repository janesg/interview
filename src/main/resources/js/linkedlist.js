// Optional next node which will be set as this node's next reference
function Node(data, next) {
    this.data = data;
    this.next = next ? next : null;
}

function LinkedList() {
    this.head = null;
    this.elemCount = 0;
}

LinkedList.prototype.addFirst = function(data) {
    // Add new node before current head
    // Uses next-setting constructor to make current
    // head the next node for the new node
    this.head = new Node(data, this.head);
    this.elemCount++;
};

LinkedList.prototype.size = function() {
    return this.elemCount;
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
    this.elemCount = 0;
}

LinkedList.prototype.removeFirst = function() {
    var result = null;

    if (this.head != null) {
        result = this.head.data;
        this.head = this.head.next;
        this.elemCount--;
    }

    return result;
}

LinkedList.prototype.removeLast = function() {
    var result = null;

    // Check for empty list
    if (this.head != null) {
        // Check for single item list
        if (this.head.next == null) {
            result = this.head.data;
            this.head = null;
        } else {
            var n = this.head;

            while (n.next != null) {
                if (n.next.next == null) {
                    result = n.next.data;
                    n.next = null;
                } else {
                    n = n.next;
                }
            }
        }

        this.elemCount--;
    }

    return result;
}

LinkedList.prototype.addLast = function(data) {

    var newNode = new Node(data);
    var n = this.head;

    if (!this.head == null) {
        this.head = newNode;
    } else {
        while (n.next != null) {
            n = n.next;
        }

        n.next = newNode;
    }

    this.elemCount++;
}

LinkedList.prototype.get = function(idx) {
    if (!this.isElementIndex(idx)) {
        throw "Invalid Element Index: " + idx + "; Size: " + this.elemCount;
    }

    var n = this.head;

    for (var i = 0; i < idx; i++) {
        n = n.next;
    }

    return n.data;
}

LinkedList.prototype.remove = function(idx) {
    if (!this.isElementIndex(idx)) {
        throw "Invalid Element Index: " + idx + "; Size: " + this.elemCount;
    }

    if (idx == 0) {
        return this.removeFirst();
    } else if (idx == this.elemCount - 1) {
        return this.removeLast();
    }

    // If we get to here then we know that the node to be
    // removed has nodes both before and after it
    var n = this.head;

    // Find the node previous to the one to be removed
    for (var i = 0; i < idx - 1; i++) {
        n = n.next;
    }

    var remove = n.next;
    n.next = remove.next;
    this.elemCount--;

    return remove.data;
}

LinkedList.prototype.add = function(data, idx) {
    // In this scenario we can specify an index equal to the size
    // so handle head and tail additions before checking for valid element index
    if (idx == 0) {
        this.addFirst(data);
        return;
    } else if (idx == this.elemCount) {
        this.addLast(data);
        return;
    }

    if (!this.isElementIndex(idx)) {
        throw "Index: " + idx + ", Size: " + this.elemCount;
    }

    // If we get to here then we know that the node to be
    // added has nodes both before and after it
    var beforeAdd = this.head;

    // Find the node previous to the one to be added
    for (var i = 0; i < idx - 1; i++) {
        beforeAdd = beforeAdd.next;
    }

    var newNode = new Node(data, beforeAdd.next);
    beforeAdd.next = newNode;
    this.elemCount++;

    return;
}

LinkedList.prototype.isElementIndex = function(idx) {
    return idx >= 0 && idx < this.elemCount;
}


function testLinkedList() {
    var linked = new LinkedList();
    linked.addFirst("For");
    linked.addLast("Cheers");
    linked.addFirst("Bob");
    linked.addLast("Three");

    print("JS Linked List : " + JSON.stringify(linked));
    print("JS Linked List : size = " + linked.size());
    print("JS Linked List : first elem = " + linked.getFirst());
    print("JS Linked List : last elem = " + linked.getLast());
    print("JS Linked List : get elem @ idx 1 = " + linked.get(1));
    print("JS Linked List : remove first = " + linked.removeFirst());
    print("JS Linked List : " + JSON.stringify(linked));
    print("JS Linked List : size = " + linked.size());
    print("JS Linked List : first elem = " + linked.getFirst());
    print("JS Linked List : remove last = " + linked.removeLast());
    print("JS Linked List : " + JSON.stringify(linked));
    print("JS Linked List : size = " + linked.size());
    print("JS Linked List : last elem = " + linked.getLast());
    print("JS Linked List : remove elem @ idx 1 = " + linked.remove(1));
    print("JS Linked List : size = " + linked.size());
    print("JS Linked List : " + JSON.stringify(linked));

    linked.add("Hip", 0);
    linked.add("Hooray", 1);
    linked.add("Henry", 3);

    print("JS Linked List : " + JSON.stringify(linked));
}