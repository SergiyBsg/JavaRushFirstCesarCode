import java.io.File;

public class Main {
    public static void main(String[] args) {
        String qw = new FileService("C:\\Users\\sergey.bloschenko\\Projects\\JavaRush\\JavaRushFirstCesarCode\\ToPlantGarden.txt").readFile();
        System.out.println(qw);
        String path = new File("ToPlantGarden.txt").getAbsolutePath();
        System.out.println(path);
    }
}