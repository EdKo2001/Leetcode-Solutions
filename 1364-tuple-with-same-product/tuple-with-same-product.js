/**
 * @param {number[]} nums
 * @return {number}
 */
var tupleSameProduct = function (nums) {
    let productCount = new Map();
    let count = 0;

    for (let i = 0; i < nums.length; i++) {
        for (let j = i + 1; j < nums.length; j++) {
            let product = nums[i] * nums[j];

            // If this product has been seen before, it means we found matching pairs
            if (productCount.has(product)) {
                count += productCount.get(product) * 8; // Each pair match contributes 8 permutations
            }

            // Store the count of this product
            productCount.set(product, (productCount.get(product) || 0) + 1);
        }
    }

    return count;
};
