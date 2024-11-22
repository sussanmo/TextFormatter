import java.io.File;
import java.util.ArrayList;

public interface IFormat {

    public void format(ArrayList<String> data);

    // return File to later export:
    public void saveFormat(String filename, ArrayList<String> data);
}
