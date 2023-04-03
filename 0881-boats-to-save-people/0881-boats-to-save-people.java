class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        
        int n = people.length;
        int i = 0;
        int j = n - 1;
        int count = 0;
        while (i <= j) {
            int weight = people[i] + people[j];
            if (weight > limit) {
                j--;
            } else {
                i++;
                j--;
            }
            count++;
        }
        return count;
    }
}