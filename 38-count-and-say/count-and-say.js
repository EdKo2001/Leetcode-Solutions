/**
 * @param {number} n
 * @return {string}
 */
// var countAndSay = function (n) {
//     let stack = [];

//     for (let i = 1; i <= n; i++) {
//         if (i == 1) {
//             stack.push(1);
//             continue;
//         }
//         const temp = [];
//         let prevNumber = stack[0];
//         let cnt = 1;
//         for (let j = 1; j < stack.length; j++) {
//             if (prevNumber != stack[j]) {
//                 temp.push(cnt);
//                 temp.push(prevNumber);
//                 prevNumber = stack[j];
//                 cnt = 1;
//             } else {
//                 cnt++;
//             }
//         }
//         temp.push(cnt);
//         temp.push(prevNumber);
//         stack = temp;
//     }

//     return stack.join('');
// };

var countAndSay = function (n) {
    if (n === 1) return "1";

    let result = "1";

    for (let i = 2; i <= n; i++) {
        let temp = [];
        let count = 1;

        for (let j = 1; j < result.length; j++) {
            if (result[j] === result[j - 1]) {
                count++;
            } else {
                temp.push(count, result[j - 1]);
                count = 1;
            }
        }

        temp.push(count, result[result.length - 1]);
        result = temp.join('');
    }

    return result;
};