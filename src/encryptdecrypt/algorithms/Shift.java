package encryptdecrypt.algorithms;

public class Shift implements Algorithm {
    private static final char LETTER_A = 'a';
    private static final char LETTER_Z = 'z';
    private static final int ALPHABET_SIZE = LETTER_Z - LETTER_A + 1;

    @Override
    public String encode(String message, int key) {
        StringBuilder result = new StringBuilder();

        for (char character : message.toCharArray()) {
            if (character != ' ' && Character.isLetter(character)) {
                boolean isUpperCase = false;
                if (Character.isUpperCase(character)) {
                    isUpperCase = true;
                }
                int originalAlphabetPosition = (isUpperCase ? Character.toLowerCase(character) : character) - LETTER_A;
                int newAlphabetPosition = (originalAlphabetPosition + key) % ALPHABET_SIZE;
                char newCharacter = (char) (LETTER_A + newAlphabetPosition);
                result.append(isUpperCase ? Character.toUpperCase(newCharacter) : newCharacter);
            } else {
                result.append(character);
            }
        }

        return result.toString();
    }

    @Override
    public String decode(String message, int key) {
        return encode(message, ALPHABET_SIZE - (key % ALPHABET_SIZE));
    }
}
