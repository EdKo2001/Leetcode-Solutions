// // HashTable
// /**
//  * @param {number} capacity
//  */
// var LRUCache = function (capacity) {
//     this.capacity = capacity;
//     this.cache = {};
//     this.order = 0;
// };

// /** 
//  * @param {number} key
//  * @return {number}
//  */
// LRUCache.prototype.get = function (key) {
//     if (this.cache.hasOwnProperty(key)) {
//         this.cache[key].order = this.order++;
//         return this.cache[key].value;
//     }
//     return -1;
// };

// /** 
//  * @param {number} key 
//  * @param {number} value
//  * @return {void}
//  */
// LRUCache.prototype.put = function (key, value) {
//     if (this.cache.hasOwnProperty(key)) {
//         this.cache[key].value = value;
//         this.cache[key].order = this.order++;
//     } else {
//         if (Object.keys(this.cache).length >= this.capacity) {
//             let oldestKey = null;
//             let oldestOrder = Infinity;
//             for (let k in this.cache) {
//                 if (this.cache[k].order < oldestOrder) {
//                     oldestOrder = this.cache[k].order;
//                     oldestKey = k;
//                 }
//             }
//             delete this.cache[oldestKey];
//         }
//         this.cache[key] = { value, order: this.order++ };
//     }
// };

// /** 
//  * Your LRUCache object will be instantiated and called as such:
//  * var obj = new LRUCache(capacity)
//  * var param_1 = obj.get(key)
//  * obj.put(key,value)
//  */

/**
 * @param {number} capacity
 */
var LRUCache = function (capacity) {
    this.capacity = capacity;
    this.cache = new Map(); // For quick look-up of cache items
    this.order = new DoublyLinkedList(); // Doubly linked list to track order of items
};

/**
 * Doubly Linked List node structure
 */
function ListNode(key, value) {
    this.key = key;
    this.value = value;
    this.prev = null;
    this.next = null;
}

/**
 * Doubly Linked List to track the order
 */
function DoublyLinkedList() {
    this.head = new ListNode(null, null); // Dummy head
    this.tail = new ListNode(null, null); // Dummy tail
    this.head.next = this.tail;
    this.tail.prev = this.head;
}

/**
 * Remove node from linked list
 */
DoublyLinkedList.prototype.remove = function (node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
};

/**
 * Add node to the front (most recently used)
 */
DoublyLinkedList.prototype.addFront = function (node) {
    node.next = this.head.next;
    node.prev = this.head;
    this.head.next.prev = node;
    this.head.next = node;
};

/** 
 * @param {number} key
 * @return {number}
 */
LRUCache.prototype.get = function (key) {
    if (!this.cache.has(key)) {
        return -1;
    }
    const node = this.cache.get(key);
    this.order.remove(node);
    this.order.addFront(node); // Move the accessed node to the front (most recently used)
    return node.value;
};

/** 
 * @param {number} key 
 * @param {number} value
 * @return {void}
 */
LRUCache.prototype.put = function (key, value) {
    if (this.cache.has(key)) {
        // If key exists, update its value and move it to the front
        const node = this.cache.get(key);
        node.value = value;
        this.order.remove(node);
        this.order.addFront(node);
    } else {
        // If the cache exceeds capacity, remove the least recently used (LRU) item
        if (this.cache.size >= this.capacity) {
            const lruNode = this.order.tail.prev;
            this.order.remove(lruNode); // Remove from the linked list
            this.cache.delete(lruNode.key); // Remove from the cache
        }
        // Create a new node for the new key-value pair and add it to the front
        const newNode = new ListNode(key, value);
        this.order.addFront(newNode);
        this.cache.set(key, newNode);
    }
};

/** 
 * Your LRUCache object will be instantiated and called as such:
 * var obj = new LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */
