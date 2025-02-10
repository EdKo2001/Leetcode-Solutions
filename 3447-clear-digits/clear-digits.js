/**
 * @param {string} s
 * @return {string}
 */
var clearDigits = function (s) {
    const stack = [];

    for (let char of s) {
        if (!isNaN(char)) {
            stack.pop();
        } else {
            stack.push(char);
        }
    }

    return stack.join('');
};