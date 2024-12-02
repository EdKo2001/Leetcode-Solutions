class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int index = 1;

        for (String word : sentence.split(" ")) {
            if (word.length() >= searchWord.length() && searchWord.equals(word.substring(0, searchWord.length())))
                return index;
            index++;
        }

        return -1;
    }
}