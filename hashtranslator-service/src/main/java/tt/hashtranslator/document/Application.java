package tt.hashtranslator.document;

import java.util.Map;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "applications")
@Data
@Builder
public class Application {

    @Id
    private String id;
    private ApplicationStatus status;
    private Map<String, String> hashes;
}
