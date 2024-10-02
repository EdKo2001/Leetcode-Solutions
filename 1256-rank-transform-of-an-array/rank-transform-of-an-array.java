class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] arrClone = arr.clone();
        Arrays.sort(arrClone);

        HashMap<Integer, Integer> dic = new HashMap<>();

        int rank = 1;
        for (int i = 0; i < arrClone.length; i++) {
            if (!dic.containsKey(arrClone[i])) {
                dic.put(arrClone[i], rank);
                rank++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = dic.get(arr[i]);
        }

        return arr;
    }
}
