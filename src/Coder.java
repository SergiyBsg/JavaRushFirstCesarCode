import java.util.List;

public class Coder {
    private int key;
    private Alphabets alphabets;
    private List<Character> charactersList;

    public Coder() {
    }

    public Coder(Alphabets alphabets, int key) {
        this.alphabets = alphabets;
        this.key = key;
        this.charactersList = alphabets.getChars();
    }

    public Coder(int key) {
        this.key = key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String encrypt(String text) {
        int shift = key % charactersList.size();
        char[] lineArray = text.toCharArray();
        char[] newLine = new char[lineArray.length];
        for (int i = 0; i < lineArray.length; i++) {
            if (charactersList.contains(lineArray[i])) {
                int newIndex = charactersList.indexOf(lineArray[i]) + shift;
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
        int shift = key % charactersList.size();
        char[] lineArray = text.toCharArray();
        char[] newLine = new char[lineArray.length];
        for (int i = 0; i < lineArray.length; i++) {
            if (charactersList.contains(lineArray[i])) {
                int newIndex = charactersList.indexOf(lineArray[i]) - shift;
                if (newIndex <= 0) newIndex = charactersList.size() + newIndex;
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
}
