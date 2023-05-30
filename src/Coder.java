import java.util.ArrayList;
import java.util.List;

public class Coder {
    private int key;

    public void setKey(int key) {
        this.key = key;
    }

    public String encrypt(String text) {
        char[] lineArray = text.toCharArray();
        char[] newLine = new char[lineArray.length];

        for (int i = 0; i < lineArray.length; i++) {
            char symbol = lineArray[i];
            String symbolString = String.valueOf(symbol);
            String alphabet = getAlphabet(symbolString);

            if (!alphabet.equals(symbolString)) {
                int shift = this.key % alphabet.length();
                int newIndex = alphabet.indexOf(symbol) + shift;
                int diff = newIndex - alphabet.length();
                if (diff >= 0) newIndex = diff;
                newLine[i] = alphabet.charAt(newIndex);
            } else {
                newLine[i] = symbol;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (char c : newLine) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public String decrypt(String text) {
        return decrypt(this.key, text);
    }

    public String decrypt(int key, String text) {
        char[] lineArray = text.toCharArray();
        char[] newLine = new char[lineArray.length];

        for (int i = 0; i < lineArray.length; i++) {
            char symbol = lineArray[i];
            String symbolString = String.valueOf(symbol);
            String alphabet = getAlphabet(symbolString);

            if (!alphabet.equals(symbolString)) {
                int shift = key % alphabet.length();
                int newIndex = alphabet.indexOf(symbol) - shift;
                if (newIndex < 0) newIndex += alphabet.length();
                newLine[i] = alphabet.charAt(newIndex);
            } else {
                newLine[i] = symbol;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (char c : newLine) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public String bruteForce(String text) {
        int maxKey = Math.max(Alphabets.ALPHABET_UA.getAlphabet().length(), Alphabets.ALPHABET_EN.getAlphabet().length());
        int key = 1;
        String expectedText = "";

        do {
            expectedText = decrypt(key, text);
            for (int i = 0; i < expectedText.length(); i++) {
                if (expectedText.charAt(i) == ',' && i < expectedText.length()-1 && expectedText.charAt(i+1) == ' ') {
                    System.out.println("key is - "+key);
                    return expectedText;
                }
            }
            key++;
        } while (key < maxKey);

        System.out.println("key was not found");
        return "";
    }

    private String getAlphabet(String symbol) {
        if (Alphabets.ALPHABET_EN.getAlphabet().contains(symbol)) {
            return Alphabets.ALPHABET_EN.getAlphabet();
        } else if (Alphabets.ALPHABET_UA.getAlphabet().contains(symbol)) {
            return Alphabets.ALPHABET_UA.getAlphabet();
        }

        return symbol;
    }
}
