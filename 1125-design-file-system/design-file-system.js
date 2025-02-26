var FileSystem = function () {
    this.fileSystem = {};
};

/** 
 * @param {string} path 
 * @param {number} value    
 * @return {boolean}
 */
FileSystem.prototype.createPath = function (path, value) {
    if (path === "/") return false; // Root path cannot be created.

    const parts = path.split('/');
    const n = parts.length;

    // Check for invalid path components (like empty parts except leading)
    for (let i = 1; i < n; i++) {
        if (parts[i] === '') {
            return false;
        }
    }

    // Check if the path is at least one level deep (e.g., "/a")
    if (n < 2) {
        return false;
    }

    // Check parent path exists if needed (for depth >= 2)
    if (n > 2) {
        const parentPath = parts.slice(0, n - 1).join('/');
        if (!this.fileSystem.hasOwnProperty(parentPath)) {
            return false;
        }
    }

    // Check if current path already exists
    if (this.fileSystem.hasOwnProperty(path)) {
        return false;
    }

    // Create the path
    this.fileSystem[path] = value;
    return true;
};

/** 
 * @param {string} path
 * @return {number}
 */
FileSystem.prototype.get = function (path) {
    return this.fileSystem[path] !== undefined ? this.fileSystem[path] : -1;
};

/** 
 * Your FileSystem object will be instantiated and called as such:
 * var obj = new FileSystem()
 * var param_1 = obj.createPath(path,value)
 * var param_2 = obj.get(path)
 */