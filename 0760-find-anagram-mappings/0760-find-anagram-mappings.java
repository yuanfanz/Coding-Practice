



class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
    int[] result = new int [A.length];
    Map<Integer, List<Integer>> map = new HashMap<>();
    for(int i = 0; i < B.length; i++) {
        map.computeIfAbsent(B[i], k -> new ArrayList<>()).add(i);
    }
    for(int i = 0; i < A.length; i++) {
        result[i] = map.get(A[i]).remove(map.get(A[i]).size()-1);
    }
    return result;
}
}