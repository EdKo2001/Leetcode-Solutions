/**
 * @param {string} word
 * @param {number} k
 * @return {number}
 */
var countOfSubstrings = function(word, k) {
    const vowelsSet = new Set(['a','e','i','o','u']);
    let count = 0;
    
    // Try every starting index
    for (let i = 0; i < word.length; i++) {
        let cons = 0;
        let vowelsSeen = new Set();
        
        // Expand the substring from i to j
        for (let j = i; j < word.length; j++) {
            let ch = word[j];
            if (vowelsSet.has(ch)) {
                vowelsSeen.add(ch);
            } else {
                cons++;
            }
            // If we have too many consonants, no point in expanding further
            if (cons > k) break;
            
            // Count this substring only if it has exactly k consonants and all five vowels.
            if (cons === k && vowelsSeen.size === 5) count++;
        }
    }
    
    return count;
};
