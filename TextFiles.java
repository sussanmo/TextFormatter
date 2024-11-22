import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.logging.XMLFormatter;

public class TextFiles {

    private ArrayList<String> fileContent;
    private IFormat format;

    public TextFiles (ArrayList<String> data){
        fileContent = data;
    }

    public void setFormat(IFormat format){
        this.format = format;
    }

    public void saveFormat(String filename, IFormat format)  {
        this.format = format;
        format.saveFormat(filename, fileContent);
    }




    public void printPlainText(){
        for(int i = 0; i < fileContent.size(); i++) {
            System.out.println(fileContent.get(i));
        }
    }

    public void printHTMLText(){
        System.out.println("<html dir = \"ltr\" lang= \"en\">");
        System.out.println("<head>");
        for(int i = 0; i < fileContent.size(); i++) {
            System.out.println("<text="+fileContent.get(i)+">");
        }

        System.out.println("</head>");
        System.out.println("</html>");
    }

    public void printMarkdownText(){
        String[] options = {"**", "---", "~~", "__"};
        Random rand = new Random();

        System.out.println("#" + fileContent.get(0));
        for(int i = 1; i < fileContent.size(); i++) {
            int number = rand.nextInt(options.length);
            String option = options[number];
            System.out.println(option+fileContent.get(i));
        }


    }

    public void printFormat(){
        format.format(fileContent);
    }



}
