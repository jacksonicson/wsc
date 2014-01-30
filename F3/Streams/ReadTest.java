import java.io.Reader; 
import java.io.FileReader;
import java.io.IOException;
public class ReadTest {

    public ReadTest() { try {
            Reader r = new FileReader("output.txt"); 
            int c; 
            while((c = r.read()) >= 0) {
                System.out.println("Found new char: " + (char)c);
            }
            r.close(); 
        } catch(IOException e) {
            System.out.println("An error occured: " + e); 
        }
    }

    public static void main(String arg[]) {
        new ReadTest(); 
    }
}
