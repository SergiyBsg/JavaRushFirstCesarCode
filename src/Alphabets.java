import java.util.ArrayList;
import java.util.List;

public enum Alphabets {

    ALPHABET_EN('A','a','B','b','C','c','D','d','E','e','F','f','G','g','H','h','I','i','J','j','K','k','L','l','M','m','N','n','O','o','P','p','Q','q','R','r','S','s','T','t','U','u','V','v','W','w','X','x','Y','y','Z','z','.', ',', ' ', '!', '"', '?', '\'', '\n', '-', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'),
    ALPHABET_UA('А','а','Б','б','В','в','Г','г','Ґ','ґ','Д','д','Е','е','Є','є','Ж','ж','З','з','И','и','І','і','Ї','ї','Й','й','К','к','Л','л','М','м','Н','н','О','о','П','п','Р','р','С','с','Т','т','У','у','Ф','ф','Х','х','Ц','ц','Ч','ч','Ш','ш','Щ','щ','Ь','ь','Ю','ю','Я','я');

    Alphabets(char ... chars){
        List<Character> characterList = new ArrayList<>();

        for (char symbol : chars) {
            characterList.add(symbol);
        }

        this.chars = characterList;
    }

    private final List<Character> chars;

    public List<Character> getChars(){
        return chars;
    }
}
