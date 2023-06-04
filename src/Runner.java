import java.util.Objects;

public class Runner {

    public void run(String[] args) {
        if (2 <= args.length && args.length <= 3) {
            Coder coder = new Coder();
            Actions action = CliHelper.getAction(args[0]);
            String filePath = args[1];
            FileService fileService = new FileService();
            String readText = fileService.readFile(filePath);

            if (args.length == 3) {
                coder.setKey(Integer.parseInt(args[2]));
                switch (Objects.requireNonNull(action)) {
                    case ENCRYPT -> fileService.writeFile(fileService.getFileName()+"[ENCRYPTED]"+fileService.getFileExtention(), coder.encrypt(readText));
                    case DECRYPT -> fileService.writeFile(fileService.getFileName()+"[DECRYPTED]"+fileService.getFileExtention(), coder.decrypt(readText));
                    default -> System.out.println("Wrong action is defined");
                }
            } else {
                if (action == Actions.BRUTEFORCE) {
                    fileService.writeFile(fileService.getFileName()+"[DECRYPTED]"+fileService.getFileExtention(), coder.bruteForce(readText));
                } else {
                    System.out.println("Wrong action is defined");
                }
            }
        } else {
            System.out.println("Wrong arguments were passed");
        }
    }
}
