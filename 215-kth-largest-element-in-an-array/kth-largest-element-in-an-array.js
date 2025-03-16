/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findKthLargest = function (nums, k) {
    const minHeap = new MinPriorityQueue();

    for (const num of nums) {
        if (minHeap.size() < k || minHeap.front() < num) minHeap.enqueue(num);
        if (minHeap.size() > k) minHeap.dequeue();
    }

    return minHeap.front();
};
