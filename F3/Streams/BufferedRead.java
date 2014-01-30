import java.io.BufferedReader; 
import java.io.FileReader;
import java.io.IOException;
public class BufferedRead {

    public BufferedRead() { try {
            BufferedReader r = new BufferedReader(new FileReader("output.txt"));
            String buffer; 
            while((buffer = r.readLine()) != null) {
                System.out.println("Found a line: " + buffer); 
            }
            r.close(); 
        } catch(IOException e) {
            System.out.println("An error occured: " + e); 
        }
    }

    public static void main(String arg[]) {
        new BufferedRead(); 
    }
}
