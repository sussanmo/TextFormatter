import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class JSONTextFormatter implements IFormat{
    @Override
    public void format(ArrayList<String> fileContent) {
        System.out.println("{");
        System.out.println("filecontent: " + "[ " + "\n");
        for(int i = 0; i < fileContent.size(); i++) {
            System.out.println("line: "+fileContent.get(i)+ "," + "\n");
            System.out.println("}," + "\n");
        }

        System.out.println("]," + "\n");
        System.out.println("}");
    }

    @Override
    public void saveFormat(String filename, ArrayList<String> fileContent){

        try (FileWriter writer = new FileWriter(filename)) {

            for (int i = 0; i < fileContent.size(); i++) {
                writer.write("<text="+fileContent.get(i)+">" + "\n");
            }
            System.out.println("]," + "\n");
            System.out.println("}");
        }catch (IOException exception){
            System.out.println("Error in saving file");
        }
    }

}
