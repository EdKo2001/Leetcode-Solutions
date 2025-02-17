/**
 * @param {string[]} words
 * @param {string} s
 * @return {string}
 */
var boldWords = function (words, s) {
    const bold = new Array(s.length).fill(false);

    for (let i = 0; i < s.length; i++) {
        for (const word of words) {
            if (s.slice(i, i + word.length) === word) {
                for (let j = i; j < i + word.length; j++) {
                    bold[j] = true;
                }
            }
        }
    }

    const ans = [];
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