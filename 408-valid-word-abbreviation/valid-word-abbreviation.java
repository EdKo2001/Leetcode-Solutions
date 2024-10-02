class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int wordPointer = 0;
        int abbrPointer = 0;

        int wLen = word.length();
        int aLen = abbr.length();

        // Loop through the abbreviation
        while (abbrPointer < aLen) {
            // If abbr has a digit, calculate the number of letters to skip
            if (Character.isDigit(abbr.charAt(abbrPointer))) {
                // Abbreviations starting with '0' are invalid
                if (abbr.charAt(abbrPointer) == '0') {
                    return false;
                }

                int num = 0;
                while (abbrPointer < aLen && Character.isDigit(abbr.charAt(abbrPointer))) {
                    num = 10 * num + (abbr.charAt(abbrPointer) - '0');
                    abbrPointer++;
                }

                wordPointer += num; // Skip characters in word by the number found in abbreviation

                // If wordPointer exceeds the length of word, it's invalid
                if (wordPointer > wLen) {
                    return false;
                }
            } else {
                // If the current characters of word and abbr don't match, return false
                if (wordPointer >= wLen || word.charAt(wordPointer) != abbr.charAt(abbrPointer)) {
                    return false;
                }

                // If they match, move both pointers forward
                wordPointer++;
                abbrPointer++;
            }
        }

        // Both pointers should reach the end of their respective strings
        return wordPointer == wLen ;
    }
}
