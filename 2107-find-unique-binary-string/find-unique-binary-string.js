/**
 * @param {string[]} nums
 * @return {string}
 */
// var findDifferentBinaryString = function (nums) {
//     const n = nums.length;
//     const numbersSet = new Set(nums);

//     const generateBinaryString = (str) => {
//         if (str.length === n) {
//             if (!numbersSet.has(str)) return str;
//             return null;
//         }

//         let result = generateBinaryString(str + '0');
//         if (result) return result;

//         return generateBinaryString(str + '1');
//     };

//     return generateBinaryString("") || "";
// };

// One line solution
var findDifferentBinaryString = (nums) => nums.map((num, i) => (num[i] === '0' ? '1' : '0')).join('');

