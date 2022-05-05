class Solution {
    public int countPoints(String rings) {
        Set<Character>[] arr = new HashSet[10];
        for (int i = 0; i < 10; ++i) {
            arr[i] = new HashSet<>();
        }
        int index = 0;
        while (index + 1 < rings.length()) {
            char ch = rings.charAt(index);
            int pos = rings.charAt(index + 1) - '0';
            arr[pos].add(ch);
            index += 2;
        }
        int count = 0;
        for (int i = 0; i < 10; ++i) {
            if (arr[i].size() == 3) {
                count++;
            }
        }
        return count;
    }
}