class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, 1);
        }
        
        List<Integer> intersectionList = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num)) {
                intersectionList.add(num);
                map.remove(num);
            }
        }

        int[] result = new int[intersectionList.size()];
        for (int i = 0; i < intersectionList.size(); i++) {
            result[i] = intersectionList.get(i);
        }

        return result;
    }
}