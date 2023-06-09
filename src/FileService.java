import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {

    private final String filePath;
    private final Charset charset;

    public FileService(String filePath) {
        this.filePath = filePath;
        this.charset = Charset.defaultCharset();
    }

    public String readFile() {
        return readFile(this.filePath);
    }

    public String readFile(String filePath) {
        String text = "";
        try (InputStream input = Files.newInputStream(Path.of(filePath))) {
            text = new String(input.readAllBytes(), String.valueOf(this.charset));
        } catch (FileNotFoundException e) {
            System.out.println("There is no such file '" + filePath + "'");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    public void writeFile(String filePath, String text) {
        try (OutputStream outputStream = Files.newOutputStream(Path.of(filePath))) {
            outputStream.write(text.getBytes(this.charset));
        } catch (FileNotFoundException e) {
            System.out.println("There is no such file '" + filePath + "'");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFileName(){
        String fileName = Paths.get(filePath).getFileName().toString();
        return fileName.contains(".") ? fileName.substring(0, fileName.lastIndexOf(".")) : fileName;
    }

    public String getFileExtention(){
        String fileName = Paths.get(filePath).getFileName().toString();
        return fileName.contains(".") ? fileName.substring(fileName.lastIndexOf(".")) : "";
    }
}
