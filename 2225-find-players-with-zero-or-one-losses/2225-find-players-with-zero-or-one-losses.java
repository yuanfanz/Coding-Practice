class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> winmap = new HashMap<>();
        Map<Integer, Integer> losemap = new HashMap<>();
        
        Set<Integer> players = new HashSet<>();
        for (int[] cur : matches) {
            int winner = cur[0];
            int loser = cur[1];
            players.add(winner);
            players.add(loser);
            winmap.put(winner, winmap.getOrDefault(winner, 0) + 1);
            losemap.put(loser, losemap.getOrDefault(loser, 0) + 1);
        }
        List<Integer> loselist = new ArrayList<>();
        for (int i : losemap.keySet()) {
            if (losemap.get(i) == 1) {
                
            loselist.add(i);
            }
        }
        List<Integer> winlist = new ArrayList<>();
        Set<Integer> loseset = losemap.keySet();
        for (int i : players) {
            if (loseset.contains(i)) continue;
            winlist.add(i);
        }
        List<List<Integer>> result = new ArrayList<>();
        Collections.sort(winlist);
        Collections.sort(loselist);
        result.add(winlist);
        result.add(loselist);
        return result;
    }
}