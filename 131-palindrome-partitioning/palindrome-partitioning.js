/**
 * @param {string} s
 * @return {string[][]}
 */
var partition = function (s) {
    let res = [];
    let n = s.length;

    function isPalindrome(left, right) {
        while (left < right) {
            if (s[left] !== s[right]) return false;
            left++;
            right--;
        }
        return true;
    }

    function backtrack(start, path) {
        if (start === n) {
            res.push([...path]);
            return;
        }
        for (let end = start; end < n; end++) {
            if (isPalindrome(start, end)) {
                path.push(s.substring(start, end + 1));
                backtrack(end + 1, path);
                path.pop();
            }
        }
    }

    backtrack(0, []);
    return res;
};
