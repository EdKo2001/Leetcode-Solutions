/**
 * @param {number} days
 * @param {number[][]} meetings
 * @return {number}
 */
function countDays(days, meetings) {
    let freeDays = 0, latestEnd = 0;

    meetings.sort((a, b) => a[0] - b[0]);

    for (const meeting of meetings) {
        let [start, end] = meeting;

        // Add current range of days without a meeting
        if (start > latestEnd + 1) {
            freeDays += start - latestEnd - 1;
        }

        // Update latest meeting end
        latestEnd = Math.max(latestEnd, end);
    }

    // Add all days after the last day of meetings
    freeDays += days - latestEnd;

    return freeDays;
}
