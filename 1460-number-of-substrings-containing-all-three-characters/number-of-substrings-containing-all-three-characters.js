/**
 * @param {string} s
 * @return {number}
 */
var numberOfSubstrings = function (s) {
    let cnt = 0;
    let start = 0;
    const currWindow = new Map();

    for (let end = 0; end < s.length; end++) {
        currWindow.set(s[end], (currWindow.get(s[end]) || 0) + 1);

        while (currWindow.get('a') > 0 && currWindow.get('b') > 0 && currWindow.get('c') > 0) {
            cnt += s.length - end;

            currWindow.set(s[start], currWindow.get(s[start]) - 1);
            start++;
        }
    }
    return cnt;
};
