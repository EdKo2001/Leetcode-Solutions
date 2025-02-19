/**
 * @param {number} n
 * @param {number} k
 * @return {string}
 */
var getHappyString = function (n, k) {
    const happyStrings = [];
    const chars = ['a', 'b', 'c'];

    const generateHappyString = (str) => {
        if (str.length === n) {
            happyStrings.push(str);
            return;
        }

        for (let char of chars) {
            if (str[str.length - 1] !== char) {
                generateHappyString(str + char);
            }
        }
    };

    generateHappyString("");

    return happyStrings[k - 1] || "";
};
