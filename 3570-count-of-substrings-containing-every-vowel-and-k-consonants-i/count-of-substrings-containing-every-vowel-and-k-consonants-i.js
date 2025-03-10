/**
 * @param {string} word
 * @param {number} k
 * @return {number}
 */
var countOfSubstrings = function (word, k) {
    const vowelsSet = new Set(['a', 'e', 'i', 'o', 'u']);
    let count = 0;

    for (let i = 0; i < word.length; i++) {
        let cons = 0;
        let vowelsSeen = new Set();

        for (let j = i; j < word.length; j++) {
            let ch = word[j];
            if (vowelsSet.has(ch)) {
                vowelsSeen.add(ch);
            } else {
                cons++;
            }
            if (cons > k) break;

            if (cons === k && vowelsSeen.size === 5) count++;
        }
    }

    return count;
};
