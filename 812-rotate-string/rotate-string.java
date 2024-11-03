class Solution {

    public boolean rotateString(String s, String goal) {
        // Check if the lengths are different
        if (s.length() != goal.length())
            return false;

        // Create a new string by concatenating 's' with itself
        String doubledString = s + s;

        // Use contains to search for 'goal' in 'doubledString'
        // If contains return true, 'goal' is a substring
        return doubledString.contains(goal);
    }
}