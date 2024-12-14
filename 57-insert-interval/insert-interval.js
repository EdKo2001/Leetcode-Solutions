/**
 * @param {number[][]} intervals
 * @param {number[]} newInterval
 * @return {number[][]}
 */
var insert = function (intervals, newInterval) {
    const res = [];
    let [newStart, newEnd] = newInterval;

    for (const [start, end] of intervals) {
        if (end < newStart) {
            // Current interval ends before the new interval starts
            res.push([start, end]);
        } else if (start > newEnd) {
            // Current interval starts after the new interval ends
            res.push([newStart, newEnd]);
            newStart = start;
            newEnd = end;
        } else {
            // Overlapping intervals; merge them
            newStart = Math.min(newStart, start);
            newEnd = Math.max(newEnd, end);
        }
    }

    // Add the merged interval (if not already added)
    res.push([newStart, newEnd]);

    return res;
};
