import java.util.ArrayList;

/**
 * Class that controls the command operations and matrix creation
 */
public class CommandsController {
    private String[] commands;
    private ArrayList<String> results;

    /**
     * Contructor that receives the and String array of commands
     * @param commands
     */
    public CommandsController(String[] commands) {
        this.commands = commands;
        this.results=new ArrayList<String>();
    }

    /**
     * Reads each command and process it depending on the kind of command:
     * 1. Matrix creation
     * 2. Matrix UPDATE
     * 3. Matrix QUERY
     */
    public void processCommands(){
        int testCases=Integer.parseInt(this.commands[0]);
        int cubeMatrixDim=0;
        int numbOperations=0;
        Matrix3D cube = new Matrix3D(0);
        for(int i=1; i<this.commands.length;i++){
            String command=commands[i];
            String[] commandValues= command.split(" ");

            if(!(command.contains("UPDATE")||command.contains("QUERY"))){
                /**
                 * Matrix creation
                  */
                int cubeDim=Integer.parseInt(commandValues[0]);
                cube=new Matrix3D(cubeDim);
            }else if(command.contains("UPDATE")){
                /**
                 *  Matrix UPDATE
                 */
                int x = Integer.parseInt(commandValues[1]);
                int y = Integer.parseInt(commandValues[2]);
                int z = Integer.parseInt(commandValues[3]);
                long W = Long.parseLong(commandValues[4]);
                cube.update(x,y,z,W);
            }else if(command.contains("QUERY")){
                /**
                 * Matrix QUERY
                 */
                int x1 = Integer.parseInt(commandValues[1]);
                int y1 = Integer.parseInt(commandValues[2]);
                int z1 = Integer.parseInt(commandValues[3]);
                int x2 = Integer.parseInt(commandValues[4]);
                int y2 = Integer.parseInt(commandValues[5]);
                int z2 = Integer.parseInt(commandValues[6]);
                int[] coord1={x1,y1,z1};
                int[] coord2 ={x2,y2,z2};
                String result = ""+cube.query(coord1,coord2);
                results.add(result);
                System.out.println(result);
            }

        }

    }

    /**
     * Method that returns the results as an String array
     * @return
     */
    public String[] getResults(){
        return results.toArray(new String[0]);
    }



}
