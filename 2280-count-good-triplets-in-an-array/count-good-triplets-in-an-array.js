/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
class FenwickTree {
    constructor(size) {
        this.tree = new Array(size + 1).fill(0);
    }

    update(index, delta) {
        index++;
        while (index < this.tree.length) {
            this.tree[index] += delta;
            index += index & -index;
        }
    }

    query(index) {
        index++;
        let res = 0;
        while (index > 0) {
            res += this.tree[index];
            index -= index & -index;
        }
        return res;
    }
}

var goodTriplets = function (nums1, nums2) {
    const n = nums1.length;
    const pos2 = new Array(n),
        reversedIndexMapping = new Array(n);
    for (let i = 0; i < n; i++) {
        pos2[nums2[i]] = i;
    }
    for (let i = 0; i < n; i++) {
        reversedIndexMapping[pos2[nums1[i]]] = i;
    }
    const tree = new FenwickTree(n);
    let res = 0;
    for (let value = 0; value < n; value++) {
        const pos = reversedIndexMapping[value];
        const left = tree.query(pos);
        tree.update(pos, 1);
        const right = n - 1 - pos - (value - left);
        res += left * right;
    }
    return res;
};