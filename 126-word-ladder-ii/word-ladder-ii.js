/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {string[][]}
 */
var findLadders = function (beginWord, endWord, wordList) {
    const wordSet = new Set(wordList);
    if (!wordSet.has(endWord)) return [];
    wordSet.delete(beginWord); // Optional: since we start from beginWord

    const parentMap = new Map(); // Maps a word to its parents in the shortest path
    const distance = new Map(); // Maps a word to its distance from beginWord
    distance.set(beginWord, 0);

    let queue = [beginWord];
    let found = false;

    while (queue.length > 0 && !found) {
        const nextLevel = new Set();

        // Process each word in the current level
        for (const word of queue) {
            if (word === endWord) {
                found = true;
            }

            // Generate all possible next words
            for (let i = 0; i < word.length; i++) {
                for (let c of 'abcdefghijklmnopqrstuvwxyz') {
                    if (c === word[i]) continue;
                    const nextWord = word.substring(0, i) + c + word.substring(i + 1);

                    if (wordSet.has(nextWord)) {
                        if (!distance.has(nextWord)) {
                            // First time encountering nextWord
                            distance.set(nextWord, distance.get(word) + 1);
                            parentMap.set(nextWord, [word]);
                            nextLevel.add(nextWord);
                        } else if (distance.get(nextWord) === distance.get(word) + 1) {
                            // Another parent in the same level
                            parentMap.get(nextWord).push(word);
                        }
                    }
                }
            }
        }

        // Check if endWord was added to the next level
        if (nextLevel.has(endWord)) {
            found = true;
        }

        // Prepare for next level
        queue = Array.from(nextLevel);
    }

    // If endWord is not reachable
    if (!parentMap.has(endWord)) return [];

    // Backtrack to find all paths
    const result = [];
    const backtrack = (node, path) => {
        if (node === beginWord) {
            path.reverse();
            result.push([...path]);
            path.reverse(); // Restore path for backtracking
            return;
        }
        const parents = parentMap.get(node) || [];
        for (const parent of parents) {
            path.push(parent);
            backtrack(parent, path);
            path.pop();
        }
    };

    backtrack(endWord, [endWord]);

    return result;
};