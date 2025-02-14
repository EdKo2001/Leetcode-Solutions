/**
 * @param {number} n
 * @return {string}
 */
var countAndSay = function (n) {
    let stack = [];

    for (let i = 1; i <= n; i++) {
        if (i == 1) {
            stack.push(1);
            continue;
        }
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
        // let prevNumber = stack.pop();
        // let cnt = 1;
        // while (stack.length > 0) {
        //     if (prevNumber != stack[stack.length - 1]) break;
        //     stack.pop();
        //     cnt++;
        // }
        // stack.push(cnt);
        // stack.push(prevNumber);
    }

    return stack.join('');
};