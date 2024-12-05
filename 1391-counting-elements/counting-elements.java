class Solution {
    public int countElements(int[] arr) {
        int cnt = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i] + 1))
                cnt++;
        }

        return cnt;
    }
}