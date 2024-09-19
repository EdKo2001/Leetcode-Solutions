class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        HashMap<Character, Integer> dic = new HashMap<>();

        for (char ch : s.toCharArray()) {
            dic.put(ch, dic.getOrDefault(ch, 0) + 1);
        }

        for (char ch : t.toCharArray()) {
            if (!dic.containsKey(ch) || dic.get(ch) == 0)
                return false;
            dic.put(ch, dic.get(ch) - 1);
        }

        return true;
    }
}