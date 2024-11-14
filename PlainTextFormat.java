import java.util.ArrayList;

public class PlainTextFormat implements IFormat {

    @Override
    public void format(ArrayList<String> fileContent) {
        for (int i = 0; i < fileContent.size(); i++) {
            System.out.println(fileContent.get(i));
        }
    }
}
