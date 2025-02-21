/**
 * @param {number[][]} boxTypes
 * @param {number} truckSize
 * @return {number}
 */
var maximumUnits = function (boxTypes, truckSize) {
    boxTypes.sort((a, b) => b[1] - a[1]);

    let maxUnits = 0;

    for (let i = 0; i < boxTypes.length && truckSize > 0; i++) {
        const [boxCount, unitsPerBox] = boxTypes[i];
        const takeBoxes = Math.min(truckSize, boxCount);
        truckSize -= takeBoxes;
        maxUnits += takeBoxes * unitsPerBox;
    }

    return maxUnits;
};
