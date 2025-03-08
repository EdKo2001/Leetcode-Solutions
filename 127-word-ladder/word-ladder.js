/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
// var ladderLength = function (beginWord, endWord, wordList) {
//     const wordSet = new Set(wordList);

//     if (!wordSet.has(endWord)) return 0;

//     const queue = [];
//     queue.push({ word: beginWord, lvl: 1 });

//     let ans = Infinity;

//     while (queue.length > 0) {
//         const { word, lvl } = queue.shift();
//         if (word === endWord) {
//             ans = Math.min(ans, lvl)
//             continue;
//         };

//         const charsOfWord = word.split("");
//         for (let char = 0; char < charsOfWord.length; char++) {
//             for (let i = "a".charCodeAt(0); i <= "z".charCodeAt(0); i++) {
//                 let temp = charsOfWord[char];
//                 charsOfWord[char] = String.fromCharCode(i);
//                 const newWord = charsOfWord.join("");
//                 if (wordSet.has(newWord)) {
//                     queue.push({ word: newWord, lvl: lvl + 1 });
//                     wordSet.delete(newWord);
//                 }
//                 charsOfWord[char] = temp;
//             }
//         }
//     }

//     return ans === Infinity ? 0 : ans;
// };

// Bidirectional BFS
var ladderLength = function (beginWord, endWord, wordList) {
    const wordSet = new Set(wordList);
    if (!wordSet.has(endWord)) return 0;

    let beginSet = new Set([beginWord]);
    let endSet = new Set([endWord]);
    let level = 1;

    while (beginSet.size > 0 && endSet.size > 0) {
        // Always expand the smaller set to optimize performance
        if (beginSet.size > endSet.size) {
            [beginSet, endSet] = [endSet, beginSet];
        }

        const nextSet = new Set();
        for (let word of beginSet) {
            const wordArr = word.split("");
            for (let i = 0; i < wordArr.length; i++) {
                const originalChar = wordArr[i];

                for (let j = 0; j < 26; j++) {
                    wordArr[i] = String.fromCharCode(97 + j);
                    const newWord = wordArr.join("");

                    if (endSet.has(newWord)) return level + 1; // Found shortest path

                    if (wordSet.has(newWord)) {
                        nextSet.add(newWord);
                        wordSet.delete(newWord);
                    }
                }

                wordArr[i] = originalChar; // Restore the original character
            }
        }

        beginSet = nextSet;
        level++;
    }

    return 0;
};