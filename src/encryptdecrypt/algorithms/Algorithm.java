package encryptdecrypt.algorithms;

public interface Algorithm {
    String encode(String message, int key);
    String decode(String message, int key);
}
