import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

public class TextFiles {

    private ArrayList<String> fileContent;

    public TextFiles (){
        fileContent = new ArrayList<>();
    }

    public TextFiles (ArrayList<String> data){
        fileContent = data;
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




}
