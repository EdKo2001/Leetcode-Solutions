/**
 * @param {number[]} arr
 * @return {number}
 */
function lenLongestFibSubseq(arr) {
    const n = arr.length;
    const numSet = new Set(arr);
    let maxLen = 0;

    for (let start = 0; start < n; ++start) {
        for (let next = start + 1; next < n; ++next) {
            let prev = arr[next];
            let curr = arr[start] + arr[next];
            let len = 2;

            while (numSet.has(curr)) {
                let temp = curr;
                curr += prev;
                prev = temp;
                maxLen = Math.max(maxLen, ++len);
            }
        }
    }

    return maxLen;
}
