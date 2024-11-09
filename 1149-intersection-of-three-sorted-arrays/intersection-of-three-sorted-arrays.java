class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> res = new ArrayList<>();

        int pointer1 = 0;
        int pointer2 = 0;
        int pointer3 = 0;

        int n1 = arr1.length;
        int n2 = arr2.length;
        int n3 = arr3.length;

        while (pointer1 < n1 && pointer2 < n2 && pointer3 < n3) {
            int item1 = arr1[pointer1];
            int item2 = arr2[pointer2];
            int item3 = arr3[pointer3];

            if (item1 == item2 && item2 == item3) {
                res.add(item1);
                pointer1++;
                pointer2++;
                pointer3++;
            } else if (item1 <= item2 && item1 <= item3) {
                pointer1++;
            } else if (item2 <= item1 && item2 <= item3) {
                pointer2++;
            } else {
                pointer3++;
            }
        }

        return res;
    }
}