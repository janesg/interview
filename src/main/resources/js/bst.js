function BST(data) {
    this.root = new Node(data);
}

function Node(data) {
    this.data = data;
    this.left = null;
    this.right = null;
}

Node.prototype.add = function(data) {
    if (data && this.data !== data) {
        if (data < this.data) {
            if (this.left) {
                this.left.add(data);
            } else {
                this.left = new Node(data);
            }
        } else {
            if (this.right) {
                this.right.add(data);
            } else {
                this.right = new Node(data);
            }
        }
    }
};

Node.prototype.contains = function(data) {
    if (!data) {
        return false;
    }

    if (this.data !== data) {
        if (data < this.data) {
            return this.left ? this.left.contains(data) : false;
        } else {
            return this.right ? this.right.contains(data) : false;
        }
    } else {
        return true;
    }
};

Node.prototype.validate = function() {
    return validationHelper(this, null, null);
}

function validationHelper(node, minValue, maxValue) {

    // If max is specified, current node value cannot be greater than max
    if (maxValue && node.data > maxValue) {
        return false;
    }

    // If min is specified, current node value cannot be less than min
    if (minValue && node.data < minValue) {
        return false;
    }

    // Processing left so pass a maximum valid value
    if (node.left && !validationHelper(node.left, null, node.data)) {
        return false;
    }

    // Processing right so pass a minimum valid value
    if (node.right && !validationHelper(node.right, node.data, null)) {
        return false;
    }

    return true;
}

function testBST() {
    var bst = new BST(27);
    var root = bst.root;

    root.add(56);
    root.add(58);
    root.add(30);
    root.add(57);

    print("BST: " + JSON.stringify(bst));
    print("root.contains(30) = " + root.contains(30));
    print("root.contains(-12) = " + root.contains(-12));
    print("root.contains(27) = " + root.contains(27));
    print("root.contains(55) = " + root.contains(55));

    print("BST is valid = " + root.validate());
}