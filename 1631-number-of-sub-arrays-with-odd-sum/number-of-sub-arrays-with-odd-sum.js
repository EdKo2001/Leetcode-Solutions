/**
 * @param {number[]} arr
 * @return {number}
 */
var numOfSubarrays = function (arr) {
    const MOD = 10 ** 9 + 7;
    let odd_count = 0, even_count = 1,  // even_count starts as 1 (empty prefix)
        prefix_sum = 0, result = 0;

    for (num of arr) {
        prefix_sum += num
        if (prefix_sum % 2 == 0) {
            result = (result + odd_count) % MOD;
            even_count += 1;
        } else {
            result = (result + even_count) % MOD;
            odd_count += 1;
        }
    }

    return result;
};