var largestRectangleArea = function (heights) {
    let maxArea = 0;
    const stack = [];

    for (let i = 0; i <= heights.length; i++) {
        const height = i < heights.length ? heights[i] : 0;

        while (stack.length > 0 && height < heights[stack[stack.length - 1]]) {
            const topIndex = stack.pop();
            const h = heights[topIndex];
            const width = stack.length === 0 ? i : i - stack[stack.length - 1] - 1;
            maxArea = Math.max(maxArea, h * width);
        }

        stack.push(i);
    }

    return maxArea;
};
