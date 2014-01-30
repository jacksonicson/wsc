import java.io.Writer;
import java.io.FileWriter;
import java.io.IOException;
public class WriteTest {

    public WriteTest() { try {
            Writer w = new FileWriter("output.txt"); 
            w.write('h');
            w.write('e');
            w.write('l');
            w.write('l');
            w.write('o');
            w.close(); 
        } catch(IOException e) {
            System.out.println("An error occured: " + e); 
        }
    }

    public static void main(String arg[]) {
        new WriteTest(); 
    }
}
