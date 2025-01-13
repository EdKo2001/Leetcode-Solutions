class Node {
    constructor(val, prev, next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}

/**
 * @param {string} homepage
 */
var BrowserHistory = function (homepage) {
    this.history = new Node(homepage);
};

/** 
 * @param {string} url
 * @return {void}
 */
BrowserHistory.prototype.visit = function (url) {
    this.history.next = new Node(url, this.history);
    this.history = this.history.next;
};

/** 
 * @param {number} steps
 * @return {string}
 */
BrowserHistory.prototype.back = function (steps) {
    while (this.history.prev && steps > 0) {
        this.history = this.history.prev;
        steps--;
    }
    return this.history.val;
};

/** 
 * @param {number} steps
 * @return {string}
 */
BrowserHistory.prototype.forward = function (steps) {
    while (this.history.next && steps > 0) {
        this.history = this.history.next;
        steps--;
    }
    return this.history.val;
};

/** 
 * Your BrowserHistory object will be instantiated and called as such:
 * var obj = new BrowserHistory(homepage)
 * obj.visit(url)
 * var param_2 = obj.back(steps)
 * var param_3 = obj.forward(steps)
 */