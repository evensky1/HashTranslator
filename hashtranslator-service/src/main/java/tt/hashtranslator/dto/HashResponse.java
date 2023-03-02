package tt.hashtranslator.dto;

import java.util.Map;
import lombok.Data;

@Data
public class HashResponse {
    Map<String, String> translatedHashes;
}
