import java.util.List;
import java.util.Scanner;

public class CliHelper {

    public String[] typeParameters(){
        Scanner input = new Scanner(System.in);

        System.out.println("Choose an action [Ee]ncrypt, [Dd]ecrypt, [Bb]ruteforce");
        Actions action;
        boolean result;
        do {
            action = getAction(input.nextLine());
            result = List.of(Actions.values()).contains(action);
            if(!result) System.out.println("Choose an action [Ee]ncrypt, [Dd]ecrypt, [Bb]ruteforce");
        } while (!result);

        assert action != null;
        int argsSize = (action == Actions.ENCRYPT || action == Actions.DECRYPT) ? 3 : 2;

        String[] args = new String[argsSize];
        args[0] = action.name();

        System.out.println("Put a path to a txt file: ");
        args[1] = input.nextLine();

        if (argsSize == 3) {
            System.out.println("Type an integer key: ");
            args[2] = input.nextLine();
        }

        return args;
    }

    public static Actions getAction(String action){
        if (action.startsWith("e") || action.startsWith("E")) {
            return Actions.ENCRYPT;
        } else if (action.startsWith("d") || action.startsWith("D")) {
            return Actions.DECRYPT;
        } else if (action.startsWith("b") || action.startsWith("B")) {
            return Actions.BRUTEFORCE;
        }

        return null;
    }
}
