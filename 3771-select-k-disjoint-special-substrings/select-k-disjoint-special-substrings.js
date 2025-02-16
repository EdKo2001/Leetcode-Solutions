/**
 * @param {string} s
 * @param {number} k
 * @return {boolean}
 */
var maxSubstringLength = function (s, k) {
    // If k is 0, we can always choose 0 substrings.
    if (k === 0) return true;

    const n = s.length;
    const first = new Array(26).fill(n);
    const last = new Array(26).fill(-1);

    // Record first and last occurrence for each letter.
    for (let i = 0; i < n; i++) {
        const idx = s.charCodeAt(i) - 97;
        first[idx] = Math.min(first[idx], i);
        last[idx] = i;
    }

    const candidates = [];

    // For every index i that is the first occurrence of its letter,
    // try to expand the interval to cover all occurrences of all letters inside.
    for (let i = 0; i < n; i++) {
        const idx = s.charCodeAt(i) - 97;
        if (i !== first[idx]) continue; // only start at the first occurrence

        let j = last[idx]; // initial candidate end
        let valid = true;

        // Expand the candidate interval
        for (let m = i; m <= j; m++) {
            const curIdx = s.charCodeAt(m) - 97;
            // If some letter in s[i...j] has an occurrence before i, this candidate fails.
            if (first[curIdx] < i) {
                valid = false;
                break;
            }
            // Extend j if this letter appears later.
            j = Math.max(j, last[curIdx]);
        }

        // Disallow if the candidate equals the entire string.
        if (valid && !(i === 0 && j === n - 1)) {
            candidates.push([i, j]);
        }
    }

    // Sort the candidate intervals by their ending index (and then by starting index)
    candidates.sort((a, b) => a[1] - b[1] || a[0] - b[0]);

    // Greedy selection: choose as many disjoint intervals as possible.
    let count = 0;
    let lastEnd = -1;
    for (const [start, end] of candidates) {
        if (start > lastEnd) {
            count++;
            lastEnd = end;
        }
    }

    return count >= k;
};
