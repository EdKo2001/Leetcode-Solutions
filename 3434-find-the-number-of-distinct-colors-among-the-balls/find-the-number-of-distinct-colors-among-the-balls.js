var queryResults = function (limit, queries) {
    const res = [];
    const ballsMap = new Map();
    const colorCount = new Map();
    let uniqueColors = 0;

    for (const [ball, color] of queries) {
        if (ballsMap.has(ball)) {
            const prevColor = ballsMap.get(ball);
            colorCount.set(prevColor, colorCount.get(prevColor) - 1);
            if (colorCount.get(prevColor) === 0) {
                uniqueColors--;
                colorCount.delete(prevColor);
            }
        }

        ballsMap.set(ball, color);
        if (!colorCount.has(color)) {
            uniqueColors++;
            colorCount.set(color, 0);
        }
        colorCount.set(color, colorCount.get(color) + 1);

        res.push(uniqueColors);
    }

    return res;
};
