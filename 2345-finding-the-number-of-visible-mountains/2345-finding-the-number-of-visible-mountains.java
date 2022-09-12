// copied from discuss

class Solution {
    public int visibleMountains(int [][] peaks){
        for(int i = 0; i < peaks.length; i ++){
            int temp = peaks[i][0];
            peaks[i][0] -= peaks[i][1];
            peaks[i][1] += temp;
        }
        Arrays.sort(peaks, (a, b) -> a[0] == b[0] ? a[1] - b[1]: a[0] - b[0]);
        int size = 0;
        int i = 0;
        while(i < peaks.length){
            size++;
            if(i + 1 == peaks.length){
                return size;
            } 
            int currEnd = peaks[i][1];
            if(peaks[i][0] == peaks[i + 1][0]){
                size--;
            }
            while(i + 1 != peaks.length && currEnd >= peaks[i + 1][1]){
                i++;
            }
            i++;
        }
        return size;
    }
}