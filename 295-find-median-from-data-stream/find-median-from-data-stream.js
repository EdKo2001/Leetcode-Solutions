var MedianFinder = function () {
    this.arr = [];
};

/** 
 * @param {number} num
 * @return {void}
 */
MedianFinder.prototype.addNum = function (num) {
    let left = 0, right = this.arr.length;
    while (left < right) {
        const mid = Math.floor((left + right) / 2);
        if (this.arr[mid] < num) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }
    this.arr.splice(left, 0, num);
};

/**
 * @return {number}
 */
MedianFinder.prototype.findMedian = function () {
    const n = this.arr.length;
    if (n % 2 === 0) {
        return (this.arr[n / 2] + this.arr[n / 2 - 1]) / 2;
    } else {
        return this.arr[Math.floor(n / 2)];
    }
};
