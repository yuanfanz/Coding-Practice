class Solution {
    public String tictactoe(int[][] moves) {
        int[] row = new int[3];
        int[] col = new int[3];
        int dia45 = 0;
        int dia135 = 0;
        
        int player = 1;
        int index = 0;
        for (int[] cur : moves) {
            int i = cur[0];
            int j = cur[1];
            
            row[i] += player;
            col[j] += player;
            if (i == j) {
                dia135 += player;
            }
            if (i + j == 2) {
                dia45 += player;
            }
            if (Math.abs(row[i]) == 3 ||
               Math.abs(col[j]) == 3 ||
               Math.abs(dia45) == 3 ||
               Math.abs(dia135) == 3) {
                return player == 1 ? "A" : "B";
            }
            
            player = -player;
            index++;
        }
        return index == 9 ? "Draw" : "Pending";
    }
}