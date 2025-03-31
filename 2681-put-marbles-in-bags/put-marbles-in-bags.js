/**
 * @param {number[]} weights
 * @param {number} k
 * @return {number}
 */
var putMarbles = function (weights, k) {
    const n = weights.length;

    const pairCosts = [];

    for (let i = 0; i < n - 1; i++) {
        pairCosts.push(weights[i] + weights[i + 1]);
    }

    pairCosts.sort((a, b) => a - b);

    let minExtra = 0;
    let maxExtra = 0;

    for (let i = 0; i < k - 1; i++) {
        minExtra += pairCosts[i];
        maxExtra += pairCosts[pairCosts.length - 1 - i];
    }

    return maxExtra - minExtra;
};