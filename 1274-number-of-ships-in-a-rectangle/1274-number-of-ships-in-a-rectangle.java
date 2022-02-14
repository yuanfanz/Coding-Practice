/**
 * // This is Sea's API interface.
 * // You should not implement it, or speculate about its implementation
 * class Sea {
 *     public boolean hasShips(int[] topRight, int[] bottomLeft);
 * }
 */

class Solution {
    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        if (!sea.hasShips(topRight, bottomLeft)) return 0;
        if (topRight[0] == bottomLeft[0] && topRight[1] == bottomLeft[1]) return 1;
        
        int mid1 = (topRight[0] + bottomLeft[0]) / 2;
        int mid2 = (topRight[1] + bottomLeft[1]) / 2;
        return countShips(sea, new int[]{mid1, mid2}, bottomLeft) +
            countShips(sea, new int[]{topRight[0], mid2}, new int[]{mid1 + 1, bottomLeft[1]}) + 
            countShips(sea, new int[]{mid1, topRight[1]}, new int[]{bottomLeft[0], mid2 + 1}) +
            countShips(sea, topRight, new int[]{mid1 + 1, mid2 + 1});
    }
}