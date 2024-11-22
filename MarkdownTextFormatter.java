import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class MarkdownTextFormatter implements IFormat{
    @Override
    public void format(ArrayList<String> fileContent) {
        String[] options = {"**", "---", "~~", "__"};
        Random rand = new Random();

        System.out.println("#" + fileContent.get(0));
        for(int i = 1; i < fileContent.size(); i++) {
            int number = rand.nextInt(options.length);
            String option = options[number];
            System.out.println(option+fileContent.get(i));
        }
    }

    @Override
    public void saveFormat(String filename, ArrayList<String> fileContent){
        String[] options = {"**", "---", "~~", "__"};
        Random rand = new Random();

        try (FileWriter writer = new FileWriter(filename)) {
            System.out.println("#" + fileContent.get(0));
            for (int i = 1; i < fileContent.size(); i++) {
                int number = rand.nextInt(options.length);
                String option = options[number];
                writer.write(option+fileContent.get(i) + "\n");
            }

        }catch (IOException exception){
            System.out.println("Error in saving file");
        }
    }
}

