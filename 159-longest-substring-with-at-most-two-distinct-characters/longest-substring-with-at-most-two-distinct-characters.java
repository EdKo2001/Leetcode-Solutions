class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int longest = 0;
        HashMap<Character, Integer> dic = new HashMap<>();

        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            char curr = s.charAt(end);
            dic.put(curr, dic.getOrDefault(curr, 0) + 1);
            while (dic.size() > 2) {
                char targetToRemove = s.charAt(start);
                dic.put(targetToRemove, dic.getOrDefault(targetToRemove, 0) - 1);
                if (dic.get(targetToRemove) == 0)
                    dic.remove(targetToRemove);
                start++;
            }
            longest = Math.max(longest, end - start + 1);
        }

        return longest;
    }
}