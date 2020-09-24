package encryptdecrypt.algorithms;

public class Unicode implements Algorithm {
    @Override
    public String encode(String message, int key) {
        StringBuilder result = new StringBuilder();

        for (char character : message.toCharArray()) {
            result.append((char) (character + key));
        }

        return result.toString();
    }

    @Override
    public String decode(String message, int key) {
        StringBuilder result = new StringBuilder();

        for (char character : message.toCharArray()) {
            result.append((char) (character - key));
        }

        return result.toString();
    }
}
