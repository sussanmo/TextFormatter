import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class XMLFormat implements IFormat{
    @Override
    public void format(ArrayList<String> fileContent) {
        System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
        System.out.println("<filecontent>");
        for(int i = 0; i < fileContent.size(); i++) {
            System.out.println("<line=\""+fileContent.get(i)+"\"/>");
        }

        System.out.println("</filecontent>");

    }

    @Override
    public void saveFormat(String filename, ArrayList<String> fileContent){
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
            writer.write("<filecontent>" + "\n");
            for (int i = 0; i < fileContent.size(); i++) {
                writer.write("<line="+fileContent.get(i)+"/>" + "\n");
            }
            writer.write("</filecontent>");

        }catch (IOException exception){
            System.out.println("Error in saving file");
        }
    }
}
