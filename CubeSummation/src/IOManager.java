import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Class that handles the reading and writing of files
 */
public class IOManager {
    private String inputFile;
    private String outputFile;

    /**
     * Contructor that receives the input and output files path.
     * @param inputFile String that contains the input file path
     * @param outputFile String that contains the output file path
     */
    public IOManager(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    /**
     * Method that read the input commands line by line.
     * @return String array with each line
     * @throws FileNotFoundException
     */
    public String[] readInput() throws FileNotFoundException {
        List<String> lines = new ArrayList<String>();
        File file =new File(this.inputFile);
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }
        String[] linesArray = lines.toArray(new String[0]);

        return linesArray;
    }

    /**
     * Method that writes a String array to a file.
     * @param lines array of lines to be written.
     * @throws IOException
     */
    public void writeOutput(String[] lines) throws IOException {
        FileWriter fw = new FileWriter(this.outputFile);
        for(String line:lines){
            fw.write(line+"\n");
        }
        fw.close();
    }




}
