/**
 * @param {string} pattern
 * @return {string}
 */
var smallestNumber = function (pattern) {
    let ans = "";
    let stack = [];

    for (let i = 0; i <= pattern.length; i++) {
        stack.push(i + 1);

        if (i === pattern.length || pattern[i] === "I") {
            while (stack.length) {
                ans += stack.pop();
            }
        }
    }

    return ans;
};
