/**
 * @param {number[]} nums
 * @return {number}
 */
var sumOfUnique = function (nums) {
    // Object
    const dic = {};
    for (let num of nums) {
        if (dic.hasOwnProperty(num)) {
            dic[num] += 1;
        } else {
            dic[num] = 1
        }
    }
    let ans = 0;
    for (const [key, val] of Object.entries(dic)) {
        if (val === 1) {
            ans += +key;
        }
    }
    return ans;
    // Map
};