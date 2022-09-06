class Solution {
    public boolean checkDistances(String s, int[] distance) {
        int[] letters = new int[26];
        Arrays.fill(letters, -1);
        
        for (int i = 0; i < s.length(); ++i) {
            int index = s.charAt(i) - 'a';
            if (letters[index] == -1) {
                letters[index] = i;
            } else {
                int dis = i - letters[index];
                if (distance[index] + 1 != dis) return false;
            }
        }
        return true;
    }
}