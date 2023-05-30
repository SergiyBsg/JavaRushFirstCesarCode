import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

public class FileService {

    private final String filePath;
    private final Charset charset;

    public FileService(String filePath) {
        this.filePath = filePath;
        this.charset = Charset.defaultCharset();
    }

    public FileService(String filePath, Charset charset) {
        this.filePath = filePath;
        this.charset = charset;
    }

    public String readFile() {
        return readFile(this.filePath);
    }

    public String readFile(String filePath) {
        String text = "";
        try (InputStream inputStream = new FileInputStream(filePath)) {
            text = new String(inputStream.readAllBytes(), String.valueOf(this.charset));
        } catch (IOException e) {
            System.out.println("There is no such file '" + filePath + "'");
            e.printStackTrace();
        }
        return text;
    }

    public void writeFile(String text) {
        try (OutputStream outputStream = new FileOutputStream(filePath)) {
            outputStream.write(text.getBytes(this.charset));
        } catch (IOException e) {
            System.out.println("There is no such file '" + filePath + "'");
            e.printStackTrace();
        }
    }

    public void writeFile(String filePath, String text) {
        try (OutputStream outputStream = new FileOutputStream(filePath)) {
            outputStream.write(text.getBytes(this.charset));
        } catch (IOException e) {
            System.out.println("There is no such file '" + filePath + "'");
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
