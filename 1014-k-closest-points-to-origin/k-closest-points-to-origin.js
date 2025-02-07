var kClosest = function (points, k) {
    const maxHeap = new MaxPriorityQueue({ priority: (point) => point[0] * point[0] + point[1] * point[1] });

    for (const point of points) {
        maxHeap.enqueue(point);

        if (maxHeap.size() > k) {
            maxHeap.dequeue();
        }
    }

    return maxHeap.toArray().map((item) => item.element);
};
