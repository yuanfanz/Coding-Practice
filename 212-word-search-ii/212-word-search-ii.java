class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        buildTrie(root, words);
        
        int m = board.length;
        int n = board[0].length;
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        
        Set<String> result = new HashSet<>();
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                dfs(result, board, root, dirs, i, j);
            }
        }
        return new ArrayList<>(result);
    }
    private void dfs(Set<String> result, char[][] board,
                    TrieNode root, int[][] dirs, int i, int j) {
        if (root.isWord) {
            result.add(root.word);
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }
        char ch = board[i][j];
        if (!root.map.containsKey(ch)) return;
        board[i][j] = '#';
        for (int[] dir : dirs) {
            int row = i + dir[0];
            int col = j + dir[1];
            dfs(result, board, root.map.get(ch), dirs, row, col);
        }
        board[i][j] = ch;
    }
    private void buildTrie(TrieNode root, String[] words) {
        for (String word : words) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                if (!cur.map.containsKey(ch)) {
                    cur.map.put(ch, new TrieNode(ch));
                }
                cur = cur.map.get(ch);
                if (i == word.length() - 1) {
                    cur.isWord = true;
                    cur.word = word;
                }
            }
        }
    }
    class TrieNode{
        char ch;
        Map<Character, TrieNode> map;
        boolean isWord;
        String word;
        public TrieNode() {
            map = new HashMap<>();
            isWord = false;
        }
        public TrieNode(char ch) {
            this.ch = ch;
            map = new HashMap<>();
            isWord = false;
        }
    }
}