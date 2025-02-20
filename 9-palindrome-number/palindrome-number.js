/**
 * @param {number} x
 * @return {boolean}
 */
var isPalindrome = function (x) {
    if (x < 0 || x % 10 == 0 && x != 0) return false;

    let originalNumber = x;
    let reversedNumber = 0;

    while (x > 0) {
        reversedNumber = reversedNumber * 10 + (x % 10);
        x = Math.floor(x / 10);
    }

    return reversedNumber === originalNumber;
};
