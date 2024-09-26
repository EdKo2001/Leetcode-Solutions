// class Solution {
//     public boolean canConstruct(String ransomNote, String magazine) {
//         HashMap<Character, Integer> dictionary = new HashMap<>();

//         for (int i = 0; i < magazine.length(); i++) {
//             char c = magazine.charAt(i);

//             int currentCount = dictionary.getOrDefault(c, 0);

//             dictionary.put(c, ++currentCount);
//         }

//         for (int i = 0; i < ransomNote.length(); i++) {
//             char c = ransomNote.charAt(i);

//             int currentCount = dictionary.getOrDefault(c, 0);

//             if (currentCount == 0)
//                 return false;

//             dictionary.put(c, --currentCount);
//         }

//         return true;
//     }
// }

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
		if (ransomNote.length() > magazine.length()) return false;
        int[] alphabets_counter = new int[26];
        
        for (char c : magazine.toCharArray())
            alphabets_counter[c-'a']++;

        for (char c : ransomNote.toCharArray()){
            if (alphabets_counter[c-'a'] == 0) return false;
            alphabets_counter[c-'a']--;
        }
        return true;
    }
}