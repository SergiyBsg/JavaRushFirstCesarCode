public class Main {
    public static void main(String[] args) {
        FileService fileService = new FileService("ToPlantGarden.txt");
        String readText = fileService.readFile();
        Coder coder = new Coder(5);
        fileService.writeFile(fileService.getFileName()+"[ENCRYPTED]"+fileService.getFileExtention(), coder.encrypt(readText));
    }
}