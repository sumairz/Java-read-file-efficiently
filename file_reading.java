/*

- This code is useful when reading large file line by line.
- This is an optimized way of reading files

*/

package filereading_test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReading_test {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
     
        String path = "{YOUR FILE PATH}";
        
        FileInputStream inputStream = null;
        Scanner sc = null;
        
        try {
			// Some useful data to check how much time and memory file reading is taking
            float startmem = Runtime.getRuntime().freeMemory();
            System.out.println("Free memory>>"+startmem/(1024*1024));
            long startTime = System.currentTimeMillis();
                        
            inputStream = new FileInputStream(path);
            sc = new Scanner(inputStream, "UTF-8");
                        
            int i = 0;            
            while (sc.hasNextLine()) {
                
                String line = sc.nextLine();                
                System.out.println(line); // This will print out each line in the file                
                i++; // counter variable to perform any operation needed on each line like string comparison or manipulation
            }            
            
            long endTime = System.currentTimeMillis();
            long endmem = Runtime.getRuntime().totalMemory();
            System.out.println("Time Taken : " + (endTime - startTime) + "ms");
            System.out.println("Memory Taken (in bytes): " + (endmem - startmem) + " bytes");
            System.out.println("Memory Taken (in MB): " + (double) (endmem - startmem) /(1024*1024) + " MB");
            
            System.gc();
            // note that Scanner suppresses exceptions
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (sc != null) {
                sc.close();
            }
        }
    }
}
