/**
 * @param {string} s
 * @param {number} k
 * @return {boolean}
 */
var hasSpecialSubstring = function (s, k) {
    let prev = -1;
    let curr = -1;
    let cnt = 1;
    for (let i = 0; i < s.length; i++) {
        if (i === 0) {
            curr = 0;
        } else
            if (s[i] === s[curr]) {
                cnt++;
            } else {
                curr = i;
                cnt = 1;
                prev = i - 1;
            }

        if (cnt === k && prev !== curr && (i === s.length - 1 ? true : s[curr] !== s[i + 1])) return true;
    }
    return false;
};