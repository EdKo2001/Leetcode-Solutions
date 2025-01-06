/**
 * @param {string[]} words
 * @return {boolean}
 */
var makeEqual = function (words) {
    const counts = new Array(26).fill(0);

    for (const word of words) {
        for (const char of word) {
            counts[char.charCodeAt(0) - 'a'.charCodeAt(0)]++;
        }
    }

    const n = words.length;
    for (const count of counts) {
        if (count % n !== 0) {
            return false;
        }
    }

    return true;
};
