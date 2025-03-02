/**
 * @param {number} n
 * @param {number} k
 * @return {string}
 */
var getPermutation = function (n, k) {
    let cnt = 0;
    let ans;
    const seen = new Array(n + 1).fill(false);
    const backtrack = (arr) => {
        if (arr.length === n) {
            cnt++;
            if (cnt === k) return ans = arr.join('');
            else return;
        }
        for (let i = 1; i <= n; i++) {
            if (seen[i]) continue;
            seen[i] = true;
            arr.push(i);
            backtrack(arr);
            seen[i] = false;
            arr.pop();
        }
    }
    backtrack([]);
    return ans;
};