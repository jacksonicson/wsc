import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copy {
    public Copy() {
        try {
            FileInputStream in = new FileInputStream("output.txt"); 
            FileOutputStream out = new FileOutputStream("output.txt.bkp"); 
            byte[] buffer = new byte[32]; int i; 
            while((i = in.read(buffer)) > 0) {
                out.write(buffer, 0, i); 
            }
            in.close();
            out.close();
        } catch(IOException e) {
            System.out.println("Error occured" + e); 
        }
    }
    
    public static void main(String arg[]) {
        new Copy(); 
    }
}
