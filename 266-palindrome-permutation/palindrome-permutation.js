/**
 * @param {string} s
 * @return {boolean}
 */
var canPermutePalindrome = function (s) {
    const dic = new Map();
    let odd = 0;

    for (const char of s) {
        dic.set(char, (dic.get(char) || 0) + 1);

        if (dic.get(char) % 2 === 0) {
            odd--;
        } else {
            odd++;
        }
    }

    return odd < 2;
};
