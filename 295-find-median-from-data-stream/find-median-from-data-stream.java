class MedianFinder {
    PriorityQueue<Integer> minHeap; // to store the larger half
    PriorityQueue<Integer> maxHeap; // to store the smaller half

    public MedianFinder() {
        minHeap = new PriorityQueue<>(); // Min-Heap for the larger half
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder()); // Max-Heap for the smaller half
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num); // Add to maxHeap if it's smaller or equal to maxHeap's root
        } else {
            minHeap.add(num); // Otherwise, add to minHeap
        }

        // Balance the heaps: maxHeap can have at most one more element than minHeap
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll()); // Move the largest element of maxHeap to minHeap
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll()); // Move the smallest element of minHeap to maxHeap
        }
    }

    public double findMedian() {
        // If maxHeap has more elements, the median is the root of maxHeap
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        // If both heaps have the same size, the median is the average of the two roots
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
