/**
 * @param {number[]} nums
 * @return {number}
 */
var minimumIndex = function(nums) {
    const n = nums.length;
    const freqMap = new Map();
    
    // Step 1: Determine the dominant element
    for (const num of nums) {
        freqMap.set(num, (freqMap.get(num) || 0) + 1);
    }
    
    let dominantElement = -1;
    for (const [num, count] of freqMap.entries()) {
        if (count * 2 > n) {
            dominantElement = num;
            break;
        }
    }
    
    if (dominantElement === -1) {
        return -1; // No dominant element found (shouldn't happen as per problem statement)
    }
    
    // Step 2: Initialize counters for the dominant element in both subarrays
    let leftCount = 0;
    let rightCount = freqMap.get(dominantElement);
    
    // Step 3: Iterate to find the minimum valid split index
    for (let i = 0; i < n - 1; i++) {
        if (nums[i] === dominantElement) {
            leftCount++;
            rightCount--;
        }
        
        const leftSize = i + 1;
        const rightSize = n - leftSize;
        
        if (leftCount * 2 > leftSize && rightCount * 2 > rightSize) {
            return i;
        }
    }
    
    return -1; // No valid split found
};
