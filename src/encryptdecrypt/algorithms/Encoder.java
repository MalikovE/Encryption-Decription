package encryptdecrypt.algorithms;

public class Encoder {
    private Algorithm algorithm;

    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public String encode(String message, int key) {
        return this.algorithm.encode(message, key);
    }

    public String decode(String message, int key) {
        return this.algorithm.decode(message, key);
    }
}
