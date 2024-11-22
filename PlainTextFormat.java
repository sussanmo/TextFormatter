import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PlainTextFormat implements IFormat {

    @Override
    public void format(ArrayList<String> fileContent) {
        for (int i = 0; i < fileContent.size(); i++) {
            System.out.println(fileContent.get(i));
        }
    }

    @Override
    public void saveFormat(String filename, ArrayList<String> fileContent){
        try (FileWriter writer = new FileWriter(filename)) {
            for (int i = 0; i < fileContent.size(); i++) {
                writer.write(fileContent.get(i) + "\n");
            }
        }catch (IOException exception){
            System.out.println("Error in saving file");
        }
    }


}
