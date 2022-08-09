/**sort the array
 * and use HashMap to record each Integer, and the number of trees with that Integer as root
 * (1) each integer A[i] will always have one tree with only itself
 * (2) if A[i] has divisor (a) in the map, and if A[i]/a also in the map
 *     then a can be the root of its left subtree, and A[i]/a can be the root of its right subtree;
 *     the number of such tree is map.get(a) * map.get(A[i]/a)
 * (3) sum over the map
 */
class Solution {    
    public int numFactoredBinaryTrees(int[] A) {
        Arrays.sort(A);
        Map<Integer, Long> map = new HashMap();
        long count = 1;
        map.put(A[0], count);
        for (int i = 1; i < A.length; i++) {
            count = 1;
            for (Integer n : map.keySet()) {
                if (A[i] % n == 0 && map.containsKey(A[i] / n)) {
                    count += map.get(n) * map.get(A[i] / n);
                }
            }
            map.put(A[i], count);
        }
        long sum = 0;
        for (Integer n : map.keySet()) {
            sum = (sum + map.get(n)) % ((int) Math.pow(10, 9) + 7) ;
        }
        return (int) sum;
    }        
}