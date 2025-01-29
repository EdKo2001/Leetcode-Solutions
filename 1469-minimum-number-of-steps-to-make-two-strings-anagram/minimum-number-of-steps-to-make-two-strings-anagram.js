/**
 * @param {string} s
 * @param {string} t
 * @return {number}
 */
var minSteps = function (s, t) {
    const dic = {};

    for (let char of s) {
        if (!dic[char]) dic[char] = 1;
        else dic[char]++;
    }

    for (let char of t) {
        dic[char]--;
    }

    let diff = 0;

    for (let cnt of Object.values(dic)) {
        diff += cnt > 0 ? cnt : 0;
    }

    return diff;
};