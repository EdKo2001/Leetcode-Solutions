/**
 * @param {string} s
 * @return {string}
 */
// var shortestPalindrome = function (s) {
//     if (s.length === 0) return s;

//     // 1) Find the largest prefix that is a palindrome
//     for (let i = s.length; i >= 0; i--) {
//         if (isPalindrome(s, 0, i - 1)) {
//             // s[0..i-1] is palindromic
//             let suffix = s.substring(i); // The remaining part
//             let revSuffix = suffix.split("").reverse().join("");
//             // 2) Prepend reversed suffix
//             return revSuffix + s;
//         }
//     }

//     return ""; // Fallback, though we never actually reach here
// };

// /**
//  * Helper function to check if s[start..end] is a palindrome
//  */
// function isPalindrome(s, start, end) {
//     while (start < end) {
//         if (s[start] !== s[end]) return false;
//         start++;
//         end--;
//     }
//     return true;
// }

// Optimized Approach using KMP (Knuth-Morris-Pratt)
var shortestPalindrome = function (s) {
    let n = s.length;
    if (n === 0) return s;

    let rev = s.split("").reverse().join("");  // Reverse the string
    let newStr = s + "#" + rev;  // Combine original + separator + reversed

    let lps = new Array(newStr.length).fill(0); // Longest Prefix Suffix (LPS) array
    for (let i = 1, j = 0; i < newStr.length;) {
        if (newStr[i] === newStr[j]) {
            lps[i++] = ++j;
        } else if (j > 0) {
            j = lps[j - 1];  // Move j back using LPS
        } else {
            i++;
        }
    }

    let longestPrefixLength = lps[newStr.length - 1]; // Longest palindromic prefix length
    let nonPalindromeSuffix = s.substring(longestPrefixLength); // The part that needs to be mirrored
    return nonPalindromeSuffix.split("").reverse().join("") + s; // Append reversed suffix
};