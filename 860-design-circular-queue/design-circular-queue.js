/**
 * @param {number} k
 */
var MyCircularQueue = function (k) {
    this.queue = new Array(k);
    this.k = k;
    this.front = 0;
    this.rear = -1;
    this.size = 0;
};

/** 
 * @param {number} value
 * @return {boolean}
 */
MyCircularQueue.prototype.enQueue = function (value) {
    if (this.isFull()) return false;

    this.rear = (this.rear + 1) % this.k; // Move rear forward in a circular manner
    this.queue[this.rear] = value;
    this.size++;
    return true;
};

/**
 * @return {boolean}
 */
MyCircularQueue.prototype.deQueue = function () {
    if (this.isEmpty()) return false;

    this.queue[this.front] = null; // Clear the dequeued element
    this.front = (this.front + 1) % this.k; // Move front forward
    this.size--;
    return true;
};

/**
 * @return {number}
 */
MyCircularQueue.prototype.Front = function () {
    return this.isEmpty() ? -1 : this.queue[this.front];
};

/**
 * @return {number}
 */
MyCircularQueue.prototype.Rear = function () {
    return this.isEmpty() ? -1 : this.queue[this.rear];
};

/**
 * @return {boolean}
 */
MyCircularQueue.prototype.isEmpty = function () {
    return this.size === 0;
};

/**
 * @return {boolean}
 */
MyCircularQueue.prototype.isFull = function () {
    return this.size === this.k;
};
