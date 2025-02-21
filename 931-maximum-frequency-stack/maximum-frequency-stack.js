var FreqStack = function () {
    this.freq = {}; 
    this.group = {};
    this.maxFreq = 0;
};

/** 
 * @param {number} val
 * @return {void}
 */
FreqStack.prototype.push = function (val) {
    this.freq[val] = (this.freq[val] || 0) + 1;
    let f = this.freq[val];
    
    if (!this.group[f]) this.group[f] = [];
    this.group[f].push(val);
    
    this.maxFreq = Math.max(this.maxFreq, f);
};

/**
 * @return {number}
 */
FreqStack.prototype.pop = function () {
    let val = this.group[this.maxFreq].pop();
    this.freq[val]--;
    
    if (this.group[this.maxFreq].length === 0) {
        delete this.group[this.maxFreq]; 
        this.maxFreq--;
    }
    
    return val;
};
