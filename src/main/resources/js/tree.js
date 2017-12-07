function Tree() {
    this.root = null;
}

Tree.prototype.traverseBF = function(f) {
    if (!this.root) {
        throw "Traversal of empty Tree is not possible";
    }

    var nodeArr = [ this.root ];

    while (nodeArr.length > 0) {
        // Remove first element from array
        var node = nodeArr.shift();

        // Add each of node's children and add to end of array
        node.children.forEach(function(e) {
            nodeArr.push(e);
        });

        // Apply the function passed
        f(node);
    }
};

Tree.prototype.traverseDF = function(f) {
    if (!this.root) {
        throw "Traversal of empty Tree is not possible";
    }

    var nodeArr = [ this.root ];

    while (nodeArr.length > 0) {
        // Remove first element from array
        var node = nodeArr.shift();

        // Add each of node's children and add to start of array
        // Have to iterate backwards to maintain order
        for (var i = node.children.length - 1; i >= 0; i--) {
            nodeArr.unshift(node.children[i]);
        }

        // Apply the function passed
        f(node);
    }
};

function Node(data) {
    this.data = data;
    this.children = [];
}

Node.prototype.add = function(data) {
    this.children.push(new Node(data));
};

Node.prototype.remove = function(data) {
    this.children = this.children.filter(function(e) {
        return e.data !== data;
    });
};

Node.prototype.levelWidth = function(root) {
    var counts = [], currentLevel = [], nextLevel = [];

    // Prime the current level for the root node
    currentLevel.push(root);
    counts.push(0);

    while (currentLevel.length || nextLevel.length) {
        // Remove first node at current level
        var node = currentLevel.shift();
        // Increment the last counter
        counts[counts.length - 1]++;
        // Stick children in next level array
        node.children.forEach(function(node) { nextLevel.push(node) });

        if (!currentLevel.length) {
            // Check whether there is a next level
            if (nextLevel.length) {
                // Start of the next level, so add a new counter
                counts.push(0);
                // Now swap current and next arrays
                var temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }
    }

    return counts;
}

function testTree() {
    var results = [];
    var t = new Tree();
    t.root = new Node('a');
    t.root.add('b');
    t.root.add('c');
    t.root.add('d');

    t.root.children[0].add('e');
    t.root.children[0].add('f');
    t.root.children[0].add('g');
    t.root.children[2].add('h');
    t.root.children[2].add('i');

    print(JSON.stringify(t));

    t.traverseBF(function(node) {
        results.push(node.data);
    });

    print("Traverse BF Results: " + results.toString());

    results = [];

    t.traverseDF(function(node) {
        results.push(node.data);
    });

    print("Traverse DF Results: " + results.toString());

    print("Level Width: " + Node.prototype.levelWidth(t.root));
}