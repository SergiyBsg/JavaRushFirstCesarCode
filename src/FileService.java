import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

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
            throw new RuntimeException(e);
        }
        return text;
    }

    public void writeFile(String text) {
        try (OutputStream outputStream = new FileOutputStream(filePath)) {
            outputStream.write(text.getBytes(this.charset));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeFile(String filePath, String text) {
    }
}
