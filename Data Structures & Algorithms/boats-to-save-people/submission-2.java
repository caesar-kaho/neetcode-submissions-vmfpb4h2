class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int count = 0;
        Arrays.sort(people);
        int l = 0, r = people.length - 1;

        while(l <= r) {
            int remain = limit - people[r--];
            count++;
            if (l <= r && remain >= people[l]) {
                l++;
            }
        }
        return count;
    }
}