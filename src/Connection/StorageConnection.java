package Connection;

import java.io.BufferedReader;
import java.io.IOException;

public class StorageConnection {
    public String readAllLines(BufferedReader reader) throws IOException {
        StringBuilder content = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            content.append(line);
            content.append(",");
        }

        return content.toString();
    }
}
