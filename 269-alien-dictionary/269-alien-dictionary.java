class Solution {
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> map = new HashMap<>();
        
        int[] visited = new int[26];
        Arrays.fill(visited, -1);
        
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                visited[ch - 'a'] = 0;
                map.put(ch, new ArrayList<>());
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
        for (int i = 0; i < 26; ++i) {
            if (visited[i] == 0) {
                if (dfs(i, map, visited, stack)) return "";
            }
        }
        
        
        // if (sb.length() < degree.size()) {
        //     return "";
        // }
        StringBuilder sb = new StringBuilder();
        while (stack.size() != 0) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
    
    private boolean dfs(int i, Map<Character, List<Character>> map,
                       int[] visited, Stack<Character> stack) {
        char ch = (char) (i + 'a');
        visited[i] = 1;
        for (char next : map.get(ch)) {
            if (visited[next - 'a'] == 1) return true;
            if (visited[next - 'a'] == 0) {
                if (dfs(next - 'a', map, visited, stack)) return true;
            }
        }
        stack.push(ch);
        visited[i] = 2;
        return false;
    }
}


















