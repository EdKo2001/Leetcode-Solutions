class Solution {
    public int findMinDifference(List<String> timePoints) {
        int ans = Integer.MAX_VALUE;

        List<Integer> minutes = new ArrayList<>();
        //// Convert each time in "HH:MM" format to total minutes and add to the list
        for (String time : timePoints) {
            minutes.add(time(time));
        }

        // sort list of minutes
        Collections.sort(minutes);
        for (int i = 1; i < minutes.size(); i++) {
            // get the minimum difference between 2
            // it covers duplicate value
            ans = Math.min(ans, minutes.get(i) - minutes.get(i - 1));
        }

        // check the minimum difference of 1st & last value & return minimum time
        return Math.min(ans, 1440 + minutes.get(0) - minutes.get(minutes.size() - 1));

    }

    public int time(String time) {
        // the function converts each string time to integer minutes
        // max total minutes in a day is 1440
        int hour = Integer.parseInt(time.substring(0, 2));
        int min = Integer.parseInt(time.substring(3, 5));

        return hour * 60 + min;
    }
}