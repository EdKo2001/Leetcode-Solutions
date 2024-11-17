class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people); // Sort people by weight.
        int left = 0; // Pointer for the lightest person.
        int right = people.length - 1; // Pointer for the heaviest person.
        int boats = 0;

        while (left <= right) {
            // If the lightest and heaviest person can share a boat, move both pointers.
            if (people[left] + people[right] <= limit) {
                left++;
            }
            // Always move the right pointer, as the heaviest person will use a boat.
            right--;
            boats++;
        }

        return boats;
    }
}
