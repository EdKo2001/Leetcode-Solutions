class Solution {
    public boolean isAnagram(String s, String t) {
        // if(s.length() != t.length()) return false;

        // HashMap<Character, Integer> dic = new HashMap<>();

        // for (char ch : s.toCharArray()) {
        // dic.put(ch, dic.getOrDefault(ch, 0) + 1);
        // }

        // for (char ch : t.toCharArray()) {
        // if (!dic.containsKey(ch) || dic.get(ch) == 0)
        // return false;
        // dic.put(ch, dic.get(ch) - 1);
        // }

        // return true;

        if (s.length() != t.length())
            return false;

        int[] count = new int[26]; // Array to store character frequencies

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++; // Increment the frequency for char in s
            count[t.charAt(i) - 'a']--; // Decrement the frequency for char in t
        }

        // If all elements in count are 0, the strings are anagrams
        for (int c : count) {
            if (c != 0)
                return false;
        }

        return true;
    }
}