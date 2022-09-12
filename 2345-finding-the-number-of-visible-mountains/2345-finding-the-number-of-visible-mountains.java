// copied from discuss

class Solution {
    public int visibleMountains(int[][] peaks){
        // convert peaks coordinates into start and end of mountains
        for(int i = 0; i < peaks.length; ++i){
            int middle = peaks[i][0];
            int height = peaks[i][1];
            peaks[i][0] -= height;
            peaks[i][1] = middle + height;
        }
        // sort array by start, then by end
        Arrays.sort(peaks, (a, b) -> a[0] == b[0] ? a[1] - b[1]: a[0] - b[0]);
        int count = 0;
        int i = 0;
        while (i < peaks.length) {
            count++;
            if(i + 1 == peaks.length){
                return count;
            } 
            int currEnd = peaks[i][1];
            if(peaks[i][0] == peaks[i + 1][0]){
                count--;
            }
            while(i + 1 != peaks.length && currEnd >= peaks[i + 1][1]){
                i++;
            }
            i++;
        }
        return count;
    }
}