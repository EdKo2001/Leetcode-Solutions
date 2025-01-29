/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function (strs) {
    //Time Complexity Analysis: Sorting each string: O(KlogK), where \U0001d43e K is the length of the string.
    // Processing all strings: O(NKlogK), where \U0001d441 N is the number of strings.
    // const group = {};

    // for (const str of strs) {
    //     let key = str.split("").sort().join(""); // Sort string as key
    //     if (!group[key]) group[key] = [];
    //     group[key].push(str);
    // }

    // return Object.values(group);

    // This avoids sorting and runs in O(NK) time.
    const group = {};

    for (const str of strs) {
        const count = new Array(26).fill(0);
        for (const char of str) {
            count[char.charCodeAt(0) - "a".charCodeAt(0)]++;
        }
        let key = count.join("#"); // Use frequency count as key
        if (!group[key]) group[key] = [];
        group[key].push(str);
    }

    return Object.values(group);
};