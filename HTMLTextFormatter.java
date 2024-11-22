import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class HTMLTextFormatter implements IFormat{
    @Override
    public void format(ArrayList<String> fileContent) {
        System.out.println("<html dir = \"ltr\" lang= \"en\">");
        System.out.println("<head>");
        for(int i = 0; i < fileContent.size(); i++) {
            System.out.println("<text="+fileContent.get(i)+">");
        }

        System.out.println("</head>");
        System.out.println("</html>");
    }

    @Override
    public void saveFormat(String filename, ArrayList<String> fileContent){
        try (FileWriter writer = new FileWriter(filename)) {
            System.out.println("<html dir = \"ltr\" lang= \"en\">");
            System.out.println("<head>");
            for (int i = 0; i < fileContent.size(); i++) {
                writer.write("<text="+fileContent.get(i)+">" + "\n");
            }
            System.out.println("</head>");
            System.out.println("</html>");
        }catch (IOException exception){
            System.out.println("Error in saving file");
        }
    }
}
