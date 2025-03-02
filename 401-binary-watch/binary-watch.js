/**
 * @param {number} turnedOn
 * @return {string[]}
 */
var readBinaryWatch = function (turnedOn) {
    const hours = [8, 4, 2, 1]; 
    const minutes = [32, 16, 8, 4, 2, 1];
    const ans = [];

    function generateNumbers(arr, count, index, sum, limit, results) {
        if (count === 0) {
            if (sum < limit) results.push(sum);
            return;
        }
        for (let i = index; i < arr.length; i++) {
            generateNumbers(arr, count - 1, i + 1, sum + arr[i], limit, results);
        }
    }

    for (let h = 0; h <= turnedOn; h++) {
        let hourResults = [], minuteResults = [];
        generateNumbers(hours, h, 0, 0, 12, hourResults);
        generateNumbers(minutes, turnedOn - h, 0, 0, 60, minuteResults);

        for (let hr of hourResults) {
            for (let min of minuteResults) {
                ans.push(`${hr}:${min.toString().padStart(2, '0')}`);
            }
        }
    }

    return ans;
};
