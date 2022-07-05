import java.io.*;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        try (RandomAccessFile file = new RandomAccessFile("test.txt", "rw");) {
            for (int i = 0; i < 1000000000; i++) {
                file.write("If you need Random Access, you need RandomAccessFile".getBytes());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (RandomAccessFile file = new RandomAccessFile("test.txt", "rw");
             RandomAccessFile file2 = new RandomAccessFile("test2.txt", "rw");) {
            long position = file.length();
            while (position > 0) {
                position -= 1;
                file.seek(position);
                byte b = file.readByte();
                file2.write(b);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}