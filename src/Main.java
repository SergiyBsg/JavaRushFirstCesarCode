public class Main {
    public static void main(String[] args) {
        if (!(2 <= args.length && args.length <= 3)) {
            args = new CliHelper().typeParameters();
        }
        new Runner().run(args);
    }
}