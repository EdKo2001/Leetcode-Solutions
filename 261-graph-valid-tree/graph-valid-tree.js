// /**
//  * @param {number} n
//  * @param {number[][]} edges
//  * @return {boolean}
//  */
// var validTree = function (n, edges) {
//     if (n - 1 !== edges.length) return false;

//     const adjList = {};
//     for (let i = 0; i < n; i++) adjList[i] = [];

//     for (let [start, end] of edges) {
//         adjList[start].push(end);
//         adjList[end].push(start);
//     }

//     const seen = new Set();

//     const dfs = (node, parent) => {
//         seen.add(node);
//         for (const neighbor of adjList[node]) {
//             if (neighbor === parent) continue;
//             if (seen.has(neighbor)) return false;
//             if (!dfs(neighbor, node)) return false;
//         }
//         return true;
//     };

//     if (!dfs(0, -1)) return false;

//     return seen.size === n;
// };

/**
 * @param {number} n
 * @param {number[][]} edges
 * @return {boolean}
 */
var validTree = function (n, edges) {
    if (n - 1 !== edges.length) return false;

    const adjList = {};
    for (let i = 0; i < n; i++) adjList[i] = [];

    for (let [start, end] of edges) {
        adjList[start].push(end);
        adjList[end].push(start);
    }

    const seen = new Set();
    const queue = [[0, -1]];

    while (queue.length) {
        const [node, parent] = queue.shift();
        seen.add(node);

        for (const neighbor of adjList[node]) {
            if (neighbor === parent) continue;
            if (seen.has(neighbor)) return false;
            queue.push([neighbor, node]);
        }
    }

    return seen.size === n;
};