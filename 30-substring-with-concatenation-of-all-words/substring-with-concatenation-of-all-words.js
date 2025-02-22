/**
 * @param {string} s
 * @param {string[]} words
 * @return {number[]}
 */
// TLE
// var findSubstring = function (s, words) {
//     let ans = [];
//     const generatedWords = new Set();

//     let windowSize = words[0].length * words.length;
//     let wordLength = words[0].length;

//     const generateWords = (str, used) => {
//         if (str.length === windowSize) {
//             generatedWords.add(str);
//             return;
//         }
//         for (const word of words) {
//             if (used[word] < (words.filter(w => w === word).length)) {
//                 used[word] += 1;
//                 generateWords(str + word, used);
//                 used[word] -= 1;
//             }
//         }
//     };

//     generateWords("", Object.fromEntries(words.map(w => [w, 0])));

//     let start = 0;
//     let wordBuffer = [];
//     for (let end = 0; end < s.length; end++) {
//         wordBuffer.push(s[end]);

//         while (wordBuffer.length > windowSize) {
//             wordBuffer.shift();
//             start++;
//         }

//         if (wordBuffer.length === windowSize && generatedWords.has(wordBuffer.join(''))) {
//             ans.push(start);
//         }
//     }

//     return ans;
// };

var findSubstring = function (s, words) {
    if (!s || words.length === 0) return [];

    const wordLength = words[0].length;
    const numWords = words.length;
    const windowSize = wordLength * numWords;
    const ans = [];

    const wordCount = new Map();
    for (const word of words) {
        wordCount.set(word, (wordCount.get(word) || 0) + 1);
    }

    for (let i = 0; i < wordLength; i++) {
        let left = i;
        let right = i;
        let currentCount = new Map();
        let wordsUsed = 0;

        while (right + wordLength <= s.length) {
            const word = s.substring(right, right + wordLength);
            right += wordLength;

            if (wordCount.has(word)) {
                currentCount.set(word, (currentCount.get(word) || 0) + 1);
                wordsUsed++;

                while (currentCount.get(word) > wordCount.get(word)) {
                    const leftWord = s.substring(left, left + wordLength);
                    currentCount.set(leftWord, currentCount.get(leftWord) - 1);
                    wordsUsed--;
                    left += wordLength;
                }

                if (wordsUsed === numWords) ans.push(left);
            } else {
                currentCount.clear();
                wordsUsed = 0;
                left = right;
            }
        }
    }

    return ans;
};
