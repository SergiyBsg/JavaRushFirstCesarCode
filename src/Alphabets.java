public enum Alphabets {

    ALPHABET_EN("AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz_0123456789-. ,«»\"':!?"),
    ALPHABET_UA("АаБбВвГгҐґДдЕеЄєЖжЗзИиІіЇїЙйКкЛлМмНнОоПпРрСсТтУуФфХхЦцЧчШшЩщЬьЮюЯя");

    private final String alphabet;

    Alphabets(String alphabet){
        this.alphabet = alphabet;
    }

    public String getAlphabet(){
        return this.alphabet;
    }
}
