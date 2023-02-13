import java.util.Scanner;
import java.io.*;

public class ReadFile {
    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\XCT\\Desktop\\textfile.txt");
            Scanner scanner = new Scanner(file);
            try{
                BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\XCT\\Desktop\\textfile1.txt"));
                while(scanner.hasNextLine()){
                    String line = scanner.nextLine();
                    writer.write(line);
                    writer.newLine();
                }
                scanner.close();
                writer.close();
            }
            catch(IOException e){
                System.out.println("Error!");
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found!");
        }
    }
}
