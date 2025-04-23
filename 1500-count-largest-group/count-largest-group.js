/**
 * @param {number} n
 * @return {number}
 */
var countLargestGroup = function (n) {
    let hashMap = {};
    let maxValue = 0;
    for (let i = 1; i <= n; ++i) {
        let key = 0,
            i0 = i;
        while (i0) {
            key += i0 % 10;
            i0 = Math.floor(i0 / 10);
        }
        hashMap[key] = (hashMap[key] || 0) + 1;
        maxValue = Math.max(maxValue, hashMap[key]);
    }

    let count = 0;
    for (let value of Object.values(hashMap)) {
        if (value === maxValue) {
            count++;
        }
    }
    return count;
};