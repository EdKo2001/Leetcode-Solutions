/**
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 */
var coinChange = function (coins, amount) {
    if (amount === 0) return 0;

    let queue = [amount];
    let visited = new Set();
    let steps = 0;

    while (queue.length > 0) {
        steps++;
        let nextQueue = [];

        for (let remaining of queue) {
            for (let coin of coins) {
                let newAmount = remaining - coin;
                if (newAmount === 0) return steps;
                if (newAmount > 0 && !visited.has(newAmount)) {
                    visited.add(newAmount);
                    nextQueue.push(newAmount);
                }
            }
        }

        queue = nextQueue;
    }

    return -1;
};
