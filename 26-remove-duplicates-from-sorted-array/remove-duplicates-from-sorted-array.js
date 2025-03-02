var removeDuplicates = function (nums) {
    let i = 1; // Pointer for the next unique element

    for (let j = 1; j < nums.length; j++) {
        if (nums[j] !== nums[i - 1]) { 
            nums[i] = nums[j];
            i++;
        }
    }

    return i; 
};
