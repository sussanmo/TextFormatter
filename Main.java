import java.util.ArrayList;

public class Main {

    // Allow user to input document
    // Allow user to input format type

    //Create method for html formatting: < >

    //Create method for markdown formatting: **, ##,

    //Create method for plaint text formatting: return the file

    //Create method for json tex:  { }

    //Create method for xml tex:
    public static void main(String args[]) {

        ArrayList<String> data = new ArrayList<>();
        data.add("Use a simple nn.Embedding layer for the categories, where each category gets mapped to an embedding vector.");
        data.add("This layer would be randomly initialized and trained with the rest of the model, so the embedding vector for each category learns through training.");
        data.add("To incorporate semantic_category and duration_bin as input embeddings alongside the CodeBERT output for method_token, consider concatenating all these embeddings:");
        data.add("However, CodeBERT is primarily trained on code tokens and natural language text, which means it may not inherently capture any relationships between arbitrary labels like semantic_category.");
        TextFiles file = new TextFiles(data);
        file.printPlainText();

        file.printHTMLText();

        file.printMarkdownText();

        int option = 0;
        switch (option){
            case 0:
                file.printPlainText();
                break;
            case 1:
                file.printHTMLText();
                break;
            case 2:
                file.printMarkdownText();
                break;
            default:
                file.printPlainText();
                break;

        }


    }
}
