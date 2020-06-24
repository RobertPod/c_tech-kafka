package schemas;

import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;

public class AlertSchema  implements AvroSchema{
    @Override
    public String buildSchema() {
        Schema alertData = SchemaBuilder.record("Alert")
                                          .namespace("com.ctech.consumer1")
                                          .fields()
                                          .requiredString("message")
                                          .endRecord();

        return alertData.toString();
    }
}
