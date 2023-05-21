import java.util.List;
import java.util.Objects;

public class Runner {
    private String[] args;

    public Runner(String[] args) {
        this.args = args;
    }

    public void run() {
        int counter = 0;
        while (!List.of(2,3).contains(args.length) && counter < 3) {
            args = new CliHelper().typeParameters();
            counter++;
        }

        if (2 <= args.length && args.length <= 3) {
            Coder coder = new Coder();
            Actions action = CliHelper.getAction(args[0]);
            String filePath = args[1];
            FileService fileService = new FileService(filePath);
            String readText = fileService.readFile();

            if (args.length == 3) {
                coder.setKey(Integer.parseInt(args[2]));
                switch (Objects.requireNonNull(action)) {
                    case ENCRYPT -> fileService.writeFile(coder.encrypt(readText));
                    case DECRYPT -> fileService.writeFile(coder.decrypt(readText));
                    default -> System.out.println("Wrong action is defined");
                }
            } else if (args.length == 2) {
                if (action == Actions.BRUTEFORCE) {
                    fileService.writeFile(coder.bruteForce(readText));
                } else {
                    System.out.println("Wrong action is defined");
                }
            }
        } else {
            System.out.println("Wrong arguments were passed");
        }
    }
}
