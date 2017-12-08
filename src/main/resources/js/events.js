function Events() {
    this.callbackMap = {};
}

Events.prototype.on = function(eventName, callback) {

    // The 'OR' statement returns left side if truthy otherwise the right side
    (this.callbackMap[eventName] || (this.callbackMap[eventName] = [])).push(callback);

    print("CB Map: " + JSON.stringify(this.callbackMap));
};

Events.prototype.trigger = function(eventName) {
    var cbArray = this.callbackMap[eventName];

    if (cbArray) {
        cbArray.forEach(function(cbFunc, idx, arr) {
            cbFunc(idx, arr);
        })
    }
};

Events.prototype.off = function(eventName) {
    delete this.callbackMap[eventName];
};

function testEvents() {

    var events = new Events();

    events.trigger('missingFunction');
    events.off('missingFunction');

    events.on('print', function(idx, arr) { print(idx + " : First callback function of " + arr.length)});
    events.on('print', function(idx, arr) { print(idx + " : Second callback function of " + arr.length)});

    events.trigger('print');
    events.off('print');
    events.trigger('print');
}
