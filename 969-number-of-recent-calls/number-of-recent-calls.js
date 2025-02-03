var RecentCounter = function () {
    this.queue = [];
};

/** 
 * @param {number} t
 * @return {number}
 */
RecentCounter.prototype.ping = function (t) {
    this.queue.push(t);

    while (this.queue[0] < t - 3000) {
        this.queue.shift();
    }

    return this.queue.length;
};

/** 
 * Example usage:
 * var obj = new RecentCounter();
 * console.log(obj.ping(1));    // Output: 1
 * console.log(obj.ping(100));  // Output: 2
 * console.log(obj.ping(3001)); // Output: 3
 * console.log(obj.ping(3002)); // Output: 3
 */
