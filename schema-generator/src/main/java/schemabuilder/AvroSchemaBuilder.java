package schemabuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class AvroSchemaBuilder {

    public static void writeSchemaToAFile(String data, String fileName) {
        OutputStream os = null;
        try {
            File newfile = new File("src/resources/avro/" + fileName);
            os = new FileOutputStream(newfile);
            os.write(data.getBytes(), 0, data.length());
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
