/**
 * @param {string} paragraph
 * @param {string[]} banned
 * @return {string}
 */
var mostCommonWord = function (paragraph, banned) {
    const bannedSet = new Set(banned.map(word => word.toLowerCase()));

    const words = paragraph.toLowerCase().replace(/[^a-z0-9]+/g, ' ').split(' ');

    const freq = {};
    let maxWord = "";
    let maxCount = 0;

    for (const word of words) {
        if (!bannedSet.has(word)) {
            freq[word] = (freq[word] || 0) + 1;
            if (freq[word] > maxCount) {
                maxCount = freq[word];
                maxWord = word;
            }
        }
    }

    return maxWord;
};
