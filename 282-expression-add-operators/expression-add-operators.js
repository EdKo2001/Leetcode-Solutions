/**
 * @param {string} num
 * @param {number} target
 * @return {string[]}
 */
var addOperators = function(num, target) {
    let result = [];
    
    function backtrack(path, pos, currVal, prevNum) {
        if (pos === num.length) {
            if (currVal === target) {
                result.push(path);
            }
            return;
        }

        for (let i = pos; i < num.length; i++) {
            if (i > pos && num[pos] === '0') break; // Skip numbers with leading zeros

            let currStr = num.substring(pos, i + 1);
            let currNum = parseInt(currStr);

            if (pos === 0) {
                // First number, no operator needed
                backtrack(path + currStr, i + 1, currNum, currNum);
            } else {
                backtrack(path + "+" + currStr, i + 1, currVal + currNum, currNum);
                backtrack(path + "-" + currStr, i + 1, currVal - currNum, -currNum);
                backtrack(path + "*" + currStr, i + 1, currVal - prevNum + prevNum * currNum, prevNum * currNum);
            }
        }
    }

    backtrack("", 0, 0, 0);
    return result;
};
