/**
 * @param {number[][]} edges
 * @return {number[]}
 */
var findRedundantConnection = function (edges) {
    const n = edges.length;
    const parent = Array(n + 1).fill(0).map((_, i) => i); // Parent array
    const rank = Array(n + 1).fill(1); // Rank for optimization

    // Find function with path compression
    const find = (node) => {
        if (parent[node] !== node) {
            parent[node] = find(parent[node]); // Path compression
        }
        return parent[node];
    };

    // Union function with rank optimization
    const union = (a, b) => {
        let rootA = find(a);
        let rootB = find(b);

        if (rootA === rootB) return false; // Cycle detected

        // Union by rank
        if (rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA;
        } else if (rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB;
        } else {
            parent[rootB] = rootA;
            rank[rootA] += 1;
        }
        return true;
    };

    // Process all edges
    for (const [a, b] of edges) {
        if (!union(a, b)) return [a, b]; // The first edge that creates a cycle
    }

    return [];
};