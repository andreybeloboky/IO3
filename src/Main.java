import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try (FileOutputStream file = new FileOutputStream("test.txt");) {
            String test = "i've checked your tests";
            file.write(test.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (FileOutputStream file2 = new FileOutputStream("test2.txt");
             FileInputStream file1 = new FileInputStream("test.txt");) {
            int byteNumber;
            ArrayList<Integer> array = new ArrayList<>();
            while ((byteNumber = file1.read()) != -1) {
                array.add(byteNumber);
            }
            for (int i = array.size()-1; i >= 0; i--) {
                file2.write(array.get(i));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}