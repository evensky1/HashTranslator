package tt.authorization.error.factory.handler;

import java.time.Instant;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ErrorResponse {
    int statusCode;
    String message;
    Instant timestamp = Instant.now();
}
