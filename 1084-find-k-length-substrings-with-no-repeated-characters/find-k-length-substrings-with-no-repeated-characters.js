/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
var numKLenSubstrNoRepeats = function (s, k) {
    const charFreq = {};
    let cnt = 0;
    let start = 0;
    for (let end = 0; end < s.length; end++) {
        let char = s[end];

        charFreq[char] = (charFreq[char] || 0) + 1;

        while (charFreq[char] > 1) {
            let target = s[start++];
            charFreq[target]--;
        }

        if (end - start + 1 === k) {
            cnt++;
            charFreq[s[start++]] -= 1;
        }
    }


    return cnt;
};