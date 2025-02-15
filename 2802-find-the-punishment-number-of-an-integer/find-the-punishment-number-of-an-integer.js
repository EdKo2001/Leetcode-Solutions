/**
 * @param {number} n
 * @return {number}
 */
var punishmentNumber = function (n) {
    let punishmentSum = 0;

    for (let i = 1; i <= n; i++) {
        let squareStr = (i * i).toString();
        if (isValidPartition(squareStr, 0, i, 0)) {
            punishmentSum += i * i;
        }
    }

    return punishmentSum;
};

const isValidPartition = (square, index, target, currentSum) => {
    if (index === square.length) {
        return currentSum === target;
    }

    let num = 0;
    for (let i = index; i < square.length; i++) {
        num = num * 10 + parseInt(square[i], 10);
        if (isValidPartition(square, i + 1, target, currentSum + num)) {
            return true;
        }
    }

    return false;
};
