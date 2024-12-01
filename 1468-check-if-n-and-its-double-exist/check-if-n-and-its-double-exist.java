class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Double> seen = new HashSet<>();

        for (int num : arr) {
            if (seen.contains((double) num * 2) || seen.contains((double) num / 2)) {
                return true;
            }
            seen.add((double) num);
        }

        return false;
    }
}