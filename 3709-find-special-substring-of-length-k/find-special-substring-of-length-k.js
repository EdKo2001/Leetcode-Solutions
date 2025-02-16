/**
 * @param {string} s
 * @param {number} k
 * @return {boolean}
 */
var hasSpecialSubstring = function (s, k) {
    let cnt = 1;

    for (let i = 1; i < s.length; i++) {
        if (s[i] === s[i - 1]) {
            cnt++;
        } else {
            if (cnt === k) return true;
            cnt = 1;
        }
    }

    return cnt === k;
};
