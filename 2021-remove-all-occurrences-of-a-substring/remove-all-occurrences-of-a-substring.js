/**
 * @param {string} s
 * @param {string} part
 * @return {string}
 */
var removeOccurrences = function (s, part) {
    const stack = [];
    const partLength = part.length;

    for (let char of s) {
        stack.push(char);

        // Check if the last characters in stack match `part`
        if (stack.length >= partLength && stack.slice(-partLength).join("") === part) {
            stack.length -= partLength; // Remove the last `part.length` characters
        }
    }

    return stack.join("");
};
