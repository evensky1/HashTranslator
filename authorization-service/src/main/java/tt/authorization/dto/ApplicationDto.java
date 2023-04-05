package tt.authorization.dto;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationDto {
    private String id;
    private ApplicationStatus status;
    private Map<String, String> hashes;
}
