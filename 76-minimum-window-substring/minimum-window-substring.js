/**
 * @param {string} s
 * @param {string} t
 * @return {string}
 */
var minWindow = function (s, t) {
    if (s.length < t.length) return "";

    const tFreq = new Map();
    for (const char of t) {
        tFreq.set(char, (tFreq.get(char) || 0) + 1);
    }

    let requiredChars = tFreq.size; 
    let left = 0, right = 0, formed = 0;
    let windowCounts = new Map();
    let minLen = Infinity, minStart = 0;

    while (right < s.length) {
        const char = s[right];
        windowCounts.set(char, (windowCounts.get(char) || 0) + 1);

        if (tFreq.has(char) && windowCounts.get(char) === tFreq.get(char)) {
            formed++;
        }

        while (formed === requiredChars) {
            if (right - left + 1 < minLen) {
                minLen = right - left + 1;
                minStart = left;
            }

            const leftChar = s[left];
            windowCounts.set(leftChar, windowCounts.get(leftChar) - 1);

            if (tFreq.has(leftChar) && windowCounts.get(leftChar) < tFreq.get(leftChar)) {
                formed--;
            }
            left++;
        }

        right++;
    }

    return minLen === Infinity ? "" : s.substring(minStart, minStart + minLen);
};
