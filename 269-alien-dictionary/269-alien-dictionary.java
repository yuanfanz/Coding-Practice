class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        
        int[] visited = new int[26];
        Arrays.fill(visited, -1);
        for (String s : words) {
            for (int i = 0; i < s.length(); ++i) {
                visited[s.charAt(i) - 'a'] = 0;
                map.put(s.charAt(i), new HashSet<>());
            }
        }
        for (int i = 0; i < words.length - 1; ++i) {
            String first = words[i];
            String second = words[i + 1];
            if (first.length() > second.length() && first.startsWith(second)) {
                return "";
            }
            for (int j = 0; j < first.length(); ++j) {
                char ch1 = first.charAt(j);
                char ch2 = second.charAt(j);
                if (ch1 != ch2) {
                    map.get(ch1).add(ch2);
                    break;
                }
            }
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < visited.length; ++i) {
            if (visited[i] == 0) {
                if (dfs(visited, i, map, stack)) return "";
            }
        }
        for (int i = 0; i < visited.length; ++i) {
            if (visited[i] == 0) {
                return "";
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
    private boolean dfs(int[] visited, int cur, Map<Character, Set<Character>> map, Stack<Character> stack) {
        visited[cur] = 1;
        char ch = (char) (cur + 'a');
        for (char ch2 : map.get(ch)) {
            int next = ch2 - 'a';
            if (visited[next] == 1) return true;
            if (visited[next] == 0) {
                if (dfs(visited, next, map, stack)) return true;
            }
        }
        visited[cur] = 2;
        stack.push(ch);
        return false;
    }
}
















