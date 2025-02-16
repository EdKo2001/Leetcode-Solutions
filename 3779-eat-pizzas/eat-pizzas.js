/**
 * @param {number[]} pizzas
 * @return {number}
 */
var maxWeight = function (pizzas) {
    const totalDays = pizzas.length / 4;

    pizzas.sort((a, b) => a - b);

    const oddDays = Math.floor((totalDays + 1) / 2);
    const evenDays = Math.floor(totalDays / 2);

    let ans = 0;
    let index = pizzas.length - 1;

    for (let i = 0; i < oddDays; i++) {
        ans += pizzas[index--];
    }

    for (let i = 0; i < evenDays; i++) {
        ans += pizzas[index - 1];
        index -= 2;
    }

    return ans;
};
