// /**
//  * @param {string} s
//  * @param {number} k
//  * @return {number}
//  */
// var lengthOfLongestSubstringKDistinct = function (s, k) {
//     let max = 0;
//     const uniqueMap = new Map();

//     let start = 0;
//     for (let end = 0; end < s.length; end++) {
//         const char = s[end];
//         uniqueMap.set(char, (uniqueMap.get(char) || 0) + 1);

//         while (uniqueMap.size > k) {
//             const oldChar = s[start];
//             uniqueMap.set(oldChar, uniqueMap.get(oldChar) - 1);
//             if (uniqueMap.get(oldChar) === 0) {
//                 uniqueMap.delete(oldChar);
//             }
//             start++;
//         }

//         max = Math.max(max, end - start + 1);
//     }

//     return max;
// };

// /**
//  * @param {string} s
//  * @param {number} k
//  * @return {number}
//  */
var lengthOfLongestSubstringKDistinct = function (s, k) {
    if (k === 0) return 0;

    let maxLen = 0;
    let start = 0;
    let uniqueCount = 0;
    const charFreq = {};

    for (let end = 0; end < s.length; end++) {
        const char = s[end];
        if (!charFreq[char]) {
            uniqueCount++;
        }
        charFreq[char] = (charFreq[char] || 0) + 1;

        while (uniqueCount > k) {
            const leftChar = s[start];
            charFreq[leftChar]--;
            if (charFreq[leftChar] === 0) {
                delete charFreq[leftChar];
                uniqueCount--;
            }
            start++;
        }

        maxLen = Math.max(maxLen, end - start + 1);
    }

    return maxLen;
};
