class Solution {
    public int findTheLongestSubstring(String s) {
        int n = s.length();
        // State variable to represent the bitmask for vowels
        int state = 0;
        // HashMap to store the first occurrence of each state
        HashMap<Integer, Integer> stateMap = new HashMap<>();
        // Initialize with state 0 at index -1 to handle cases where the entire
        // substring is valid
        stateMap.put(0, -1);

        int maxLength = 0;

        // Iterate through the string and update the state based on vowel counts
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            // Update the state based on the current character
            switch (ch) {
                case 'a':
                    state ^= (1 << 0);
                    break; // flip bit 0
                case 'e':
                    state ^= (1 << 1);
                    break; // flip bit 1
                case 'i':
                    state ^= (1 << 2);
                    break; // flip bit 2
                case 'o':
                    state ^= (1 << 3);
                    break; // flip bit 3
                case 'u':
                    state ^= (1 << 4);
                    break; // flip bit 4
            }

            // If this state has been seen before, calculate the length of the substring
            if (stateMap.containsKey(state)) {
                maxLength = Math.max(maxLength, i - stateMap.get(state));
            } else {
                // Otherwise, store the first occurrence of this state
                stateMap.put(state, i);
            }
        }

        return maxLength;
    }
}