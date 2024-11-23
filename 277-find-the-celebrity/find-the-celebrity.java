/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int[] trustScore = new int[n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (knows(i, j)) {
                    trustScore[i]--;
                    trustScore[j]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (trustScore[i] == n - 1)
                return i;
        }

        return -1;
    }
}