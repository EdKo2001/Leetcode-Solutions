/**
 * @param {string} s
 * @return {number[]}
 */
var partitionLabels = function(s) {
    const lastIndex = {};  // Store the last occurrence of each character
    const partitions = [];
    
    // Step 1: Record the last occurrence of each character
    for (let i = 0; i < s.length; i++) {
        lastIndex[s[i]] = i;
    }

    let start = 0, end = 0;
    
    // Step 2: Iterate through the string and determine partitions
    for (let i = 0; i < s.length; i++) {
        end = Math.max(end, lastIndex[s[i]]);  // Expand the current partition
        
        if (i === end) {  // When reaching the end of the partition
            partitions.push(end - start + 1);  // Add partition size
            start = i + 1;  // Move to the next partition
        }
    }

    return partitions;
};
