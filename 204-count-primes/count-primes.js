/**
 * @param {number} n
 * @return {number}
 */
// TLE
// var countPrimes = function (n) {
//     let cnt = 0;
//     for (let i = 2; i < n; i++) {
//         if (isPrime(i)) cnt++;
//     }
//     return cnt;
// };

// const isPrime = (num) => {
//     for (let i = 2; i <= Math.sqrt(num); i++) {
//         if (num % i === 0) return false;
//     }
//     return true;
// }

/**
 * @param {number} n
 * @return {number}
 */
var countPrimes = function (n) {
    if (n <= 2) return 0;

    const isPrime = new Array(n).fill(true);
    isPrime[0] = isPrime[1] = false; // 0 and 1 are not prime

    for (let i = 2; i * i < n; i++) {
        if (isPrime[i]) {
            for (let j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
    }

    return isPrime.reduce((count, prime) => count + prime, 0);
};