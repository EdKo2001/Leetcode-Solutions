class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long currentMass = mass; 

        for (int ast : asteroids) {
            if (ast > currentMass) {
                return false;
            }
            currentMass += ast;
        }

        return true;
    }
}
