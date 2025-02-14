/**
 * @param {number} n
 * @return {string}
 */
var countAndSay = function (n) {
    let stack = [1];

    for (let i = 2; i <= n; i++) {
        const temp = [];
        let prevNumber = stack[0];
        let cnt = 1;
        for (let j = 1; j < stack.length; j++) {
            if (prevNumber != stack[j]) {
                temp.push(cnt);
                temp.push(prevNumber);
                prevNumber = stack[j];
                cnt = 1;
            } else {
                cnt++;
            }
        }
        temp.push(cnt);
        temp.push(prevNumber);
        stack = temp;
    }

    return stack.join('');
};

// var countAndSay = function (n) {
//     let prev = "1";

//     for (let i = 2; i <= n; i++) {
//         let count = 1;
//         let result = "";

//         for (let j = 1; j < prev.length; j++) {
//             if (prev[j] === prev[j - 1]) {
//                 count++;
//             } else {
//                 result += count + prev[j - 1];
//                 count = 1;
//             }
//         }

//         result += count + prev[prev.length - 1];
//         prev = result;
//     }

//     return prev;
// };
