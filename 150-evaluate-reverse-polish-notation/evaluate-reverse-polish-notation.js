/**
 * @param {string[]} tokens
 * @return {number}
 */
var evalRPN = function (tokens) {
    const stack = [];
    const operationsSet = new Set(["+", "-", "*", "/"]);

    for (let token of tokens) {
        if (!operationsSet.has(token)) {
            stack.push(Number(token));
        } else {
            const num1 = stack.pop();
            const num2 = stack.pop();
            switch (token) {
                case "+":
                    stack.push(num2 + num1);
                    break;
                case "-":
                    stack.push(num2 - num1);
                    break;
                case "*":
                    stack.push(num2 * num1);
                    break;
                case "/":
                    stack.push(Math.trunc(num2 / num1));
                    break;
            }
        }
    }

    return stack[0];
};
