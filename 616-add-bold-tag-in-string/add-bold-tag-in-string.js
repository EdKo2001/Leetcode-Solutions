/**
 * @param {string} s
 * @param {string[]} words
 * @return {string}
 */
var addBoldTag = function (s, words) {
    const bold = new Array(s.length).fill(false);

    for (let i = 0; i < s.length; i++) {
        for (const word of words) {
            if (s.startsWith(word, i)) {
                // Mark indices from i to i + word.length - 1 as true
                for (let j = i; j < i + word.length; j++) {
                    bold[j] = true;
                }
            }
        }
    }

    let ans = [];
    for (let i = 0; i < s.length; i++) {
        if (bold[i] && (i === 0 || !bold[i - 1])) {
            ans.push("<b>");
        }
        ans.push(s[i]);
        if (bold[i] && (i === s.length - 1 || !bold[i + 1])) {
            ans.push("</b>");
        }
    }

    return ans.join('');
};