class Solution {
    public String alienOrder(String[] words) {
        int[] visited = new int[26];
        Arrays.fill(visited, -1);
        
        Map<Character, List<Character>> map = new HashMap<>();
        for (String word : words) {
            char[] arr = word.toCharArray();
            for (char ch : arr) {
                map.put(ch, new ArrayList<>());
                visited[ch - 'a'] = 0;
            }
        }
        for (int i = 1; i < words.length; ++i) {
            String first = words[i - 1];
            String second = words[i];
            if (first.length() > second.length() && first.startsWith(second)) {
                return "";
            }
            for (int j = 0; j < first.length(); ++j) {
                char ch1 = first.charAt(j);
                char ch2 = second.charAt(j);
                if (ch1 != ch2) {
                    List<Character> list = map.getOrDefault(ch1, new ArrayList<>());
                    list.add(ch2);
                    map.put(ch1, list);
                    break;
                }
            }
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < visited.length; ++i) {
            if (visited[i] == 0) {
                if (dfs(i, visited, map, stack)) {
                    return "";
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        if (sb.length() < map.keySet().size()) {
            return "";
        }
        return sb.toString();
    }
    private boolean dfs(int cur, int[] visited, Map<Character, List<Character>> map, Stack<Character> stack) {
        visited[cur] = 1;
        char ch = (char)(cur + 'a');
        for (char next : map.get(ch)) {
            if (visited[next - 'a'] == 1) return true;
            if (visited[next - 'a'] == 0) {
                if (dfs(next - 'a', visited, map, stack)) {
                    return true;
                }
            }
        }
        stack.push((char)(cur + 'a'));
        visited[cur] = 2;
        return false;
    }
}