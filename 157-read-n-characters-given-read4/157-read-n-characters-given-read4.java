/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        boolean eof = false;
        int total = 0;
        while (!eof) {
            char[] tmp = new char[4];
            int count = read4(tmp);
            eof = count < 4;
            
            count = Math.min(count, n - total);
            
            for (int i = 0; i < count; ++i) {
                buf[total++] = tmp[i];
            }
        }
        return total;
    }
}