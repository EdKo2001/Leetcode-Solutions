/**
 * @param {string} s
 * @param {string} p
 * @return {number[]}
 */
// Time Complexity: O(N) (since we check at most 26 letters at each step)
// Space Complexity: O(1) (constant since there are only 26 lowercase letters)
var findAnagrams = function (s, p) {
    const anagramTable = {};
    for (const char of p) {
        anagramTable[char] = (anagramTable[char] || 0) + 1;
    }

    const res = [];
    const windowTable = {};
    let left = 0, right = 0;

    while (right < s.length) {
        windowTable[s[right]] = (windowTable[s[right]] || 0) + 1;

        if (right - left + 1 === p.length) {
            if (matchAnagramTables(anagramTable, windowTable)) {
                res.push(left);
            }
            windowTable[s[left]]--;
            if (windowTable[s[left]] === 0) delete windowTable[s[left]];
            left++;
        }

        right++;
    }

    return res;
};

const matchAnagramTables = (table1, table2) => {
    return Object.keys(table1).every(key => table1[key] === table2[key]);
};
