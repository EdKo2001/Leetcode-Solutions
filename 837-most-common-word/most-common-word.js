/**
 * @param {string} paragraph
 * @param {string[]} banned
 * @return {string}
 */
var mostCommonWord = function (paragraph, banned) {
    const freq = {};
    const bannedSet = new Set(banned);


    const normalizedStr = paragraph.toLowerCase().replace(/[^a-z0-9]+/g, ' ');

    let string = "";
    let maxCount = 0;
    let ans = "";
    for (let char of normalizedStr) {
        if (char === " ") {
            if (bannedSet.has(string)) {
                string = "";
                continue;
            }
            freq[string] = (freq[string] || 0) + 1;

            if (freq[string] > maxCount) {
                maxCount = freq[string];
                ans = string
            }

            string = "";
            continue;
        }
        string += char;
    }

    if (bannedSet.has(string)) return ans;
    freq[string] = (freq[string] || 0) + 1;

    if (freq[string] > maxCount) {
        maxCount = freq[string];
        return string;
    }

    return ans;
};