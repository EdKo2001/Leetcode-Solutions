var NumberContainers = function() {
  this.indexToNumber = {};
  this.numberToHeap = {};
};

/** 
 * @param {number} index 
 * @param {number} number
 * @return {void}
 */
NumberContainers.prototype.change = function(index, number) {
  this.indexToNumber[index] = number;
  
  if (!this.numberToHeap[number]) {
    this.numberToHeap[number] = new MinPriorityQueue();
  }
  
  this.numberToHeap[number].enqueue(index);
};

/** 
 * @param {number} number
 * @return {number}
 */
NumberContainers.prototype.find = function(number) {
  if (!this.numberToHeap[number] || this.numberToHeap[number].size() === 0) return -1;
  
  const heap = this.numberToHeap[number];
  
  while (heap.size() > 0 && this.indexToNumber[heap.front().element] !== number) {
    heap.dequeue();
  }
  
  if (heap.size() === 0) return -1;
  
  return heap.front().element;
};

/** 
 * Your NumberContainers object will be instantiated and called as such:
 * var obj = new NumberContainers()
 * obj.change(index, number)
 * var param_2 = obj.find(number)
 */
