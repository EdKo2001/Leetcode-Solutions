/**
 * @param {string} s
 * @return {string}
 */
var clearDigits = function (s) {
    const stack = [];

    for (let char of s) {
        if (char >= '0' && char <= '9') {
            // if (!isNaN(char) && char !== ' ') {
            stack.pop();
        } else {
            stack.push(char);
        }
    }

    return stack.join('');
};