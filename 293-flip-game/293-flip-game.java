class Solution {
    public List<String> generatePossibleNextMoves(String currentState) {
        Set<String> result = new HashSet<>();
        
        int i = 0;
        int n = currentState.length();
        while (i < n && i + 1 < n) {
            String s = currentState;
            if (s.charAt(i) == s.charAt(i + 1)) {
                if (s.charAt(i) == '+') {
                    result.add(s.substring(0, i) + "--" + s.substring(i + 2));
                }
            }
            i++;
        }
        return new ArrayList<>(result);
    }
}