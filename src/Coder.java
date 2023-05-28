import java.util.ArrayList;
import java.util.List;

public class Coder {
    private int key;


    public Coder() {
    }

    public Coder(int key) {
        this.key = key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String encrypt(String text) {
        char[] lineArray = text.toCharArray();
        char[] newLine = new char[lineArray.length];

        for (int i = 0; i < lineArray.length; i++) {
            char symbol = lineArray[i];
            List<Character> charactersList = getList(symbol);

            if (!charactersList.isEmpty()) {
                int shift = this.key % charactersList.size();
                int newIndex = charactersList.indexOf(symbol) + shift;
                int diff = newIndex - charactersList.size();
                if (diff >= 0) newIndex = diff;
                newLine[i] = charactersList.get(newIndex);
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
            List<Character> charactersList = getList(symbol);

            if (!charactersList.isEmpty()) {
                int shift = key % charactersList.size();
                int newIndex = charactersList.indexOf(symbol) - shift;
                if (newIndex < 0) newIndex += charactersList.size();
                newLine[i] = charactersList.get(newIndex);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (char c : newLine) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public String bruteForce(String text) {
        return "";
    }

    private List<Character> getList(char symbol) {
        List<Character> chars = new ArrayList<>();
        if (Alphabets.ALPHABET_EN.getList().contains(symbol)) {
            chars.addAll(Alphabets.ALPHABET_EN.getList());
        } else if (Alphabets.ALPHABET_UA.getList().contains(symbol)) {
            chars.addAll(Alphabets.ALPHABET_UA.getList());
        }

        return chars;
    }
}
