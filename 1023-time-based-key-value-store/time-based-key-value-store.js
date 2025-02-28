var TimeMap = function () {
    this.store = new Map(); // Store key -> list of { timestamp, value }
};

/** 
 * @param {string} key 
 * @param {string} value 
 * @param {number} timestamp
 * @return {void}
 */
TimeMap.prototype.set = function (key, value, timestamp) {
    if (!this.store.has(key)) {
        this.store.set(key, []);
    }
    this.store.get(key).push({ timestamp, value });
};

/** 
 * @param {string} key 
 * @param {number} timestamp
 * @return {string}
 */
TimeMap.prototype.get = function (key, timestamp) {
    if (!this.store.has(key)) return "";

    const values = this.store.get(key);
    let left = 0, right = values.length - 1;
    let result = "";

    // Binary search for the largest timestamp <= given timestamp
    while (left <= right) {
        let mid = Math.floor((left + right) / 2);
        if (values[mid].timestamp <= timestamp) {
            result = values[mid].value; // Possible answer
            left = mid + 1; // Look for a later timestamp
        } else {
            right = mid - 1;
        }
    }

    return result;
};
