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
    private char[] prevBuf = new char[4];
    private int prevIndex = 0;
    private int prevSize = 0;
    public int read(char[] buf, int n) {
        int count = 0;
        while (count < n) {
            if (prevIndex < prevSize) { // there is remain chars in buffer
                buf[count++] = prevBuf[prevIndex++];
            } else {
                prevSize = read4(prevBuf);
                prevIndex = 0;
                if (prevSize == 0) { // no more data from stream
                    break;
                }
            }
        }
        return count;
    }
}