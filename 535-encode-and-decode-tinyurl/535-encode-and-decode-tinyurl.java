public class Codec {
      String v;
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        v = longUrl;
        return "";
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return v;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));