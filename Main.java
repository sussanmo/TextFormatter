import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Allow user to input document
    // Allow user to input format type

    //Create method for html formatting: < >

    //Create method for markdown formatting: **, ##,

    //Create method for plaint text formatting: return the file

    //Create method for json tex:  { }

    //Create method for xml text:
    public static void main(String args[]) {

        ArrayList<String> data = new ArrayList<>();
        data.add("Use a simple nn.Embedding layer for the categories, where each category gets mapped to an embedding vector.");
        data.add("This layer would be randomly initialized and trained with the rest of the model, so the embedding vector for each category learns through training.");
        data.add("To incorporate semantic_category and duration_bin as input embeddings alongside the CodeBERT output for method_token, consider concatenating all these embeddings:");
        data.add("However, CodeBERT is primarily trained on code tokens and natural language text, which means it may not inherently capture any relationships between arbitrary labels like semantic_category.");
        TextFiles file = new TextFiles(data);

        // dynamically switch between types: Plain, HTML, Markdown to preview before choosing final one
        Scanner scanner = new Scanner(System.in);

        while (true) {//int option = 0;
            System.out.println("Choose a format to preview by choosing one of these numbers");
            System.out.println("1 - PlainText, 2 - HTML, 3 - Markdown");
            System.out.println("Type 0 to exit this preview");
            int option = scanner.nextInt();
            switch (option) {
                case 0:
                    System.out.println("Exit Preview");
                    scanner.close();

                case 1:
                    file.setFormat(new PlainTextFormat());
                    file.printPlainText();
                    break;
                case 2:
                    file.setFormat(new HTMLTextFormatter());
                    break;
                case 3:
                    file.setFormat(new MarkdownTextFormatter());
                    break;
                default:
                    file.setFormat(new PlainTextFormat());
                    break;

            }
            file.printFormat();
        }




    }
}
