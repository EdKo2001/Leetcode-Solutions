/**
 * @param {number[]} nums
 * @return {number}
 */
var sumOfUnique = function (nums) {
    // Object
    // const dic = {};
    // for (let num of nums) {
    //     dic[num] = (dic[num] || 0) + 1;
    // }
    // let ans = 0;
    // for (const [key, val] of Object.entries(dic)) {
    //     if (val === 1) {
    //         ans += +key;
    //     }
    // }
    // return ans;
    // Map
    const dic = new Map();
    for (let num of nums) {
        dic.set(num, (dic.get(num) || 0) + 1);
    }
    let ans = 0;
    for (const [key, val] of dic) {
        if (val === 1) {
            ans += key;
        }
    }
    return ans;
};