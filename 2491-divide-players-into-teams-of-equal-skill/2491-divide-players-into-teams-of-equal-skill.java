class Solution {
    public long dividePlayers(int[] skill) {
        Map<Integer, Integer> map = new HashMap<>();
        long sum = 0;
        for (int i : skill) {
            sum += i;
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        long n = (long) skill.length;
        long teams =  n / 2;
        
        int each = (int) (sum / teams);
        long total = 0;
        
        for (int i : skill) {
            if (!map.containsKey(i)) continue;
            
            int valo = map.get(i);
            valo--;
            if (valo > 0) {
                map.put(i, valo);
            } else {
                map.remove(i);
            }
            
            int next = each - i;
            if (!map.containsKey(next)) return -1;
            
            int val = map.get(next);
            val--;
            if (val > 0) {
                map.put(next, val);
            } else {
                map.remove(next);
            }
            total += next * i;
        }
        return total;
    }
}