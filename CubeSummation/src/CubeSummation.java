import java.io.FileNotFoundException;
import java.io.IOException;

public class CubeSummation {

    private String inputPath;
    private String outputPath;
    private IOManager fileController;


    public CubeSummation() {
        this.inputPath= "input.txt";
        this.outputPath="output.txt";
        this.fileController= new IOManager(this.inputPath, this.outputPath);
    }

    private void processCommands(){
        try {
            CommandsController inputController = new CommandsController(this.fileController.readInput());
            inputController.processCommands();
            String [] results = inputController.getResults();
            this.fileController.writeOutput(results);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        CubeSummation summation= new CubeSummation();
        summation.processCommands();
    }

}
