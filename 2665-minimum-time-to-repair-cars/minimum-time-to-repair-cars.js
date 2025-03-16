/**
 * @param {number[]} ranks
 * @param {number} cars
 * @return {number}
 */
var repairCars = function (ranks, cars) {
    let l = 1, h = Math.min(...ranks) * cars * cars;

    while (l < h) {
        let mid = Math.floor((l + h) / 2);
        if (canRepair(ranks, mid, cars)) {
            h = mid;
        } else {
            l = mid + 1;
        }
    }

    return l;
};

const canRepair = (ranks, mid, n) => {
    let carsRepaired = 0;
    for (const rank of ranks) {
        carsRepaired += Math.floor(Math.sqrt(mid / rank));
        if (carsRepaired >= n) return true;
    }
    return false;
};
