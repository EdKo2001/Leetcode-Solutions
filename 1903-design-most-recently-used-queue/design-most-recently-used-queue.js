/**
 * @param {number} n
 */
var MRUQueue = function(n) {
    this.arr = Array.from({ length: n }, (_, i) => i + 1);
};

/** 
 * @param {number} k
 * @return {number}
 */
MRUQueue.prototype.fetch = function(k) {
    const index = k - 1;
    const [fetchedElement] = this.arr.splice(index, 1);
    this.arr.push(fetchedElement);
    return fetchedElement;
};
