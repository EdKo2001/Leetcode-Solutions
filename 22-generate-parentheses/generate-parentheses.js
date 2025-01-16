/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function (n) {
    const res = [];

    const backtracking = (str, opening, closing) => {
        // Base case: When the string reaches the required length
        if (str.length === 2 * n) {
            res.push(str);
            return;
        }

        // Add an opening parenthesis if the count is less than n
        if (opening < n) {
            backtracking(str + "(", opening + 1, closing);
        }

        // Add a closing parenthesis if the count is less than the opening count
        if (closing < opening) {
            backtracking(str + ")", opening, closing + 1);
        }
    };

    backtracking("", 0, 0);

    return res;
};
