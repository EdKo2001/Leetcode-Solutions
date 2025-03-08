/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */

const aCharCode = "a".charCodeAt(0);

var ladderLength = function (beginWord, endWord, wordList) {
    const wordSet = new Set(wordList);
    if (!wordSet.has(endWord)) return 0;

    const queue = [{ word: beginWord, lvl: 1 }];

    while (queue.length > 0) {
        const { word, lvl } = queue.shift();

        if (word === endWord) return lvl;

        // Generate all possible words by changing one character at a time
        for (let i = 0; i < word.length; i++) {
            const chars = word.split("");

            for (let charCode = 0; charCode < 26; charCode++) {
                const newChar = String.fromCharCode(charCode + aCharCode);
                chars[i] = newChar;
                const newWord = chars.join("");

                if (wordSet.has(newWord)) {
                    queue.push({ word: newWord, lvl: lvl + 1 });
                    wordSet.delete(newWord);
                }
            }
        }
    }

    return 0;
};


// Bidirectional BFS
// var ladderLength = function (beginWord, endWord, wordList) {
//     const wordSet = new Set(wordList);
//     if (!wordSet.has(endWord)) return 0;

//     let beginSet = new Set([beginWord]);
//     let endSet = new Set([endWord]);
//     let level = 1;

//     while (beginSet.size > 0 && endSet.size > 0) {
//         // Always expand the smaller set to optimize performance
//         if (beginSet.size > endSet.size) {
//             [beginSet, endSet] = [endSet, beginSet];
//         }

//         const nextSet = new Set();
//         for (let word of beginSet) {
//             const wordArr = word.split("");
//             for (let i = 0; i < wordArr.length; i++) {
//                 const originalChar = wordArr[i];

//                 for (let j = 0; j < 26; j++) {
//                     wordArr[i] = String.fromCharCode(97 + j);
//                     const newWord = wordArr.join("");

//                     if (endSet.has(newWord)) return level + 1; // Found shortest path

//                     if (wordSet.has(newWord)) {
//                         nextSet.add(newWord);
//                         wordSet.delete(newWord);
//                     }
//                 }

//                 wordArr[i] = originalChar; // Restore the original character
//             }
//         }

//         beginSet = nextSet;
//         level++;
//     }

//     return 0;
// };