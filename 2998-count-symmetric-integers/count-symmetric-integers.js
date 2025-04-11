/**
 * @param {number} low
 * @param {number} high
 * @return {number}
 */
var countSymmetricIntegers = function (low, high) {
    let count = 0;

    for (let x = low; x <= high; x++) {
        const s = x.toString();

        if (s.length % 2 !== 0) continue;

        const n = s.length / 2;
        const firstHalf = s.slice(0, n);
        const secondHalf = s.slice(n);

        let sumFirst = 0;
        let sumSecond = 0;
        for (let i = 0; i < n; i++) {
            sumFirst += parseInt(firstHalf[i], 10);
            sumSecond += parseInt(secondHalf[i], 10);
        }

        if (sumFirst === sumSecond) count++;
    }

    return count;
};