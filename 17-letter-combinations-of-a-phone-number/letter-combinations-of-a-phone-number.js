/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function (digits) {
    if (digits === "") return [];
    const dic = { "2": ["a", "b", "c"], "3": ["d", "e", "f"], "4": ["g", "h", "i"], "5": ["j", "k", "l"], "6": ["m", "n", "o"], "7": ["p", "q", "r", "s"], "8": ["t", "u", "v"], "9": ["w", "x", "y", "z"] }
    const ans = [];
    const n = digits.length;
    const backtrack = (arr, start) => {
        if (arr.length === n) return ans.push(arr.join(''));
        for (let i = start; i < n; i++) {
            for (let digit of dic[digits[i]]) {
                arr.push(digit);
                backtrack(arr, i + 1);
                arr.pop();
            }

        }
    }
    backtrack([], 0);
    return ans;
};