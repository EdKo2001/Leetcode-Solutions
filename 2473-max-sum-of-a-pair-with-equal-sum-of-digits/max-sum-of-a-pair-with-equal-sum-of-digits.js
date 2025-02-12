/**
 * @param {number[]} nums
 * @return {number}
 */
var maximumSum = function (nums) {
    let maxSum = -1;
    const digitSumMap = {};

    for (const num of nums) {
        const digitsSum = sumOfDigits(num);

        if (digitSumMap[digitsSum] !== undefined) {
            maxSum = Math.max(maxSum, num + digitSumMap[digitsSum]);
            digitSumMap[digitsSum] = Math.max(digitSumMap[digitsSum], num);
        } else {
            digitSumMap[digitsSum] = num;
        }
    }

    return maxSum;
};

/**
 * Helper function to calculate sum of digits of a number.
 */
const sumOfDigits = (num) => {
    let sum = 0;
    while (num > 0) {
        sum += num % 10;
        num = Math.floor(num / 10);
    }
    return sum;
};
